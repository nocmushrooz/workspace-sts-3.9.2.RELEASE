package com.fdmgroup.DBWrite;

import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Item.Item;
import com.fdmgroup.ItemDao.ItemDao;
import com.fdmgroup.ItemDao.ItemDaoImpl;

public class DBItemWriterCommand implements DBItemWriter{

	private DBSingleton dbSingleton;
	public DBItemWriterCommand(DBSingleton dbSingleton)
	{
		this.dbSingleton = dbSingleton;
	}
		
	@Override
	public boolean setItem(Item item) {
		ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
		return itemDAO.setItem(item);
	}

	@Override
	public boolean updateQuantity(long item_id, int quantity) {
		ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
		return itemDAO.updateQuantity(item_id, quantity);
	}

	@Override
	public boolean updateDescription(long item_id, String description) {
		ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
		return itemDAO.updateDescription(item_id, description);
	}

	@Override
	public boolean updatePrice(long item_id, double price) {
		ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
		return itemDAO.updatePrice(item_id, price);
	}

	public boolean addToCart(int productID,  String username, int quantity){
		ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
		return itemDAO.addToCart(productID, username, quantity);
	}
}
