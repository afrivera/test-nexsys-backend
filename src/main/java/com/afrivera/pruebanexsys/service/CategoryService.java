package com.afrivera.pruebanexsys.service;

import com.afrivera.pruebanexsys.dto.response.CategoryGetAllDto;

import java.util.List;

public interface CategoryService {
    List<CategoryGetAllDto> getAllCategories();

    Long randomCategoryId();
}
