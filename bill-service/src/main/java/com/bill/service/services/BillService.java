package com.bill.service.services;

import org.springframework.stereotype.Service;

import com.bill.service.model.Bill;
import com.bill.service.repository.BillRepository;

/**
 * Class define Bill services
 * 
 * @author nelson-penagos
 *
 */
@Service
public class BillService {
	private final BillRepository billRepository;

	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	public Bill create(Bill bill) {
		return this.billRepository.save(bill);
	}

}
