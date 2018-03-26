package com.fdmgroup.ItemFactory;

import com.fdmgroup.Item.Item;

public class ItemFactory 
{
	private String availability;
    private String description;
    private String category;
    private String picture;
    private String productName;
	
	public Item createItemProduct(String productName, String desciption) 
	{
		this.productName = productName;
		this.description = desciption;
		
		Item item = new Item();
		item.setProductName(this.productName);
		item.setDescription(this.description);
		return item;
	}
	
	
}
