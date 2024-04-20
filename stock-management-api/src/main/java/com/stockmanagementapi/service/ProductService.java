package com.stockmanagementapi.service;

import com.stockmanagementapi.dto.ProductRequestDto;
import com.stockmanagementapi.dto.ProductResponseDto;
import com.stockmanagementapi.exception.ProductNotFoundException;
import com.stockmanagementapi.mapper.ProductRequestMapper;
import com.stockmanagementapi.mapper.ProductResponseMapper;
import com.stockmanagementapi.model.product;
import com.stockmanagementapi.repository.RepositoryProduct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    RepositoryProduct repositoryProduct;

    public ProductResponseDto registerProduct(ProductRequestDto productRequestDto) {
        if (repositoryProduct.existsByName(productRequestDto.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto com o nome '" + productRequestDto.getName() + "' já está registrado.");
        }
        product productConverted = ProductRequestMapper.INSTANCE.productRequestDtoToProduct(productRequestDto);
        product productSaved = repositoryProduct.save(productConverted);
        return ProductResponseMapper.INSTANCE.productResponseDtoToProduct(productSaved);
    }

    public List<ProductResponseDto> getProductByBrand(String name) {
        List<product> productsCaptured = repositoryProduct.findByBrand(name);
        verifyProductByBrand(name, productsCaptured);

        return productsCaptured.stream()
                .map(ProductResponseMapper.INSTANCE::productResponseDtoToProduct)
                .collect(Collectors.toList());
    }


    public ProductResponseDto updateProductByName(String name, Map<String, Object> updates) {
        product produtoExistente = repositoryProduct.findByName(name);

        BeanWrapperImpl wrapper = new BeanWrapperImpl(produtoExistente);
        updates.forEach((propertyName, value) -> {
            if (wrapper.isWritableProperty(propertyName)) {
                wrapper.setPropertyValue(propertyName, value);
            }
        });

        product produtoSalvo = repositoryProduct.save(produtoExistente);
        return ProductResponseMapper.INSTANCE.productResponseDtoToProduct(produtoSalvo);
    }

    public void deleteProductByName(String name) {

        product produtoExistente = repositoryProduct.findByName(name);

        if (produtoExistente.getName().equals(name)) {
            repositoryProduct.deleteByName(name);
        }
        ResponseEntity.notFound();
    }

    private void verifyProductByBrand(String name, List<product> products) {
        if (products == null || products.isEmpty()) {
            List<String> errors = List.of("Produto com a Marca '" + name + "' não encontrado.");
            throw new ProductNotFoundException("Produto não encontrado", errors);
        }
    }

}
