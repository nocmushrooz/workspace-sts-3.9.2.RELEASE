package com.fdmgroup.Controller;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.DBReader.DBTransactionReader;
import com.fdmgroup.DBReader.DBTransactionReaderImp;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.DBWrite.DBTransactionWrite;
import com.fdmgroup.DBWrite.DBTransactionWriteImp;
import com.fdmgroup.TotalSold.TotalSoldObj;
import com.fdmgroup.Transaction.TransactionObj;

public class TransactionController  {
	DBTransactionReader dbTransactionReader;
	DBTransactionWrite dbTransactionWrite; 	
	DBSingleton dbSingleton = DBSingleton.getInstance();
	Set<CheckOutObj> transactionItemList = new HashSet<CheckOutObj>();
	Set<TransactionObj> transactionList = new HashSet<TransactionObj>();
	ItemController iC = new ItemController();
	boolean success = false;
	
	public Set<TotalSoldObj> retrieveTotalSold(){
		dbTransactionReader = new DBTransactionReaderImp(dbSingleton);
		return dbTransactionReader.retrieveTotalSold();
	}
	public Set<CheckOutObj> getTransactionItem(int order_id){
		dbTransactionReader = new DBTransactionReaderImp(dbSingleton);
		transactionItemList = dbTransactionReader.getTransactionItem(order_id);
		return transactionItemList;
	}
	public Set<TransactionObj> getAllTransactionList(){
		dbTransactionReader = new DBTransactionReaderImp(dbSingleton);
		transactionList = dbTransactionReader.getAllTransactionList();
		return transactionList;
	}
	public boolean newTransaction(String username){
		Set<CartObj> cartObj = new HashSet<CartObj>();
		cartObj = iC.retrieveCart(username);
		TransactionObj tO = new TransactionObj();
		double totalPrice = 0.00;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		for(CartObj cartItem: cartObj){
			double itemTotal = cartItem.getQuantity() * cartItem.getPrice();
			totalPrice = itemTotal + totalPrice;
		}
		tO.setTotalPrice(totalPrice);
		tO.setUsername(username);
		tO.setDeliveryStatus("Pending");
		tO.setTransactionDate(date);
		dbTransactionWrite = new DBTransactionWriteImp(dbSingleton);
		success = dbTransactionWrite.newTransaction(tO, cartObj);
		return success;
	}
	public boolean updateDeliveryStatus(int order_id, String deliveryStatus){
		dbTransactionWrite = new DBTransactionWriteImp(dbSingleton);
		success = dbTransactionWrite.updateDeliveryStatus(order_id, deliveryStatus);
		return success;
	}
}
