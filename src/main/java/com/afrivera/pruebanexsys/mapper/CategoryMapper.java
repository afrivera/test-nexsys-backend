package com.afrivera.pruebanexsys.mapper;

import com.afrivera.pruebanexsys.dto.CategoryDto;
import com.afrivera.pruebanexsys.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity);
}
