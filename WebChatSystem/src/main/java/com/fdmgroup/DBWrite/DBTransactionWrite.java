package com.fdmgroup.DBWrite;

import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.Transaction.TransactionObj;

public interface DBTransactionWrite {
	boolean newTransaction(TransactionObj tO, Set<CartObj> cartObj);
	boolean updateDeliveryStatus(int order_id, String deliveryStatus);
}
