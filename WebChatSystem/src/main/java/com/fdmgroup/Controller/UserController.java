package com.fdmgroup.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.fdmgroup.DBReader.DBReaderCommand;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.DBWrite.DBWriter;
import com.fdmgroup.DBWrite.DBWriterCommand;
import com.fdmgroup.User.User;
import com.fdmgroup.UserFactory.UserFactory;

public class UserController {

	private static Logger consoleLog = Logger.getLogger("consoleLog");
	DBReaderCommand readCommand;
	DBWriterCommand writeCommand;
	UserFactory userFactory = new UserFactory();
	MessageController mC = new MessageController();
	User user;
	DBSingleton dbSingleton = DBSingleton.getInstance();
	List<User> userList = new ArrayList<User>();
	boolean successRegisterUser = false;
	boolean success = false;
	boolean exist;
	
	public boolean createNewUser(String username, String userPassword, String userAddress, int postalCode, String name,
			int contactNumber, String emailAddress, String userType){
		
		user = userFactory.createUser();
		user.setUsername(username);
		user.setUserPassword(userPassword);
		user.setUserAddress(userAddress);
		user.setPostalCode(postalCode);
		user.setName(name);
		user.setContactNumber(contactNumber);
		user.setEmailAddress(emailAddress);
		user.setUserType(userType);
		writeCommand = new DBWriterCommand(dbSingleton);
		successRegisterUser = writeCommand.writeUser(user);
		return successRegisterUser;
	}

	public List<User> retrieveAllUser(){
		readCommand = new DBReaderCommand(dbSingleton);
		userList = readCommand.getAllUser();
		return userList;
	}
	
	public User loginUser(String username, String password){
		readCommand = new DBReaderCommand(dbSingleton);
		user = readCommand.retrieveUserInfo(username, password);
		consoleLog.trace("UserController - User info has successfully passed to controller");
		return user;
	}
	
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
		success = false;
		writeCommand = new DBWriterCommand(dbSingleton);
		success = writeCommand.changePassword(username, oldPassword, newPassword);
		return success;
	}
	
	public boolean updateEmailAddress(String username, String oldEmail, String newEmail){
		success = false;
		writeCommand = new DBWriterCommand(dbSingleton);
		success = writeCommand.changeEmail(username, oldEmail, newEmail);
		return success;
	}

	public boolean updateAddress(String username, String oldAddress, String newAddress) {
		success = false;
		writeCommand = new DBWriterCommand(dbSingleton);
		success = writeCommand.changeAddress(username, oldAddress, newAddress);
		return success;
	}
	
	public boolean updatePostalCode(String username, int oldPostalCode, int newPostalCode){
		success = false;
		writeCommand = new DBWriterCommand(dbSingleton);
		success = writeCommand.changePostalCode(username, oldPostalCode, newPostalCode);
		return success;
	}
	
	public boolean updateContactNumber(String username, int oldContactNumber, int newContactNumber){
		success = false;
		writeCommand = new DBWriterCommand(dbSingleton);
		success = writeCommand.changeContactNumber(username, oldContactNumber, newContactNumber);
		return success;
	}
	
	
	public boolean usernameExist(String username){
		writeCommand = new DBWriterCommand (dbSingleton);
		exist = writeCommand.usernameExist(username);
		return exist;
	}
	
	public boolean emailExist(String emailAddres){
		writeCommand = new DBWriterCommand (dbSingleton);
		exist = writeCommand.emailExist(emailAddres);
		return exist;
	}
	
	public boolean contactExist(int contactNumber){
		writeCommand = new DBWriterCommand (dbSingleton);
		exist = writeCommand.contactNumberExist(contactNumber);
		return exist;
	}
	
	public void autoPopulateUser(){
		for(int i = 0; i<10; i++){
			String username = "gaithri" + i;
			String userPassword = "pwd1";
			String userAddress = "hello world singapore"; 
			String emailAddress = i+"@hotmail.com";
			int postalCode = 123123;
			String name = "Wei Jun";
			int contactNumber = 400000 + i ; 
			String userType = "User";
			createNewUser(username, userPassword, userAddress, postalCode, name, contactNumber, emailAddress, userType);
		}
	}
}
