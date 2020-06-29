package com.logistic.service.resources.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.logistic.service.model.Product;

/**
 * Class that represents the table BILL
 * 
 * @author nelson-penagos
 *
 */

public class BillVO implements Serializable{

	private Date date;
	private Integer orderId;
	private List<ProductVO> product;

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

	public List<ProductVO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductVO> product) {
		this.product = product;
	}

}
