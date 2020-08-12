package com.onlinefood.resteasy.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderLineItem {
	
	@Id
	@GeneratedValue
	private int orderLineItemId;
	
	private int orderId;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderedBy")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderDishId")
	private Dish dish;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderVendorId")
	private Vendor vendor;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	private int quantity;

	public int getOrderLineItemId() {
		return orderLineItemId;
	}

	public void setOrderLineItemId(int orderLineItemId) {
		this.orderLineItemId = orderLineItemId;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
