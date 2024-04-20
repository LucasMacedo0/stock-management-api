package com.stockmanagementapi.mapper;

import com.stockmanagementapi.dto.ProductResponseDto;
import com.stockmanagementapi.dto.StatusEnumDto;
import com.stockmanagementapi.model.StatusEnum;
import com.stockmanagementapi.model.product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-20T19:53:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ProductResponseMapperImpl implements ProductResponseMapper {

    @Override
    public ProductResponseDto productResponseDtoToProduct(product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setName( product.getName() );
        productResponseDto.setBrand( product.getBrand() );
        productResponseDto.setPrice( product.getPrice() );
        productResponseDto.setQuantityInStock( product.getQuantityInStock() );
        productResponseDto.setDateEntry( product.getDateEntry() );
        productResponseDto.setStatus( statusEnumToStatusEnumDto( product.getStatus() ) );

        return productResponseDto;
    }

    protected StatusEnumDto statusEnumToStatusEnumDto(StatusEnum statusEnum) {
        if ( statusEnum == null ) {
            return null;
        }

        StatusEnumDto statusEnumDto;

        switch ( statusEnum ) {
            case DISPONIVEL: statusEnumDto = StatusEnumDto.DISPONIVEL;
            break;
            case NAO_DISPONIVEL: statusEnumDto = StatusEnumDto.NAO_DISPONIVEL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + statusEnum );
        }

        return statusEnumDto;
    }
}
