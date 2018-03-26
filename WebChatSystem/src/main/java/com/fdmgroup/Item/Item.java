package com.fdmgroup.Item;

import java.io.Serializable;

public class Item implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int productID;
	private String productName;
	private String description ;
	private int quantity;
	private String category;
	private String picture;
	private double price;
	
	public Item(){}

	public Item(int productID, String productName, String description, int quantity, String category, String picture,
			double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.picture = picture;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
    
}	
	
