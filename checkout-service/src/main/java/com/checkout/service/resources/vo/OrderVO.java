package com.checkout.service.resources.vo;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.checkout.service.model.Product;

/**
 * Class that represents the table ORDERS
 * 
 * @author nelson-penagos
 *
 */

public class OrderVO {
	
	private Date date;
	private String direction;
	private ArrayList<Product> products;

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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
