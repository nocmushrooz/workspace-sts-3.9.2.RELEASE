package com.fdmgroup.DBReader;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.User.User;
import com.fdmgroup.UserDao.UserDao;
import com.fdmgroup.UserDao.UserDaoImp;

public class DBReaderCommand implements DBReader{

	User user;
	List<User> userList = new ArrayList<User>();
	private static Logger consoleLog = Logger.getLogger("consoleLog");
	private static DBSingleton dbSingleton;
	
	public DBReaderCommand(DBSingleton dbSingelton){
		this.dbSingleton = dbSingelton;
	}
	
	public User retrieveUserInfo(String username, String password) {

		UserDao userDao = new UserDaoImp(dbSingleton);
		user = userDao.getUserInfo(username, password);
		return user;	
	}

	public List<User> getAllUser() {
		UserDao userDao = new UserDaoImp(dbSingleton);
		userList = userDao.retrieveAllUser();
		return userList;
	}


}
