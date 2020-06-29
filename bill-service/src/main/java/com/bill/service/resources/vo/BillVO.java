package com.bill.service.resources.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class that represents the table BILL
 * 
 * @author nelson-penagos
 *
 */

public class BillVO implements Serializable{

	private Date date;
	private Integer orderId;
	private List<Product> product;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
