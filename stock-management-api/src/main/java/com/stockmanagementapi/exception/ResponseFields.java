package com.stockmanagementapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseFields {

    private String campo;
    private String ValorRejeitado;
    private String mensagem;

}

