package com.fdmgroup.DBReader;

import java.util.List;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Item.Item;
import com.fdmgroup.ItemDao.ItemDao;
import com.fdmgroup.ItemDao.ItemDaoImpl;

public class DBItemReaderCommand implements DBItemReader
{
		private DBSingleton dbSingleton;
		public DBItemReaderCommand(DBSingleton dbSingleton)
		{
			this.dbSingleton = dbSingleton;
		}
			
		@Override
		public Item getItem(String itemName) {	
			ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
			return itemDAO.getItem(itemName);
		}

		@Override
		public List<Item> getAllItem() {
			ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
			return itemDAO.getAllItem();
		}

		@Override
		public Set<CartObj> retrieveCart(String username) {
			ItemDao itemDAO = new ItemDaoImpl(dbSingleton);
			return itemDAO.retrieveCart(username);
		}
		
		
}
