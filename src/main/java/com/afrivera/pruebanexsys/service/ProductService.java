package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.response.ProductGetAllDto;
import com.afrivera.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.afrivera.pruebanexsys.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductGetAllDto> getAllProducts();

    ProductResponseDto saveProduct(ProductRequestInternalDto productRequestInternalDto);
}
