package com.cinema.booking.controller;

import com.cinema.booking.enums.Role;
import com.cinema.booking.dto.auth.LoginRequestDto;
import com.cinema.booking.dto.auth.RegisterRequestDto;
import com.cinema.booking.entity.User;
import com.cinema.booking.repository.UserRepository;
import com.cinema.booking.security.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    private User testUser;
    private User testAdmin;

    @BeforeEach
    void setUp() {
        userRepository.deleteAllInBatch();

        testUser = new User();
        testUser.setUsername("user1");
        testUser.setEmail("user@example.com");
        testUser.setPassword(passwordEncoder.encode("password123"));
        testUser.setName("Normal User");
        testUser.setRole(Role.USER);
        testUser.setStatus("ACTIVE");
        testUser.setCreatedAt(LocalDateTime.now());
        testUser.setUpdatedAt(LocalDateTime.now());
        userRepository.save(testUser);

        testAdmin = new User();
        testAdmin.setUsername("admin1");
        testAdmin.setEmail("admin@example.com");
        testAdmin.setPassword(passwordEncoder.encode("admin123"));
        testAdmin.setName("Admin User");
        testAdmin.setRole(Role.ADMIN);
        testAdmin.setStatus("ACTIVE");
        testAdmin.setCreatedAt(LocalDateTime.now());
        testAdmin.setUpdatedAt(LocalDateTime.now());
        userRepository.save(testAdmin);
    }

    @Test
    void register_Successful() throws Exception {
        RegisterRequestDto dto = RegisterRequestDto.builder()
                .username("newuser")
                .email("newuser@example.com")
                .password("Password123")
                .build();

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Registration successful"))
                .andExpect(jsonPath("$.user.username").value("newuser"))
                .andExpect(jsonPath("$.user.email").value("newuser@example.com"))
                .andExpect(jsonPath("$.user.role").value("ROLE_USER"));
    }

    @Test
    void register_DuplicateUsername_Returns409() throws Exception {
        RegisterRequestDto dto = RegisterRequestDto.builder()
                .username("user1")
                .email("unique@example.com")
                .password("Password123")
                .build();

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isConflict());
    }

    @Test
    void register_DuplicateEmail_Returns409() throws Exception {
        RegisterRequestDto dto = RegisterRequestDto.builder()
                .username("uniqueuser")
                .email("user@example.com")
                .password("Password123")
                .build();

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isConflict());
    }

    @Test
    void register_InvalidEmail_Returns400() throws Exception {
        RegisterRequestDto dto = RegisterRequestDto.builder()
                .username("invalidemailuser")
                .email("not-an-email")
                .password("Password123")
                .build();

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void register_ShortPassword_Returns400() throws Exception {
        RegisterRequestDto dto = RegisterRequestDto.builder()
                .username("shortpassuser")
                .email("shortpass@example.com")
                .password("short")
                .build();

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void login_Successful() throws Exception {
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("user1")
                .email("user@example.com")
                .password("password123")
                .build();

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accessToken").exists())
                .andExpect(jsonPath("$.user.username").value("user1"))
                .andExpect(jsonPath("$.user.email").value("user@example.com"))
                .andExpect(jsonPath("$.user.role").value("ROLE_USER"));
    }

    @Test
    void login_InvalidPassword_Returns401() throws Exception {
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("user1")
                .email("user@example.com")
                .password("wrongpassword")
                .build();

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void login_NonExistentUser_Returns401() throws Exception {
        LoginRequestDto dto = LoginRequestDto.builder()
                .username("nobody")
                .email("nobody@example.com")
                .password("password123")
                .build();

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void protectedEndpoint_MissingJwt_Returns401() throws Exception {
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isUnauthorized());
    }

    @Autowired
    private org.springframework.security.core.userdetails.UserDetailsService userDetailsService;

    @Test
    void protectedEndpoint_ValidUserJwt_AccessGranted() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(testUser.getUsername());
        String token = jwtService.generateToken(userDetails);

        mockMvc.perform(get("/api/movies")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void adminEndpoint_UserAccess_Returns403() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(testUser.getUsername());
        String token = jwtService.generateToken(userDetails);

        mockMvc.perform(post("/api/movies")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isForbidden());
    }

    @Test
    void adminEndpoint_AdminAccess_Allowed() throws Exception {
        UserDetails adminDetails = userDetailsService.loadUserByUsername(testAdmin.getUsername());
        String token = jwtService.generateToken(adminDetails);

        // Sending bad json content returns 400 bad request instead of 403 forbidden, which proves role authorization passed!
        mockMvc.perform(post("/api/movies")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void swaggerEndpoint_PubliclyAccessible() throws Exception {
        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk());
    }
}
