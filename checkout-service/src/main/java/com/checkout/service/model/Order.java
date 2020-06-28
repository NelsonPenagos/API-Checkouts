package com.checkout.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class that represents the table ORDERS
 * 
 * @author nelson-penagos
 *
 */
@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clientId;
	private Date date;
	private String direction;	
	@OneToMany(mappedBy = "order")
	private List<Product> products;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

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
