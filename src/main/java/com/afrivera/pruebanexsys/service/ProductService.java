package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();

    ProductEntity saveProduct(ProductEntity productEntity);
}
