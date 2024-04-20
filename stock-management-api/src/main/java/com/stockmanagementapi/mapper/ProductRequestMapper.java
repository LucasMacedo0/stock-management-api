package com.stockmanagementapi.mapper;

import com.stockmanagementapi.dto.ProductRequestDto;
import com.stockmanagementapi.model.product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRequestMapper {

    ProductRequestMapper INSTANCE = Mappers.getMapper(ProductRequestMapper.class);

    product productRequestDtoToProduct(ProductRequestDto productRequestDto);

}
