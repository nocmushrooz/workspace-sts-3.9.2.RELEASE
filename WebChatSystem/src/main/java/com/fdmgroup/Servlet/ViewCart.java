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

public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("usernameSession");
		ItemController iC = new ItemController();
		Set<CartObj> cartList = new HashSet<CartObj>();
		cartList = iC.retrieveCart(username);
		session.setAttribute("cartList", cartList);
		rd = request.getRequestDispatcher("ViewCart.jsp");
		rd.forward(request, response);
	}

}
