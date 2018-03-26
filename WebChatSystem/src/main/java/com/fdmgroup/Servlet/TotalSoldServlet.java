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

import com.fdmgroup.Controller.TransactionController;
import com.fdmgroup.TotalSold.TotalSoldObj;


public class TotalSoldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		Set<TotalSoldObj> totalSoldList = new HashSet<TotalSoldObj>();
		TransactionController tC = new TransactionController();
		totalSoldList = tC.retrieveTotalSold();	
		session.setAttribute("totalSoldList", totalSoldList);
		rd = request.getRequestDispatcher("AdminTotalSold.jsp");
		rd.forward(request, response);
	}

}
