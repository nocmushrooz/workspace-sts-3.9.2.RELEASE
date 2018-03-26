package com.fdmgroup.DBWrite;

import com.fdmgroup.Item.Item;

public interface DBItemWriter {

	boolean setItem(Item item);
	boolean updateQuantity(long item_id, int quantity);
	boolean updateDescription(long item_id, String description);
	boolean updatePrice(long item_id, double price);
	boolean addToCart(int productID,  String username, int quantity);
}
