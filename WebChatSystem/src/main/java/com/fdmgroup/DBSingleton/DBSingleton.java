package com.fdmgroup.DBSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;


public class DBSingleton {
	   
		private static String db_url;
	    private static String db_user;
		private static String db_password;
		private static Connection conn;
		private static Logger logger;

		private DBSingleton() {
	        db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	        db_user = "Trainee1";
	        db_password = "!QAZSE4";
			
//	        db_url = "jdbc:oracle:thin:@localhost:1522:wong2";
//	        db_user ="sys as sysdba";
//	        db_password = "admin123";
	        setConnection();
	     }

		
		private static void setConnection() {
			
			try{	
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		        String url = "" + db_url;
		        conn = DriverManager.getConnection(url, db_user, db_password);
		    } catch (SQLException ex) {
		    	logger.error("Unable to set connection", ex);                           
		    }                
		}
	
	
		private static class DbSingeltonManagerHolder {
			private final static DBSingleton instance = new DBSingleton();
		}
		               
          
		public static DBSingleton getInstance() {                                
			try {                                          
				return DbSingeltonManagerHolder.instance;	                                
			} catch (ExceptionInInitializerError ex) {                                         
				logger.error("Unable to get Instance", ex);                                            
				return null;                              
			}               
		}
		                
		                
		public Statement getStatement() {                                
			try {                                    
				return conn.createStatement();            
			} catch (SQLException ex) {
		      logger.error("Unable to create statement", ex);	                                                
		      return null;	                                
			}             
		}

		public PreparedStatement getPreparedStatement(String query){
			try{
				return conn.prepareStatement(query);
			}catch(SQLException ex){
				 logger.error("Unable to create Prepared statement", ex);	                                                
			     return null;	         
			}
		}
}
