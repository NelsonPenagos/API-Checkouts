package com.bill.service.resources.vo;

import java.util.Date;
import java.util.List;

/**
 * Class that represents the table ORDERS
 * 
 * @author nelson-penagos
 *
 */

public class OrderVO {
	
	private Date date;
	private String direction;
	private String state_order;
	private List<ProductVO> products;

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

	public List<ProductVO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVO> products) {
		this.products = products;
	}

	public String getState_order() {
		return state_order;
	}

	public void setState_order(String state_order) {
		this.state_order = state_order;
	}
	
}
