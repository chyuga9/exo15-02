package org.shoes.model.impl;

import java.util.List;

import org.shoes.model.abs.Product;

public class Shoe implements Product{

	
	public float getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(float customerPrice) {
		this.customerPrice = customerPrice;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	private int size;
	private String brand;
	private List<String> color;
	private int stock;
	private float price;
	private float customerPrice;
	
	
	public Shoe(int size, String brand, List<String> color) {
		super();
		this.size = size;
		this.brand = brand;
		this.color = color;
	}
	
	public Shoe() {
		super();
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
