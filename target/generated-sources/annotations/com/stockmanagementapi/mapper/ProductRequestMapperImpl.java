package com.stockmanagementapi.mapper;

import com.stockmanagementapi.dto.ProductRequestDto;
import com.stockmanagementapi.dto.StatusEnumDto;
import com.stockmanagementapi.model.StatusEnum;
import com.stockmanagementapi.model.product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-20T19:53:49-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ProductRequestMapperImpl implements ProductRequestMapper {

    @Override
    public product productRequestDtoToProduct(ProductRequestDto productRequestDto) {
        if ( productRequestDto == null ) {
            return null;
        }

        product product = new product();

        product.setName( productRequestDto.getName() );
        product.setBrand( productRequestDto.getBrand() );
        product.setPrice( productRequestDto.getPrice() );
        product.setQuantityInStock( productRequestDto.getQuantityInStock() );
        product.setDateEntry( productRequestDto.getDateEntry() );
        product.setStatus( statusEnumDtoToStatusEnum( productRequestDto.getStatus() ) );

        return product;
    }

    protected StatusEnum statusEnumDtoToStatusEnum(StatusEnumDto statusEnumDto) {
        if ( statusEnumDto == null ) {
            return null;
        }

        StatusEnum statusEnum;

        switch ( statusEnumDto ) {
            case DISPONIVEL: statusEnum = StatusEnum.DISPONIVEL;
            break;
            case NAO_DISPONIVEL: statusEnum = StatusEnum.NAO_DISPONIVEL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + statusEnumDto );
        }

        return statusEnum;
    }
}
