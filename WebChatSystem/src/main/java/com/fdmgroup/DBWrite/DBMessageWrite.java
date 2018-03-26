package com.fdmgroup.DBWrite;

import com.fdmgroup.Message.Message;
import com.fdmgroup.User.User;

public interface DBMessageWrite {

	long createNewQuery(String username, String Cat, String subject);
	boolean sendMessage(Message msg, String queryNum);
	boolean updateQueryStatus(long query_num, String status);
	boolean adminSendMessage(String queryUsername, Message msg, String queryNum);
}
