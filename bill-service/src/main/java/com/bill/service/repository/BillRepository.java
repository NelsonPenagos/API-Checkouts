package com.bill.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.service.model.Bill;

/**
 * 
 * Interface to define operations with Bill
 * 
 * @author nelson-penagos
 *
 */
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
