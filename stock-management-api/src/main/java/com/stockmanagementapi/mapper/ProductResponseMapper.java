package com.stockmanagementapi.mapper;

import com.stockmanagementapi.dto.ProductResponseDto;
import com.stockmanagementapi.model.product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductResponseMapper {

    ProductResponseMapper INSTANCE = Mappers.getMapper(ProductResponseMapper.class);

    ProductResponseDto productResponseDtoToProduct(product product);
}
