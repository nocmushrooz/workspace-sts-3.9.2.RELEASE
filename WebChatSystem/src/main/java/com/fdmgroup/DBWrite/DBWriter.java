package com.fdmgroup.DBWrite;

import com.fdmgroup.User.User;

public interface DBWriter {

	boolean writeUser(User user);
	boolean changePassword(String username,String oldPassword, String newPassword);
	boolean changeEmail(String username, String oldEmail, String newEmail);
	boolean usernameExist(String username);
	boolean emailExist(String email);
	boolean contactNumberExist(int contactNumber);
}
