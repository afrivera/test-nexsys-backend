package com.afrivera.pruebanexsys.controller;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.dto.response.ProductResponseDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;
import com.afrivera.pruebanexsys.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexsys/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }
}
