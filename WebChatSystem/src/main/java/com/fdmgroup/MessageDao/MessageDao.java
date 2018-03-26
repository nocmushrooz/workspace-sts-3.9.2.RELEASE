package com.fdmgroup.MessageDao;

import java.util.List;

import com.fdmgroup.Message.Message;
import com.fdmgroup.Query.QueryObj;
import com.fdmgroup.User.User;

public interface MessageDao {

	long createNewQuery(String username, String Cat, String subject);
	List<QueryObj> retrieveAdminQuery();
	List<QueryObj> retrieveUserQuery(String username);
	List<Message> retrieveQuery(String username, long queryNum);
	boolean deleteQuery(String username, long query_num);
	boolean sendMessage(Message msg, String queryNum);
	boolean updateQueryStatus(long query_num, String status);
	boolean adminSendMessage(String queryUsername, Message msg, String queryNum);
}
