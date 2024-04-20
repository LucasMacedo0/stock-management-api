package com.stockmanagementapi.exception.handle;


import com.stockmanagementapi.exception.ErrorResponse;
import com.stockmanagementapi.exception.GenericErrorResponse;
import com.stockmanagementapi.exception.ProductNotFoundException;
import com.stockmanagementapi.exception.ResponseFields;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomResponseEntityExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseFields>> customValidationErrorHandling(MethodArgumentNotValidException ex) {
        List<ResponseFields> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            ResponseFields error = new ResponseFields();
            error.setCampo(fieldError.getField());
            String rejectedValue = fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : "null";
            error.setValorRejeitado(rejectedValue);
            error.setMensagem(fieldError.getDefaultMessage());
            errors.add(error);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GenericErrorResponse> handleResponseStatusException(ResponseStatusException ex) {

        String status = ex.getStatusCode().toString();
        String reason = ex.getReason() != null ? ex.getReason() : "Erro desconhecido";

        GenericErrorResponse errorResponse = new GenericErrorResponse(
                status,
                "Ocorreu um erro ao processar a sua requisição.",
                reason
        );

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
