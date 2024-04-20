package com.stockmanagementapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "price", length = 50)
    private Double price;

    @Column(name = "quantityInStock", length = 50)
    private Integer quantityInStock;

    @Column(name = "dateEntry", length = 50)
    private LocalDate dateEntry;

    @Column(name = "Status", length = 50)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
