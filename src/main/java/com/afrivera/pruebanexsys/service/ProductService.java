package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductEntity saveProduct(ProductEntity productEntity);
}
