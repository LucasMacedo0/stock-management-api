package com.stockmanagementapi.repository;

import com.stockmanagementapi.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface RepositoryProduct extends JpaRepository<product, Long> {

    List<product> findByBrand(String name);

    product findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
