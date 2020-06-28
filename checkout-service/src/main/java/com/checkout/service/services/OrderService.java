package com.checkout.service.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checkout.service.model.Order;
import com.checkout.service.repository.OrderRepository;

/**
 * Class define Order services
 * 
 * @author nelson-penagos
 *
 */
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	/**
	 * Save Order
	 * @param order
	 * @return
	 */
	@Transactional
	public Order create(Order order) {
		return this.orderRepository.save(order);
	}
}
