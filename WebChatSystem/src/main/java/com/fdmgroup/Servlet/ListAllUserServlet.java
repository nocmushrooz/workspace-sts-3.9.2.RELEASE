package com.fdmgroup.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.Controller.UserController;
import com.fdmgroup.User.User;


public class ListAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		UserController uC = new UserController();
		List<User> ExistingUserList = new ArrayList<User>();
		ExistingUserList = uC.retrieveAllUser();
		request.setAttribute("ExistingUserList", ExistingUserList);
		rd = request.getRequestDispatcher("AdminViewAllUser.jsp");
		rd.forward(request, response);
	}

}
