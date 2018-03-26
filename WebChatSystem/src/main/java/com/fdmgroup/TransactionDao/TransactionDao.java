package com.fdmgroup.TransactionDao;

import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.TotalSold.TotalSoldObj;
import com.fdmgroup.Transaction.TransactionObj;

public interface TransactionDao {
	Set<TotalSoldObj> retrieveTotalSold();
	Set<CheckOutObj> getTransactionItem(int order_id);
	Set<TransactionObj> getAllTransactionList();
	boolean newTransaction(TransactionObj tO, Set<CartObj> cartObj);
	boolean updateDeliveryStatus(int order_id, String deliveryStatus);
}
