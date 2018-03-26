package com.fdmgroup.DBReader;

import java.util.List;

import com.fdmgroup.Message.Message;
import com.fdmgroup.Query.QueryObj;
import com.fdmgroup.User.User;

public interface DBMessageReader {

	List<QueryObj> retrieveUserQuery(String username);
	List<Message> retrieveQuery(String username, long queryNum);
	List<QueryObj> retrieveAdminQuery();
}
