package com.afrivera.pruebanexsys.service.impl;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.dto.request.ProductRequestDto;
import com.afrivera.pruebanexsys.dto.response.ProductResponseDto;
import com.afrivera.pruebanexsys.mapper.ProductMapper;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;
import com.afrivera.pruebanexsys.service.AbstractClient;
import com.afrivera.pruebanexsys.service.CategoryService;
import com.afrivera.pruebanexsys.service.ProductService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends AbstractClient implements ProductService {

    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    protected ProductServiceImpl(RestTemplate restTemplate, ProductMapper productMapper, CategoryService categoryService) {
        super(restTemplate);
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductDto> getAllProducts(){
        String uri = baseUrl + "/products";
        ResponseEntity<ProductEntity[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, ProductEntity[].class
        );
        if(response.getStatusCode().is2xxSuccessful()){
            return Arrays.stream(response.getBody()).map(product -> productMapper.productEntityToProductDto(product)).collect(Collectors.toList());
        }
        throw  new RuntimeException("there was an error");
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto){
        String uri = baseUrl + "/products";
        ProductRequestDto requestDto = productMapper.productDtoToProductRequestDto(productDto);
        requestDto.setCategoryId(categoryService.randomCategoryId());
        requestDto.addImage("https://maite.site/media/imagenBlog/java.spring_y6FD96U.png");
        ResponseEntity<ProductEntity> response = restTemplate.postForEntity(uri, requestDto, ProductEntity.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return productMapper.productEntityToProductResponseDto(response.getBody());
        }
        throw new RuntimeException("There was an error");
    }
}
