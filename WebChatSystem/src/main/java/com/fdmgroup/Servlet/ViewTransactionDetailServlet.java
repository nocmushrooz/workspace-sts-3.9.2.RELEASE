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
import com.fdmgroup.CheckOut.CheckOutObj;
import com.fdmgroup.Controller.TransactionController;


public class ViewTransactionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		int orderID = 0;
		HttpSession session = request.getSession();
		TransactionController tC = new TransactionController();
		Set<CheckOutObj> viewTransaction = new HashSet<CheckOutObj>();
		String tempOrderID = request.getParameter("hiddenOrderID");
		try{
			orderID = Integer.parseInt(tempOrderID); 
		}catch (Exception e){
			System.out.println("Unable to convert String to int order ID");
		}
		viewTransaction = tC.getTransactionItem(orderID);
		session.setAttribute("orderID", orderID);
		session.setAttribute("viewTransaction", viewTransaction);
		rd = request.getRequestDispatcher("AdminViewTransaction.jsp");
		rd.forward(request, response);
	}

}
