package com.onlinefood.resteasy.models;

public class OrderDTO {

	private String inputDish;
	private int quantity;
	private String username;
	public String getInputDish() {
		return inputDish;
	}
	public void setInputDish(String inputDish) {
		this.inputDish = inputDish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
