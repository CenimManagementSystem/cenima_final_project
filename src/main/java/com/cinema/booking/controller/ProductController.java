package com.cinema.booking.controller;

import com.cinema.booking.dto.products.ProductRequestDto;
import com.cinema.booking.dto.products.ProductResponseDto;
import com.cinema.booking.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> create(
            @Valid @ModelAttribute ProductRequestDto dto,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        return new ResponseEntity<>(productService.create(dto, image), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> update(
            @PathVariable Long id,
            @Valid @ModelAttribute ProductRequestDto dto,
            @RequestParam(value = "image", required = false) MultipartFile image) {
        return ResponseEntity.ok(productService.update(id, dto, image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}