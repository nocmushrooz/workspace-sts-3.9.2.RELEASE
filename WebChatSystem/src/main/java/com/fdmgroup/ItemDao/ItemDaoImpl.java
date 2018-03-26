package com.fdmgroup.ItemDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Item.Item;

public class ItemDaoImpl implements ItemDao
{
	private boolean success = false;
	private Set<CartObj> cartList = new HashSet<CartObj>();
	// Declare dependency
	private DBSingleton dbSingleton; // Allow single instance of jdbc connection
	
	public ItemDaoImpl(DBSingleton dbSingleton)
	{
		this.dbSingleton = dbSingleton;
	}
	
	public boolean setItem(Item item)
	{
		String query = "INSERT INTO ITEM (PRODUCT_NAME, DESCRIPTION, QUANTITY, PICTURE, PRICE) VALUES = (?,?,?,?,?)";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try
		{
			ps.setString(1, item.getProductName());
			ps.setString(2, item.getDescription());
			ps.setInt(3, item.getQuantity());
			ps.setString(4, item.getPicture());
			ps.setDouble(5, item.getPrice());
			ps.executeQuery();
			success = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return success;
	}
	
	public Item getItem(String itemName) 
	{
		Statement statement = this.dbSingleton.getStatement();
		ResultSet rs;
		String query = "SELECT * FROM ITEM WHERE product_Name='"+itemName+"'";
		Item item = new Item();
		try 
		{
				rs = statement.executeQuery(query);
				while (rs.next())
				{
					item.setProductID(rs.getInt("product_id"));
					item.setProductName(rs.getString("product_Name"));
					item.setDescription(rs.getString("description"));
					item.setCategory(rs.getString("CATEGORY"));
					item.setPicture(rs.getString("PICTURE"));
					item.setPrice(rs.getDouble("price"));
				}
				statement.close();
		} 		
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
		return item;
	}
	
	public List<Item> getAllItem()
	{
			Statement statement = this.dbSingleton.getStatement();
		    ResultSet rs = null;
			
			String query = "SELECT * FROM ITEM";
			
			List<Item> list_Items = new ArrayList<>();
			try
			{
				rs = statement.executeQuery(query);
				while (rs.next())
				{
					Item item = new Item();
					item.setProductID(rs.getInt("product_id"));
					item.setProductName(rs.getString("product_Name"));
					item.setDescription(rs.getString("description"));
					item.setQuantity(rs.getInt("QUANTITY"));
					item.setCategory(rs.getString("CATEGORY"));
					item.setPicture(rs.getString("PICTURE"));
					item.setPrice(rs.getDouble("price"));
					list_Items.add(item);
				}
				
				statement.close();
			}
			catch(SQLException e )
			{
				e.printStackTrace();
			}
			return list_Items;
	}

	public boolean updateQuantity(long item_id, int quantity){
		String query = "UPDATE ITEM SET QUANTITY = ? WHERE product_id = ?";
		PreparedStatement pS = dbSingleton.getPreparedStatement(query);
		System.out.println(item_id);
		System.out.println(quantity);
		
		try{
			pS.setInt(1, quantity);
			pS.setLong(2, item_id);
			pS.executeQuery();
			 success = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean updateDescription(long item_id, String description){
		String query = "UPDATE ITEM SET DESCRIPTION = ? WHERE product_id = ?";
		PreparedStatement pS = dbSingleton.getPreparedStatement(query);
		try{
			pS.setString(1, description);
			pS.setLong(2, item_id);
			pS.executeQuery();
			 success = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean updatePrice(long item_id, double price){
		String query = "UPDATE ITEM SET PRICE = ? WHERE product_id = ?";
		PreparedStatement pS = dbSingleton.getPreparedStatement(query);
		try{
			pS.setDouble(1, price);
			pS.setLong(2, item_id);
			pS.executeQuery();
			 success = true;
		}catch(Exception e){
			e.printStackTrace();
		}		
		return success;
	}
	
	public Set<CartObj> retrieveCart(String username){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT CART.PRODUCT_ID, ITEM.PRODUCT_NAME, CART.QUANTITY, ITEM.PRICE , ITEM.PICTURE");
		sB.append(" FROM ").append(username).append("_CART CART ");
		sB.append("INNER JOIN ITEM ITEM ON CART.PRODUCT_ID = ITEM.PRODUCT_ID ");
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rs = statement.executeQuery(sB.toString());
			while(rs.next()){
				CartObj cO = new CartObj();
				cO.setProductID(rs.getInt("PRODUCT_ID"));
				cO.setProductName(rs.getString("PRODUCT_NAME"));
				cO.setQuantity(rs.getInt("QUANTITY"));
				cO.setPrice(rs.getDouble("PRICE"));
				cO.setImage(rs.getString("PICTURE"));
				cartList.add(cO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return cartList;
	}
	public boolean addToCart(int productID,  String username, int quantity){
		String userCart = username + "_CART";
		StringBuilder sB = new StringBuilder();
		sB.append("INSERT INTO ").append(userCart);
		sB.append(" values (?,?)");
		PreparedStatement ps = dbSingleton.getPreparedStatement(sB.toString());
		try{
			ps.setInt(1, productID);
			ps.setInt(2, quantity);
			ps.executeQuery();
			success = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return success;
	}
	
}
