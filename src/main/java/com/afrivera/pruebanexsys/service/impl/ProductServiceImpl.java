package com.afrivera.pruebanexsys.service.impl;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.mapper.ProductMapper;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;
import com.afrivera.pruebanexsys.service.AbstractClient;
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
    protected ProductServiceImpl(RestTemplate restTemplate, ProductMapper productMapper) {
        super(restTemplate);
        this.productMapper = productMapper;
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
    public ProductEntity saveProduct(ProductEntity productEntity){
        return null;
    }
}
