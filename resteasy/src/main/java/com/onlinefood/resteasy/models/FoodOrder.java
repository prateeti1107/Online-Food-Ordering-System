package com.onlinefood.resteasy.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToMany(targetEntity=OrderLineItem.class, 
			fetch = FetchType.LAZY)
	private List<OrderLineItem> orderLineItem;
	
	private double totalPrice;
	
	private Date orderDate;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderLineItem> getOrderLineItem() {
		return orderLineItem;
	}

	public void setOrderLineItem(List<OrderLineItem> orderLineItem) {
//		for(OrderLineItem orderLine: orderLineItem) {
//			orderLine.setOnlineOrder(this);
//		}
		this.orderLineItem = orderLineItem;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
