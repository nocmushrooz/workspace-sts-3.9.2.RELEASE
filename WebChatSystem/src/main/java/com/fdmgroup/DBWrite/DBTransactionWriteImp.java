package com.fdmgroup.DBWrite;

import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Transaction.TransactionObj;
import com.fdmgroup.TransactionDao.TransactionDao;
import com.fdmgroup.TransactionDao.TransactionDaoImp;

public class DBTransactionWriteImp implements DBTransactionWrite{
	private static DBSingleton dbSingleton;
	private boolean success = false;
	
	public DBTransactionWriteImp(DBSingleton dbSingleton) {
		this.dbSingleton = dbSingleton;
	}


	@Override
	public boolean newTransaction(TransactionObj tO, Set<CartObj> cartObj) {
		TransactionDao transactionDao = new TransactionDaoImp(dbSingleton);
		success = transactionDao.newTransaction(tO, cartObj);
		return success;
	}

	@Override
	public boolean updateDeliveryStatus(int order_id, String deliveryStatus) {
		TransactionDao transactionDao = new TransactionDaoImp(dbSingleton);
		success = transactionDao.updateDeliveryStatus(order_id, deliveryStatus);
		return success;
	}

	
}
