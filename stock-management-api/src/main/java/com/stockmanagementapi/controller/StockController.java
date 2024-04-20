package com.stockmanagementapi.controller;

import com.stockmanagementapi.dto.ProductRequestDto;
import com.stockmanagementapi.dto.ProductResponseDto;
import com.stockmanagementapi.service.ProductService;
import com.stockmanagementapi.validation.ValidateRequestDtoProducts;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Slf4j
public class StockController {
    @Autowired
    ProductService productService;

    ValidateRequestDtoProducts va;


    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> registerProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        var response = productService.registerProduct(productRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/products/{brand}")
    public ResponseEntity<List<ProductResponseDto>> getProductByName(@PathVariable String brand) {
        var response = productService.getProductByBrand(brand);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PatchMapping("/products/{name}")
    public ResponseEntity<ProductResponseDto> updateProductByName(@PathVariable String name, @RequestBody Map<String, Object> productRequestDto) {
        var response = productService.updateProductByName(name, productRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/products/{name}")
    public ResponseEntity deleteProductByName(@PathVariable String name) {
        productService.deleteProductByName(name);
        return ResponseEntity.noContent().build();
    }

}
