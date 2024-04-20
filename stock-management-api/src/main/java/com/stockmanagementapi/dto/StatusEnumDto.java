package com.stockmanagementapi.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusEnumDto {

    DISPONIVEL("DISPONIVEL"),
    NAO_DISPONIVEL("NÃO_DISPONIVEL");

    private final String value;

    StatusEnumDto(String value) {
        this.value = value;
    }

    public static StatusEnumDto fromValue(String value) {
        return Arrays.stream(StatusEnumDto.values())
                .filter(enumValue -> enumValue.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + value));
    }

}

