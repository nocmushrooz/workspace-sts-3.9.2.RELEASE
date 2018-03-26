package com.fdmgroup.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.User.User;

public class UserDaoImp implements UserDao {
	
	private static Logger consoleLog = Logger.getLogger("consoleLog");
	private static DBSingleton dbSingleton;
	boolean successfulRegisterUser = false;
	boolean success = false;
	boolean exist = false;
	User user = null;
	List<User> userList = new ArrayList<User>();

	
	public UserDaoImp(DBSingleton dbSingleton){
		this.dbSingleton = dbSingleton;
	}
	
	private User retrieveUser(ResultSet tempUser){	
		try{
			while(tempUser.next()){		
				String tempUsername = tempUser.getString("USERNAME");
				String tempUserPassword = tempUser.getString("USERPASSWORD");
				String tempEmailAddress = tempUser.getString("EMAILADDRESS");
				String tempUserAddress = tempUser.getString("USERADDRESS");
				int tempPostalCode = tempUser.getInt("POSTALCODE");
				String tempNameOfUser= tempUser.getString("NAMEOFUSER");
				int tempContactNumber = tempUser.getInt("CONTACTNUMBER");
				String tempUserType = tempUser.getString("USERTYPE");
				
				if(tempUsername.equals("")){
					user = null;
				}else{
					user = new User(tempUsername, tempUserPassword, tempEmailAddress
							, tempUserAddress, tempPostalCode, tempNameOfUser, tempContactNumber,
							tempUserType);
				}
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	private List<User> retrieveUserFromResultSet(ResultSet rS){
		List<User> listUser = new ArrayList<User>();
		try{
			while(rS.next()){		
				String tempUsername = rS.getString("USERNAME");
				String tempUserPassword = rS.getString("USERPASSWORD");
				String tempEmailAddress = rS.getString("EMAILADDRESS");
				String tempUserAddress = rS.getString("USERADDRESS");
				int tempPostalCode = rS.getInt("POSTALCODE");
				String tempNameOfUser= rS.getString("NAMEOFUSER");
				int tempContactNumber = rS.getInt("CONTACTNUMBER");
				String tempUserType = rS.getString("USERTYPE");
				user = new User(tempUsername, tempUserPassword, tempEmailAddress
							, tempUserAddress, tempPostalCode, tempNameOfUser, tempContactNumber,
							tempUserType);
				listUser.add(user);	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public boolean usernameExist(String username){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT * FROM CHAT_USER WHERE username = '");
		sB.append(username).append("'");
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rS = statement.executeQuery(sB.toString());
			user = retrieveUser( rS );
			if(user != null){
				exist = true;
			}else
				exist = false;
			return exist;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean emailExist(String email){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT * FROM CHAT_USER WHERE EmailAddress = '");
		sB.append(email).append("'");
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rS = statement.executeQuery(sB.toString());
			user = retrieveUser( rS );
			if(user != null){
				exist = true;
			}else
				exist = false;
			return exist;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean contactNumberExist(int contactNumber){
		StringBuilder sB = new StringBuilder();
		sB.append("SELECT * FROM CHAT_USER WHERE CONTACTNUMBER = ");
		sB.append(contactNumber);
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rS = statement.executeQuery(sB.toString());
			user = retrieveUser( rS );
			if(user != null){
				exist = true;
			}else
				exist = false;
			return exist;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean registerNewUser(User user){
		String query = "INSERT INTO CHAT_USER (username, userpassword, emailaddress, useraddress, postalcode, nameofuser, contactnumber, usertype) values (?,?,?,?,?,?,?,?) ";
		
		
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);

		try{
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getEmailAddress());
			ps.setString(4, user.getUserAddress());
			ps.setInt(5, user.getPostalCode());
			ps.setString(6, user.getName());
			ps.setInt(7, user.getContactNumber());
			ps.setString(8, user.getUserType());
			ps.executeUpdate();
			if(user.getUserType().equalsIgnoreCase("User")){
				StringBuilder sB = new StringBuilder();
				sB.append("CREATE TABLE ").append(user.getUsername() + "_CART");
				sB.append(" (PRODUCT_ID NUMBER, QUANTITY NUMBER, FOREIGN KEY (PRODUCT_ID) REFERENCES ITEM(PRODUCT_ID))");
				Statement statement = dbSingleton.getStatement();		
				statement.executeQuery(sB.toString());
			}

			successfulRegisterUser = true;			
		}catch (SQLIntegrityConstraintViolationException e){
			successfulRegisterUser = false;
		}
		catch (SQLException e){
			e.printStackTrace();
			successfulRegisterUser = false;
		}
		return successfulRegisterUser;
	}
	
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		success = false;
		String query = "UPDATE CHAT_USER set userpassword = ? WHERE username = ? AND userpassword = ? ";
		String query1 ="SELECT * FROM CHAT_USER WHERE username = ? AND userpassword = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(query1);
		try{
			ps1.setString(1, username);
			ps1.setString(2, oldPassword);
			ResultSet rS = ps1.executeQuery();
			user = retrieveUser(rS);
			if(user != null){
				ps.setString(1, newPassword);
				ps.setString(2, username);
				ps.setString(3, oldPassword);
				ps.executeUpdate();
				success = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return success;
	}

	public boolean changeEmail(String username, String oldEmail, String newEmail) {
		success = false;
		String query = "UPDATE CHAT_USER set emailaddress = ? WHERE username = ? AND emailaddress = ?";
		String query1 ="SELECT * FROM CHAT_USER WHERE username = ? AND emailAddress = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(query1);
		try{
			ps1.setString(1, username);
			ps1.setString(2, oldEmail);
			ResultSet rS = ps1.executeQuery();
			user = retrieveUser(rS);
			if(user != null){
				ps.setString(1, newEmail);
				ps.setString(2, username);
				ps.setString(3, oldEmail);
				ps.executeUpdate();
				success = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return success;
	}

	public boolean changeAddress(String username, String oldAddress, String newAddress)
	{
		success = false;
		String query = "UPDATE CHAT_USER set userAddress = ? WHERE username = ? AND userAddress = ?";
		String query1 ="SELECT * FROM CHAT_USER WHERE username = ? AND userAddress = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(query1);
		try{
			ps1.setString(1, username);
			ps1.setString(2, oldAddress);
			ResultSet rS = ps1.executeQuery();
			user = retrieveUser(rS);
			if(user != null){
				ps.setString(1, newAddress);
				ps.setString(2, username);
				ps.setString(3, oldAddress);
				ps.executeUpdate();
				success = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean changePostalCode(String username, int oldPostalCode, int newPostalCode)
	{
		success = false;
		String query = "UPDATE CHAT_USER set postalCode = ? WHERE username = ? AND postalCode = ?";
		String query1 ="SELECT * FROM CHAT_USER WHERE username = ? AND postalCode = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(query1);
		try{
			ps1.setString(1, username);
			ps1.setInt(2, oldPostalCode);
			ResultSet rS = ps1.executeQuery();
			user = retrieveUser(rS);
			if(user != null){
				ps.setInt(1, newPostalCode);
				ps.setString(2, username);
				ps.setInt(3, oldPostalCode);
				ps.executeUpdate();
				success = true;
			}
			else
				System.out.println("No user found ..");
			
			System.out.println();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean changeContactNumber(String username, int oldContactNumber, int newContactNumber)
	{
		success = false;
		String query = "UPDATE CHAT_USER set contactNumber = ? WHERE username = ? AND contactNumber = ?";
		String query1 ="SELECT * FROM CHAT_USER WHERE username = ? AND contactNumber = ? ";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		PreparedStatement ps1 = dbSingleton.getPreparedStatement(query1);
		try{
			ps1.setString(1, username);
			ps1.setInt(2, oldContactNumber);
			ResultSet rS = ps1.executeQuery();
			user = retrieveUser(rS);
			if(user != null){
				ps.setInt(1, newContactNumber);
				ps.setString(2, username);
				ps.setInt(3, oldContactNumber);
				ps.executeUpdate();
				success = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return success;
	}
	
	public User getUserInfo(String username, String password){
		String query = "SELECT * FROM CHAT_USER WHERE USERNAME = ?";
		PreparedStatement ps = dbSingleton.getPreparedStatement(query);
		try {
			ps.setString(1, username);
			ResultSet tempUser = ps.executeQuery();
			user = retrieveUser(tempUser);
			if(user != null){
				if(user.getUserPassword().equalsIgnoreCase(password)){
					consoleLog.trace("UserDaoImp- User has successfully logged in");
					return user;
				}
				else{
					consoleLog.trace("UserDaoImp- Unable to find User");
					return null;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> retrieveAllUser(){
		String query = "SELECT * FROM CHAT_USER";
		Statement statement = dbSingleton.getStatement();
		try{
			ResultSet rS = statement.executeQuery(query);
			userList = retrieveUserFromResultSet(rS);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
		
	}

}
