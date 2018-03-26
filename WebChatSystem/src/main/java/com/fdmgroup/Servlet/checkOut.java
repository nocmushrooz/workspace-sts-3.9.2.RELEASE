package com.fdmgroup.Servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.Cart.CartObj;
import com.fdmgroup.Controller.ItemController;
import com.fdmgroup.Controller.TransactionController;

public class checkOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		String someMessage = null ;
		boolean success = false;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("usernameSession");
		TransactionController tC = new TransactionController();
		ItemController iC = new ItemController();
		Set<CartObj> cartObj = new HashSet<CartObj>();
		cartObj = iC.retrieveCart(username);
		if(cartObj.size() != 0){
			success = tC.newTransaction(username);
		}else{
			someMessage = "Your cart is empty.";
			rd = request.getRequestDispatcher("ViewCart.jsp");
		}
		
		if(success){
			someMessage = "ITEM is on your way.";
			rd = request.getRequestDispatcher("LoginHome.jsp");
		}else{
			someMessage = "Unexpected error.";
			rd = request.getRequestDispatcher("ViewCart.jsp");
		}
		
		request.setAttribute("alertMsg", someMessage);
		rd.forward(request, response);
	}

}
