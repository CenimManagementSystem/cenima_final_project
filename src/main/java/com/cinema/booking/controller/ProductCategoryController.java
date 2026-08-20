package com.cinema.booking.controller;

import com.cinema.booking.dto.productcategories.ProductCategoryRequestDto;
import com.cinema.booking.dto.productcategories.ProductCategoryResponseDto;
import com.cinema.booking.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<ProductCategoryResponseDto> create(@Valid @RequestBody ProductCategoryRequestDto dto) {
        return new ResponseEntity<>(productCategoryService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDto> update(@PathVariable Long id, @Valid @RequestBody ProductCategoryRequestDto dto) {
        return ResponseEntity.ok(productCategoryService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productCategoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponseDto>> getAll() {
        return ResponseEntity.ok(productCategoryService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
