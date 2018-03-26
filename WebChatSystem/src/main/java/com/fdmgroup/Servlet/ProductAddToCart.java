package com.fdmgroup.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.Controller.ItemController;

public class ProductAddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		int productID = 0;
		int inputQuantity = 0;
		String popupMessage ;
		ItemController iC = new ItemController();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("usernameSession");
		String tempProductID =  request.getParameter("hiddenProductID");
		String tempQuantity = request.getParameter("inputQuantity");
		try{
			productID = Integer.parseInt(tempProductID);
			inputQuantity = Integer.parseInt(tempQuantity);
		}catch(Exception e){
			e.printStackTrace();
		}
		boolean success = iC.addToCart(productID, username, inputQuantity);
		if (success){
			popupMessage = "Successful add to cart.";
			request.setAttribute("alertMsg", popupMessage);
		}else{
			popupMessage = "error in adding to cart.";
			request.setAttribute("alertMsg", popupMessage);
		}
		rd = request.getRequestDispatcher("Catalog.jsp");
		rd.forward(request, response);
	}

}
