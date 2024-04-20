package com.stockmanagementapi.exception;

import java.util.List;

public class ProductNotFoundException extends RuntimeException{

    private List<String> errors;

    public ProductNotFoundException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
