package com.checkout.service.resources.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class that represents the table ORDERS
 * 
 * @author nelson-penagos
 *
 */

public class OrderVO implements Serializable{
	
	private Date date;
	private String direction;
	private List<Product> products;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
