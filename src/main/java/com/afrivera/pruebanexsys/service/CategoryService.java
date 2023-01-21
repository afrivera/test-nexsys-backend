package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.CategoryDto;
import com.afrivera.pruebanexsys.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    Long randomCategoryId();
}
