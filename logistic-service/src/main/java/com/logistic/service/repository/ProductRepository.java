package com.logistic.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logistic.service.model.Product;


/**
 * Interface to define operations with products
 * 
 * @author nelson-penagos
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
