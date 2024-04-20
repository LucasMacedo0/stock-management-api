package com.stockmanagementapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericErrorResponse {

    private String status;
    private String message;
    private String detail;
}
