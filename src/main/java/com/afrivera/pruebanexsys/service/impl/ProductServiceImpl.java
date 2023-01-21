package com.afrivera.pruebanexsys.service.impl;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;
import com.afrivera.pruebanexsys.service.AbstractClient;
import com.afrivera.pruebanexsys.service.ProductService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl extends AbstractClient implements ProductService {


    protected ProductServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public ProductDto[] getAllProducts(){
        String uri = baseUrl + "/products";
        ResponseEntity<ProductDto[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, null, ProductDto[].class
        );
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        throw  new RuntimeException("there was an error");
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        return null;
    }
}
