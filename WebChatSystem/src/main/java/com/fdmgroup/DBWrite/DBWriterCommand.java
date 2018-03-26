package com.fdmgroup.DBWrite;


import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.User.User;
import com.fdmgroup.UserDao.UserDao;
import com.fdmgroup.UserDao.UserDaoImp;

public class DBWriterCommand implements DBWriter {
	
	private static DBSingleton dbSingleton;
	boolean successful;
	boolean exist;
	public DBWriterCommand(DBSingleton dbSingleton) {
		this.dbSingleton = dbSingleton;
	}

	public boolean writeUser(User user) {
		successful = false;
		UserDao userDao = new UserDaoImp(dbSingleton);
		successful = userDao.registerNewUser(user);
		return successful;
	}

	public boolean changePassword(String username, String oldPassword, String newPassword) {
		successful = false;
		UserDao userdao = new UserDaoImp(dbSingleton);
		successful = userdao.changePassword(username, oldPassword, newPassword);
		return successful;
		
	}

	public boolean changeEmail(String username, String oldEmail, String newEmail) {
		successful = false;
		UserDao userdao = new UserDaoImp(dbSingleton);
		successful = userdao.changeEmail( username,  oldEmail,  newEmail);
		return successful;
	}

	public boolean changeAddress(String username, String oldAddress, String newAddress) {
		successful = false;
		UserDao userdao = new UserDaoImp(dbSingleton);
		successful = userdao.changeAddress(username, oldAddress, newAddress);
		return successful;
		
	}

	public boolean changeContactNumber(String username, int oldContactNumber, int newContactNumber) {
		successful = false;
		UserDao userdao = new UserDaoImp(dbSingleton);
		successful = userdao.changeContactNumber(username, oldContactNumber, newContactNumber);
		return successful;
	}
	
	public boolean changePostalCode(String username, int oldPotsalCode, int newPotsalCode) {
		successful = false;
		UserDao userdao = new UserDaoImp(dbSingleton);
		successful = userdao.changePostalCode(username, oldPotsalCode, newPotsalCode);
		return successful;
	}
	
	@Override
	public boolean usernameExist(String username){
		UserDao userDao = new UserDaoImp(dbSingleton);
		exist = userDao.usernameExist(username);
		return exist;
	}
	
	@Override
	public boolean emailExist(String email){
		UserDao userDao = new UserDaoImp(dbSingleton);
		exist = userDao.emailExist(email);
		return exist;
	}

	@Override
	public boolean contactNumberExist(int contactNumber) {
		UserDao userDao = new UserDaoImp(dbSingleton);
		exist = userDao.contactNumberExist(contactNumber);
		return exist;
	}

}
