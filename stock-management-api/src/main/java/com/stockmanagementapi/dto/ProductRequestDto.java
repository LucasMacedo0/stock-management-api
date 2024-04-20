package com.stockmanagementapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "Nome do Produto é Obrigatorio")
    @Size(max = 100, message = "Tamanho maximo do Nome é de 100 character")
    private String name;

    @NotBlank(message = "Marca do Produto é Obrigatoria")
    @Size(max = 50)
    private String brand;

    @NotNull(message = "Preço do Produto é Obrigatoria")
    private Double price;

    @NotNull(message = "Quantidade em estoque é obrigatorio")
    private Integer quantityInStock;

    @NotNull(message = "A data de entrada é obrigatória")
    @PastOrPresent(message = "A data de entrada deve ser no passado ou no presente")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEntry;

    @NotNull(message = "Status do Produto é Obrigatorio")
    private StatusEnumDto status;

}
