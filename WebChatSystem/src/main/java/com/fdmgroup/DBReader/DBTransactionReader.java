package com.fdmgroup.DBReader;

import java.util.Set;

import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.TotalSold.TotalSoldObj;
import com.fdmgroup.Transaction.TransactionObj;

public interface DBTransactionReader {

	public Set<TotalSoldObj> retrieveTotalSold();
	public Set<CheckOutObj> getTransactionItem(int order_id);
	public Set<TransactionObj> getAllTransactionList();
	
}
