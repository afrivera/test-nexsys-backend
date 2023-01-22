package com.afrivera.pruebanexsys.mapper;

import com.afrivera.pruebanexsys.dto.ProductDto;
import com.afrivera.pruebanexsys.dto.request.ProductRequestCloudDto;
import com.afrivera.pruebanexsys.dto.request.ProductRequestInternalDto;
import com.afrivera.pruebanexsys.dto.response.ProductResponseDto;
import com.afrivera.pruebanexsys.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "pid"),
            @Mapping(source = "title", target = "name"),
            @Mapping(source = "price", target = "priceFinal")
    })
    ProductDto productEntityToProductDto(ProductEntity productEntity);

    @Mapping(source = "id", target = "pid")
    ProductResponseDto productEntityToProductResponseDto(ProductEntity productEntity);

    @Mappings({
            @Mapping(source = "name", target = "title"),
            @Mapping(source = "priceFinal", target = "price")
    })
    ProductRequestCloudDto productDtoToProductRequestDto(ProductRequestInternalDto productRequestInternalDto);
}
