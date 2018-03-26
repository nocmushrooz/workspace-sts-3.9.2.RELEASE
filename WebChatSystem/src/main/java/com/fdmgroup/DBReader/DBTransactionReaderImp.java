package com.fdmgroup.DBReader;

import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.TotalSold.TotalSoldObj;
import com.fdmgroup.Transaction.TransactionObj;
import com.fdmgroup.TransactionDao.TransactionDao;
import com.fdmgroup.TransactionDao.TransactionDaoImp;

public class DBTransactionReaderImp implements DBTransactionReader {
	private static DBSingleton dbSingleton;
	
	public DBTransactionReaderImp(DBSingleton dbSingleton) {
		this.dbSingleton = dbSingleton;
	}
	@Override
	public Set<TotalSoldObj> retrieveTotalSold() {
		Set<TotalSoldObj> totalSoldList = new HashSet<TotalSoldObj>();
		TransactionDao transactionDao = new TransactionDaoImp(dbSingleton);
		totalSoldList = transactionDao.retrieveTotalSold();
		return totalSoldList;
	}

	@Override
	public Set<CheckOutObj> getTransactionItem(int order_id) {
		Set<CheckOutObj> transactionItemList = new HashSet<CheckOutObj>();
		TransactionDao transactionDao = new TransactionDaoImp(dbSingleton);
		transactionItemList = transactionDao.getTransactionItem( order_id);
		return transactionItemList;
	}

	@Override
	public Set<TransactionObj> getAllTransactionList() {
		Set<TransactionObj> transactionList = new HashSet<TransactionObj>();
		TransactionDao transactionDao = new TransactionDaoImp(dbSingleton);
		transactionList = transactionDao.getAllTransactionList();
		return transactionList;
	}

}
