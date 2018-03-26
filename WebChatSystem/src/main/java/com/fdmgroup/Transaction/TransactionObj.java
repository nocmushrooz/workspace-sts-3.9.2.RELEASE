package com.fdmgroup.Transaction;

import java.sql.Date;

public class TransactionObj {
	
	private int order_id;
	private String username;
	private double totalPrice;
	private Date transactionDate;
	private String deliveryStatus;
	
	public TransactionObj(){};
	
	public TransactionObj(int order_id, String username, double totalPrice, Date transactionDate,
			String deliveryStatus) {
		this.order_id = order_id;
		this.username = username;
		this.totalPrice = totalPrice;
		this.transactionDate = transactionDate;
		this.deliveryStatus = deliveryStatus;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	
}
