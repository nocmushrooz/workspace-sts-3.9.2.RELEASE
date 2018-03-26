package com.fdmgroup.DBReader;

import java.util.List;
import com.fdmgroup.User.User;

public interface DBReader {

	User retrieveUserInfo(String username, String password);
	List<User> getAllUser();

	
}
