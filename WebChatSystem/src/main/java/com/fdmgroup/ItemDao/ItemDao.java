package com.fdmgroup.ItemDao;

import java.util.List;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.Item.Item;

public interface ItemDao 
{
	public boolean setItem(Item item);
	public Item getItem(String itemName);
	public List<Item> getAllItem();
	public boolean updateQuantity(long item_id, int quantity);
	public boolean updateDescription(long item_id, String description);
	public boolean updatePrice(long item_id, double price);
	public Set<CartObj> retrieveCart(String username);
	public boolean addToCart(int productID,  String username, int quantity);
}
