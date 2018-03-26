package com.fdmgroup.Cart;

public class CartObj {

	private int productID;
	private String productName;
	private double price;
	private String image;
	private int quantity;
	
	public CartObj(){}

	public CartObj(int productID, String productName, double price, String image, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	};
	
	
	
	
}
