package com.fdmgroup.DBReader;

import java.util.ArrayList;
import java.util.List;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Message.Message;
import com.fdmgroup.MessageDao.MessageDao;
import com.fdmgroup.MessageDao.MessageDaoImp;
import com.fdmgroup.User.User;

import java.util.ArrayList;
import java.util.List;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Message.Message;
import com.fdmgroup.MessageDao.MessageDao;
import com.fdmgroup.MessageDao.MessageDaoImp;
import com.fdmgroup.Query.QueryObj;
import com.fdmgroup.User.User;

public class DBMessageReaderCommand implements DBMessageReader{
	private static DBSingleton dbSingleton;
	List<Message> conversationList = new ArrayList<Message>();
	List<QueryObj> queryList = new ArrayList<QueryObj>();
	
	public DBMessageReaderCommand(DBSingleton dbSingleton){
		this.dbSingleton = dbSingleton;
	}
	
	@Override
	public List<QueryObj> retrieveAdminQuery() {
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		queryList = messageDao.retrieveAdminQuery();
		return queryList;
	}
	
	@Override
	public List<QueryObj> retrieveUserQuery(String username) {
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		queryList = messageDao.retrieveUserQuery(username);
		return queryList;
	}

	@Override
	public List<Message> retrieveQuery(String username, long queryNum) {
		MessageDao messageDao = new MessageDaoImp(dbSingleton);
		conversationList = messageDao.retrieveQuery(username, queryNum);
		return conversationList;
	}
}
