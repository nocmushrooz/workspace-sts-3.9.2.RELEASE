package com.fdmgroup.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Item.Item;
import com.fdmgroup.ItemDao.ItemDaoImpl;

public class DisplayItem extends HttpServlet 
{
			private static final long serialVersionUID = 8512732370489182501L;
			
//			public static Logger consoleLog = Logger.getLogger("consoleLog");	// =============================== // If you really insist on seeing console output, use this for console output:
//			static private Logger logger;
			
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
			{
//						BasicConfigurator.configure(); 
//						Logger logger = Logger.getLogger(DisplayItem.class);
//						PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");
						
						/* Using Singleton to get only 1 x JDBC connection instance */
						DBSingleton dbSingleton = DBSingleton.getInstance();
						ItemDaoImpl itemDaoImpl = new ItemDaoImpl(dbSingleton);
						
						/* Instantiate Item instance from implementation */
						List<Item> item_List = itemDaoImpl.getAllItem();
								
						/* (2) Set the required attributes such that response.jsp can receive ${xxx} values respectively */
						req.setAttribute("item_List", item_List); // --------------------------------------------------- ${productName}
								
						/* (3) Request forward to response.jsp */
						RequestDispatcher rd = req.getRequestDispatcher("Catalog.jsp");
						rd.forward(req, resp);
			}			
			
}
