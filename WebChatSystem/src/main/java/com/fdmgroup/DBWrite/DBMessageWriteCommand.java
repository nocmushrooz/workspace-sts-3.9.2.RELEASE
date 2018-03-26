package com.fdmgroup.DBWrite;

import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Message.Message;
import com.fdmgroup.MessageDao.MessageDao;
import com.fdmgroup.MessageDao.MessageDaoImp;
import com.fdmgroup.User.User;

public class DBMessageWriteCommand implements DBMessageWrite{
	
	private static DBSingleton dbSingleton;
	private boolean success = false;
	public DBMessageWriteCommand(DBSingleton dbSingleton) {
		this.dbSingleton = dbSingleton;
	}

	@Override
	public long createNewQuery(String username, String Cat, String subject) {
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		long queryNum = messageDao.createNewQuery(username,  Cat, subject);
		return queryNum;
	}

	@Override
	public boolean sendMessage(Message msg, String queryNum) {
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		return messageDao.sendMessage(msg, queryNum);	
		
	}
	
	@Override
	public boolean adminSendMessage(String queryUsername, Message msg, String queryNum){
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		return messageDao.adminSendMessage(queryUsername, msg, queryNum);	
	}
	
	@Override
	public boolean  updateQueryStatus(long query_num, String status){
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		return messageDao.updateQueryStatus(query_num, status);	
		
	}
}
