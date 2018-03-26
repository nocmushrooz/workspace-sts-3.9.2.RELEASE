package com.fdmgroup.DBReader;

import java.util.List;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.Item.Item;

public interface DBItemReader 
{
	Item getItem(String itemName);
	List<Item> getAllItem();
	public Set<CartObj> retrieveCart(String username);
	
}
