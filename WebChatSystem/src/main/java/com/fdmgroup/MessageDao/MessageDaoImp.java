package com.fdmgroup.MessageDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Message.Message;
import com.fdmgroup.Query.QueryObj;
import com.fdmgroup.User.User;

public class MessageDaoImp implements MessageDao{
	private static DBSingleton dbSingleton;
	List<Message> conversationList;
	List<QueryObj> queryList = new ArrayList<QueryObj>();
	String tempTableName = null;
	boolean success = false;
	
	public MessageDaoImp(DBSingleton dbSingleton){
		this.dbSingleton = dbSingleton;
	}
	
	private List<QueryObj> retrieveQueryResultSet(ResultSet rs){
		List<QueryObj> qL = new ArrayList<QueryObj>();
		try{
			while(rs.next()){
				
				String uName = rs.getString("USERNAME");
				long query_num = rs.getLong("QUERY_NUM");
				String qStatus = rs.getString("QUERY_STATUS");
				String qCategory = rs.getString("CATEGORY");
				String qSubject = rs.getString("SUBJECT");
				QueryObj qO = new QueryObj(uName, query_num, qStatus, qCategory , qSubject);
				qL.add(qO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return qL;
	}	
	
	
	@Override
	public List<QueryObj> retrieveUserQuery(String username) {
		String query = "SELECT * FROM MESSAGE_LIST WHERE username = ? ORDER BY QUERY_NUM DESC";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try{
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			queryList = retrieveQueryResultSet(rs);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return queryList;
	}	
	
	@Override
	public List<QueryObj> retrieveAdminQuery() {
		String query = "SELECT * FROM MESSAGE_LIST ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try{
			ResultSet rs = ps.executeQuery();
			queryList = retrieveQueryResultSet(rs);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return queryList;
	}
	
	@Override
	public List<Message> retrieveQuery(String username, long queryNum) {
		StringBuilder sB = new StringBuilder();
		conversationList = new ArrayList<Message>();
		Statement statement = dbSingleton.getStatement();
		
		try{		
			tempTableName = retrieveChatTable(username, queryNum);
			sB.append("SELECT * FROM ");
			sB.append(tempTableName);
			ResultSet rs = statement.executeQuery(sB.toString());
			conversationList = retrieveMessageList (rs);
			
		}catch(SQLException e){
			e.printStackTrace();
			conversationList = null;
		}
		return conversationList; 
	}
	@Override
	public boolean deleteQuery(String username, long query_num) {
		success = false;
		StringBuilder sB = new StringBuilder();
		StringBuilder sB1 = new StringBuilder();
		StringBuilder sB2 = new StringBuilder();
		StringBuilder sB3 = new StringBuilder();
		
		tempTableName = retrieveChatTable(username, query_num);
		sB.append("DROP TABLE ").append(tempTableName);
		sB1.append("DELETE FROM MESSAGE_LIST WHERE USERNAME = ? AND QUERY_NUM = ? ");
		Statement statement = dbSingleton.getStatement();
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(sB1.toString());
		
		try{
			ps1.setString(1, username);
			ps1.setLong(2, query_num);	
			ps1.executeQuery();
			statement.executeQuery(sB.toString());
			success = true;
		}catch(SQLException e){
			e.printStackTrace();
		}	
		return success;
	}
	@Override
	public long createNewQuery(String username, String Cat, String subject) {
		String insertToQuery = "INSERT INTO MESSAGE_LIST (USERNAME, query_status, Category, subject) values (?,?,?,?)";
		PreparedStatement ps = dbSingleton.getPreparedStatement(insertToQuery);
		String findLastQuery = "SELECT MAX(QUERY_NUM) as QUERY_NUM FROM MESSAGE_LIST ";
		Statement statement = dbSingleton.getStatement();
		long query_num = 0;
		success = false;
		StringBuilder sB = new StringBuilder();
		String query1 = "SELECT * FROM MESSAGE_LIST WHERE USERNAME = ? AND QUERY_NUM = ? ";
		PreparedStatement ps2 = dbSingleton.getPreparedStatement(query1);
		Statement createTableStatement = dbSingleton.getStatement();
		try{
			ps.setString(1, username);
			ps.setString(2, "Pending");
			ps.setString(3, Cat);
			ps.setString(4, subject);
			ps.executeQuery();
			ResultSet rs = statement.executeQuery(findLastQuery);
			while(rs.next()){
				query_num = Long.parseLong(rs.getString("QUERY_NUM")) ;
			}
			if(query_num != 0){
				ps2.setString(1, username);
				ps2.setLong(2, query_num);
				ResultSet rs1 = ps2.executeQuery();
				while(rs1.next()){
					if(rs1.getString("username").equalsIgnoreCase(username)){
						String tableName =  username + "_" + Long.toString(query_num) ; 
						sB.append("CREATE TABLE ").append(tableName);
						sB.append(" (SENDER varchar2(255), MESSAGE VARCHAR2(255), DATENTIME DATE)" );
						createTableStatement.execute(sB.toString());
						success = true;
					}
				}
			}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return query_num;
	}	
	
	@Override
	public boolean adminSendMessage(String queryUsername, Message msg, String queryNum) {
		StringBuilder sB = new StringBuilder();
		tempTableName = queryUsername + "_" + queryNum;
		sB.append("INSERT INTO ").append(tempTableName);
		sB.append("(SENDER,  MESSAGE, DATENTIME) VALUES ");
		sB.append("(?,?,?)");
		PreparedStatement ps = dbSingleton.getPreparedStatement(sB.toString());
		try{			
				ps.setString(1, msg.getSenderUsername());
				ps.setString(2, msg.getMessages());
				ps.setDate(3, msg.getDateNTime());
				ps.executeQuery();
				success = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			success = false;
		}	
		return success;
	}		
	
	@Override
	public boolean sendMessage(Message msg, String queryNum) {
		StringBuilder sB = new StringBuilder();
		tempTableName = msg.getSenderUsername() + "_" + queryNum;
		sB.append("INSERT INTO ").append(tempTableName);
		sB.append("(SENDER,  MESSAGE, DATENTIME) VALUES ");
		sB.append("(?,?,?)");
		PreparedStatement ps = dbSingleton.getPreparedStatement(sB.toString());
		try{			
				ps.setString(1, msg.getSenderUsername());
				ps.setString(2, msg.getMessages());
				ps.setDate(3, msg.getDateNTime());
				ps.executeQuery();
				success = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			success = false;
		}	
		return success;
	}		
	private String retrieveChatTable(String username, long queryNum){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT * FROM MESSAGE_LIST WHERE USERNAME = ? AND QUERY_NUM = ? ");
		PreparedStatement pS = dbSingleton.getPreparedStatement(sB.toString());
		try{
			pS.setString(1, username);
			pS.setLong(2, queryNum);
			ResultSet rs = pS.executeQuery();
			while(rs.next()){
				if( rs.getString("username") != null )
				tempTableName = username + "_" + Long.toString(queryNum);
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tempTableName;
	}	
	private List<Message> retrieveMessageList (ResultSet rS){
		List<Message> mList = new ArrayList<Message>();
		try{
			while(rS.next()){
				Message msg = new Message();
				msg.setSenderUsername(rS.getString("Sender"));
				msg.setMessages(rS.getString("MESSAGE"));
				msg.setDateNTime(rS.getDate("DATENTIME"));
				mList.add(msg);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return mList;
		
	}
	private String retrieveDeleted(ResultSet rS){
		String userDeletedMessage = null;
		try{
			while(rS.next()){
				userDeletedMessage = rS.getString("USER_LEFT_CHAT");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userDeletedMessage;
	}

	@Override
	public boolean updateQueryStatus(long query_num, String status){
		String query = "UPDATE MESSAGE_LIST SET QUERY_STATUS = ? WHERE QUERY_NUM = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try{
			ps.setString(1, status);
			ps.setLong(2, query_num);
			ps.executeQuery();
			success = true;
		}catch(SQLException e){
			e.printStackTrace();
			success = false;
		}
		return success;
	}
}
