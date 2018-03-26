package com.fdmgroup.UserDao;

import java.util.List;

import com.fdmgroup.User.User;

public interface UserDao {

	boolean registerNewUser(User user);
	boolean changePassword(String username,String oldPassword, String newPassword);
	boolean changeEmail(String username, String oldEmail, String newEmail);
	boolean changeAddress(String username, String oldAddress, String newAddress);
	boolean changePostalCode(String username, int oldPostalCode, int newPostalCode);
	boolean changeContactNumber(String username, int oldContactNumber, int newContactNumber);
	boolean usernameExist(String username);
	boolean emailExist(String email);
	boolean contactNumberExist(int contactNumber);
	User getUserInfo(String username, String password);
	List<User> retrieveAllUser();
}