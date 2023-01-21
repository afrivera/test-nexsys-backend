package com.afrivera.pruebanexsys.controller;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nexsys/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
