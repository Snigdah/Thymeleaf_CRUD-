package com.crudThymeleaf.beststore.services;

import com.crudThymeleaf.beststore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
