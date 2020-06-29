package com.checkout.service.resources.vo;

import java.util.Date;
import java.util.List;

/**
 * Class that represents the table BILL
 * 
 * @author nelson-penagos
 *
 */

public class BillVO {

	private Date date;
	private OrderVO orderId;
	private List<Product> product;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public OrderVO getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderVO orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
