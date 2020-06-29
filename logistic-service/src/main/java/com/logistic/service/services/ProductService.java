package com.logistic.service.services;

import org.springframework.stereotype.Service;

import com.logistic.service.model.Product;
import com.logistic.service.repository.ProductRepository;

/**
 * Class define Product services
 * 
 * @author nelson-penagos
 *
 */
@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	/**
	 * Save product of order
	 * @param product
	 * @return
	 */
	public Product create(Product product) {
		return this.productRepository.save(product);
	}

}
