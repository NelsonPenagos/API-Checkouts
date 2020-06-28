package com.checkout.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkout.service.model.Order;

/**
 * Interface to define operations with orders
 * 
 * @author nelson-penagos
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
