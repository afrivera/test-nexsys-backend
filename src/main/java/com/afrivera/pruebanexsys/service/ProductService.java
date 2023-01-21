package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;

public interface ProductService {
    ProductDto[] getAllProducts();

    ProductEntity saveProduct(ProductEntity productEntity);
}
