package com.logistic.service.services;

import org.springframework.stereotype.Service;

import com.logistic.service.model.Order;
import com.logistic.service.model.Product;
import com.logistic.service.repository.OrderRepository;
import com.logistic.service.repository.ProductRepository;

/**
 * Class define Order services
 * 
 * @author nelson-penagos
 *
 */
@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final ProductService productService;
	
	public OrderService(OrderRepository orderRepository, ProductService productService) {
		this.orderRepository = orderRepository;
		this.productService = productService;
	}
	
	/**
	 * Save Order with products
	 * @param order
	 * @return
	 */
	public Order create(Order order) {
		this.orderRepository.save(order);
		for (Product product : order.getProducts()) {
			product.setOrder(order);
			this.productService.create(product);
		}
		return order;
	}
}
