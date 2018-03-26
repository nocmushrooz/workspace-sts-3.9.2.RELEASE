package com.fdmgroup.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.fdmgroup.Comparator.DateComparator;
import com.fdmgroup.DBReader.DBMessageReaderCommand;
import com.fdmgroup.DBReader.DBReaderCommand;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.DBWrite.DBMessageWriteCommand;
import com.fdmgroup.DBWrite.DBWriterCommand;
import com.fdmgroup.Message.Message;
import com.fdmgroup.Query.QueryObj;

public class MessageController {
	DBMessageReaderCommand readMessageCommand;
	DBMessageWriteCommand writeCommand; 	
	DBSingleton dbSingleton = DBSingleton.getInstance();
	List<Message> conversationList = new ArrayList<Message>();
	List<QueryObj> queryList = new ArrayList<QueryObj>();
	boolean success = false;
	
	public List<Message>  retrieveQuery(String username, long queryNum){
		readMessageCommand = new DBMessageReaderCommand(dbSingleton);
		conversationList = readMessageCommand. retrieveQuery(username,  queryNum);
		Collections.sort(conversationList,new DateComparator());
		return conversationList;
	}	
	
	public List<QueryObj> retrieveAdminQuery(){
		readMessageCommand = new DBMessageReaderCommand(dbSingleton);
		queryList = readMessageCommand.retrieveAdminQuery();
		return queryList;
	}	
	
	public List<QueryObj> retrieveUserQuery(String username){
		readMessageCommand = new DBMessageReaderCommand(dbSingleton);
		queryList = readMessageCommand.retrieveUserQuery(username);
		return queryList;
	}	

	public boolean sendMessage(String sender, String query_num, String Message){
		writeCommand = new DBMessageWriteCommand(dbSingleton);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Message msg = new Message(sender, Message, date);
		success = writeCommand.sendMessage(msg, query_num );
		return success;
	}	
	
	public boolean adminSendMessage(String queryUsername, String sender, String query_num, String Message){
		writeCommand = new DBMessageWriteCommand(dbSingleton);
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());;
		Message msg = new Message(sender, Message, date);
		success = writeCommand.adminSendMessage(queryUsername, msg, query_num );
		return success;
	}	

	
	public long initiateNewQuery(String username, String Cat, String subject){
		writeCommand = new DBMessageWriteCommand(dbSingleton);
		long queryNum = writeCommand.createNewQuery(username, Cat, subject);
		return queryNum;
	}
	
	public boolean updateQueryStatus(long query_num, String status){
		writeCommand = new DBMessageWriteCommand(dbSingleton);
		success = writeCommand.updateQueryStatus(query_num, status);
		return success;
	}
}
