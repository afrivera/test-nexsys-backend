package com.afrivera.pruebanexsys.service.impl;

import com.afrivera.pruebanexsys.dto.response.CategoryGetAllDto;
import com.afrivera.pruebanexsys.mapper.CategoryMapper;
import com.afrivera.pruebanexsys.model.entity.CategoryEntity;
import com.afrivera.pruebanexsys.service.AbstractClient;
import com.afrivera.pruebanexsys.service.CategoryService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends AbstractClient implements CategoryService {

    private final CategoryMapper categoryMapper;

    protected CategoryServiceImpl(RestTemplate restTemplate, CategoryMapper categoryMapper) {
        super(restTemplate);
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryGetAllDto> getAllCategories() {
        String uri = baseUrl + "/categories";
        ResponseEntity<CategoryEntity[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, CategoryEntity[].class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.stream(response.getBody()).map(category -> categoryMapper.categoryEntityToCategoryDto(category)).collect(Collectors.toList());

        }

        throw new RuntimeException("There was an error");
    }

    @Override
    public Long randomCategoryId(){
        List<CategoryGetAllDto> categories = getAllCategories();
        Random random = new Random();
        return categories.get(random.nextInt(categories.size()-1)).getCid();
    }
}
