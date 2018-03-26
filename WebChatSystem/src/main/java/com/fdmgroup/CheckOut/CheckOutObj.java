package com.fdmgroup.CheckOut;

public class CheckOutObj {

	private int orderID;
	private int productID;
	private String productName;
	private double  total_price;
	private int  quantity;
	
	
	public CheckOutObj(){};
	
	public CheckOutObj(int orderID, int productID, String productName, double total_price, int quantity) {
		this.orderID = orderID;
		this.productID = productID;
		this.productName = productName;
		this.total_price = total_price;
		this.quantity = quantity;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public double getTotalPrice() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
