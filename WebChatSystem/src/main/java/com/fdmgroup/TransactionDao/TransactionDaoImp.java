package com.fdmgroup.TransactionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.TotalSold.TotalSoldObj;
import com.fdmgroup.Transaction.TransactionObj;

public class TransactionDaoImp implements TransactionDao {
	private static DBSingleton dbSingleton;
	boolean success = false;
	Set<TransactionObj> transactionList = new HashSet<TransactionObj>();
	Set<CheckOutObj> checkOutList = new HashSet<CheckOutObj>();
	Set<TotalSoldObj> totalSoldList = new HashSet<TotalSoldObj>();
	
	@SuppressWarnings("static-access")
	public TransactionDaoImp(DBSingleton dbSingleton){
		this.dbSingleton = dbSingleton;
	}
	public Set<TotalSoldObj> retrieveTotalSold(){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT CHECKOUT.PRODUCT_ID,  ITEM.PRODUCT_NAME , CHECKOUT.TOTAL_PRICE, SUM(CHECKOUT.QUANTITY) as Total_quantity ");
		sB.append("FROM CHECKOUT_DB CHECKOUT ");
		sB.append("JOIN (SELECT PRODUCT_NAME, PRODUCT_ID FROM ITEM) ITEM ");
		sB.append("ON ITEM.PRODUCT_ID = CHECKOUT.PRODUCT_ID ");
		sB.append("GROUP BY CHECKOUT.PRODUCT_ID, ITEM.PRODUCT_NAME, CHECKOUT.TOTAL_PRICE");
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rs = statement.executeQuery(sB.toString());
			while(rs.next()){
				TotalSoldObj tSO = new TotalSoldObj();
				tSO.setProductID(rs.getInt("PRODUCT_ID"));
				tSO.setProductName(rs.getString("PRODUCT_NAME"));
				tSO.setPrice(rs.getDouble("TOTAL_PRICE"));
				tSO.setQuantity(rs.getInt("TOTAL_QUANTITY"));
				totalSoldList.add(tSO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return totalSoldList;
	}
	
	
	@Override
	public Set<CheckOutObj> getTransactionItem(int order_id) {
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT * FROM CHECKOUT_DB ");
		sB.append(" JOIN (SELECT product_name, product_id from item) item ");
		sB.append("ON CHECKOUT_DB.PRODUCT_ID = ITEM.product_id ");
		sB.append("WHERE ORDER_ID = ?");
		PreparedStatement ps = dbSingleton.getPreparedStatement(sB.toString());
		try{
			ps.setInt(1, order_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CheckOutObj checkOutObj = new CheckOutObj();
				checkOutObj.setOrderID(rs.getInt("ORDER_ID"));
				checkOutObj.setProductID(rs.getInt("PRODUCT_ID"));
				checkOutObj.setProductName(rs.getString("PRODUCT_NAME"));
				checkOutObj.setTotal_price(rs.getInt("TOTAL_PRICE"));
				checkOutObj.setQuantity(rs.getInt("QUANTITY"));
				checkOutList.add(checkOutObj);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return checkOutList;
	}

	@Override
	public Set<TransactionObj> getAllTransactionList() {
		String query = "SELECT * FROM TRANSACTION_TABLE";
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				TransactionObj tO = new TransactionObj();
				tO.setOrder_id(rs.getInt("ORDER_ID"));
				tO.setUsername(rs.getString("USERNAME"));
				tO.setTotalPrice(rs.getInt("TOTAL_PRICE"));
				tO.setTransactionDate(rs.getDate("Transaction_Date"));
				tO.setDeliveryStatus(rs.getString("DELIVERY_STATUS"));
				transactionList.add(tO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public boolean newTransaction(TransactionObj tO, Set<CartObj> cartObj) {
		String query = "INSERT INTO TRANSACTION_TABLE (USERNAME, TOTAL_PRICE, TRANSACTION_DATE, DELIVERY_STATUS) VALUES (?,?,?,?)";
		String query1 = "SELECT MAX(ORDER_ID) as orderID FROM TRANSACTION_TABLE WHERE USERNAME = ?";
		String query2 = "INSERT INTO CHECKOUT_DB (ORDER_ID, PRODUCT_ID, TOTAL_PRICE, QUANTITY) VALUES (?,?,?,?)";
		PreparedStatement insertNewTransactionQuery = dbSingleton.getPreparedStatement(query);
		PreparedStatement getOrderIDQuery = dbSingleton.getPreparedStatement(query1);
		PreparedStatement insertEachItemIntoCheckOutDb = dbSingleton.getPreparedStatement(query2);
		int orderID = 0;
		try{
			insertNewTransactionQuery.setString(1, tO.getUsername());
			insertNewTransactionQuery.setDouble(2, tO.getTotalPrice());
			insertNewTransactionQuery.setDate(3, tO.getTransactionDate());
			insertNewTransactionQuery.setString(4 ,tO.getDeliveryStatus() );
			insertNewTransactionQuery.executeQuery();
			getOrderIDQuery.setString(1, tO.getUsername());
			ResultSet rs = getOrderIDQuery.executeQuery();
			while(rs.next()){
				orderID = rs.getInt("orderID");
			}
			for(CartObj cObj: cartObj){
				
				insertEachItemIntoCheckOutDb.setInt(1, orderID);
				insertEachItemIntoCheckOutDb.setInt(2, cObj.getProductID());
				insertEachItemIntoCheckOutDb.setDouble(3, cObj.getPrice());
				insertEachItemIntoCheckOutDb.setInt(4, cObj.getQuantity());
				insertEachItemIntoCheckOutDb.addBatch();
			}
			insertEachItemIntoCheckOutDb.executeBatch();
			removeAllCartItem(tO.getUsername());
			insertEachItemIntoCheckOutDb.close();
			success = true;
		}catch(SQLException e){
			e.printStackTrace();
		}	
		return success;
	}

	@Override
	public boolean updateDeliveryStatus(int order_id, String deliveryStatus) {
		String query = "UPDATE TRANSACTION_TABLE SET DELIVERY_STATUS = ? WHERE ORDER_ID = ?";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try{
			ps.setString(1, deliveryStatus);
			ps.setInt(2, order_id);
			ps.executeQuery();
			success = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return success;
	}
	private void removeAllCartItem(String username){
		String query = "TRUNCATE TABLE " + username + "_CART";
		Statement statement = dbSingleton.getStatement();
		try{
			statement.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
