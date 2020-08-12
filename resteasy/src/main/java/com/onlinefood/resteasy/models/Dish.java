package com.onlinefood.resteasy.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dish implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int dishId;
	
	private String dishName;
	
	private double dishPrice;
	
	private double calories;
	
	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}

	public Vendor getVendorId() {
		return vendor;
	}

	public void setVendorId(Vendor vendorId) {
		this.vendor = vendorId;
	}

}
