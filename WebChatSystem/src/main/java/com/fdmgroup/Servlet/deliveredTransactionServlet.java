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
import com.fdmgroup.Transaction.TransactionObj;


public class deliveredTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		int orderID = 0;
		HttpSession session = request.getSession();
		Set<TransactionObj> transactionList = new HashSet<TransactionObj>();
		TransactionController tC = new TransactionController();
		String tempOrderID = request.getParameter("hiddenOrderID");
		String deliveryStatus = request.getParameter("btnSubmit");
		try{
			orderID = Integer.parseInt(tempOrderID); 
		}catch (Exception e){
			System.out.println("Unable to convert String to int order ID");
		}
		boolean success = tC.updateDeliveryStatus(orderID, deliveryStatus);
		if(success){
			transactionList = tC.getAllTransactionList();
			session.setAttribute("transactionList", transactionList);
		}else{
			
		}
		
		rd = request.getRequestDispatcher("AdminTransaction.jsp");
		rd.forward(request, response);
	}

}
