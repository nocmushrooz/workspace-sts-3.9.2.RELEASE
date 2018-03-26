package com.fdmgroup.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.Controller.ItemController;
import com.fdmgroup.DBSingleton.DBSingleton;
import com.fdmgroup.Item.Item;
import com.fdmgroup.ItemDao.ItemDaoImpl;
import com.fdmgroup.ItemFactory.ItemFactory;

public class DisplayItemDetails extends HttpServlet 
{
			private static final long serialVersionUID = 8512732370489182501L;
			
//			public static Logger consoleLog = Logger.getLogger("consoleLog");	// =============================== // If you really insist on seeing console output, use this for console output:
			
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
			{
//				BasicConfigurator.configure(); 
//				Logger logger = Logger.getLogger(DisplayItemDetails.class);
//				PropertyConfigurator.configure("src/main/resources/META-INF/log4j.properties");
						
				DBSingleton dbSingleton = DBSingleton.getInstance();
				ItemDaoImpl itemDaoImpl = new ItemDaoImpl(dbSingleton);
				ItemFactory itemFactory = new ItemFactory();
				
				ItemController controller = new ItemController();
				
				String retrieveItemName = req.getParameter("productName");														  /**/	
//				logger.info("Line 50 - getParameter("+retrieveItemName+")");
				Item productName = controller.findItemInDataBase(retrieveItemName);	
//				logger.info("Line 52 - " + productName.getProductName());
				
				String productDescriptionJsp =  productName.getDescription();
//				logger.info("Line 53 - Setting Attribute '" + productDescriptionJsp + "' to ProductDetails.jsp >> ${productDescription}");
				req.setAttribute("productDescription",productDescriptionJsp );
				
				String productNameJsp =   productName.getProductName();
//				logger.info("Line 51 - Setting Attribute '" + productNameJsp + "' to ProductDetails.jsp >> ${productName}");
				req.setAttribute("productName",productNameJsp);
						
				RequestDispatcher rd = req.getRequestDispatcher("ProductDetails.jsp");
				rd.forward(req, resp);
			}			
			
}
