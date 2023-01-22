package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.afrivera.pruebanexsys.dto.response.ProductResponseDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductResponseDto saveProduct(ProductRequestInternalDto productRequestInternalDto);
}
