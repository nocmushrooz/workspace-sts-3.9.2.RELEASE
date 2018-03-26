package com.fdmgroup.Controller;

import java.util.List;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.DBReader.DBItemReader;
import com.fdmgroup.DBReader.DBItemReaderCommand;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.DBWrite.DBItemWriter;
import com.fdmgroup.DBWrite.DBItemWriterCommand;
import com.fdmgroup.Item.Item;
import com.fdmgroup.ItemDao.ItemDaoImpl;
import com.fdmgroup.ItemFactory.ItemFactory;

public class ItemController 
{
	private ItemFactory itemFactory; 
	private ItemDaoImpl itemDaoImpl;
	DBItemReader dbReadCommand;
	DBItemWriter dbItemWriter;
	Item item;
	DBSingleton dbSingleton = DBSingleton.getInstance();
	
	
	public Item findItemInDataBase(String retrievedItemName)
	{	
		DBItemReaderCommand dbReadCommand = new DBItemReaderCommand(dbSingleton);
		return dbReadCommand.getItem(retrievedItemName);
	}
	
	public boolean setItem(Item itemName){
		dbItemWriter = new DBItemWriterCommand(dbSingleton);
		return dbItemWriter.setItem(itemName);
	}
	
	public boolean updateQuantity(long item_id, int quantity){
		dbItemWriter = new DBItemWriterCommand(dbSingleton);
		return dbItemWriter.updateQuantity(item_id, quantity);
	}
	
	public boolean updateDescription(long item_id, String description){
		dbItemWriter = new DBItemWriterCommand(dbSingleton);
		return dbItemWriter.updateDescription(item_id, description);
	}
	
	public boolean updatePrice(long item_id, double price){
		dbItemWriter = new DBItemWriterCommand(dbSingleton);
		return dbItemWriter.updatePrice(item_id, price);
	}
	
	public List<Item> getAllItem(){
		dbReadCommand = new DBItemReaderCommand(dbSingleton);
		return dbReadCommand.getAllItem();
	}
	
	public Set<CartObj> retrieveCart(String username){
		dbReadCommand = new DBItemReaderCommand(dbSingleton);
		return dbReadCommand.retrieveCart(username);
	}
	
	public boolean addToCart(int productID,  String username, int quantity){
		dbItemWriter = new DBItemWriterCommand(dbSingleton);
		return dbItemWriter.addToCart(productID, username, quantity );
	}
	
}
