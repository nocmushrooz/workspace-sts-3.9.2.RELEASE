package com.fdmgroup.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.Controller.MessageController;
import com.fdmgroup.Message.Message;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageController mC = new MessageController();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		List<Message> mL = new ArrayList<Message>();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("usernameSession");
		String tempQueryNo =  request.getParameter("rowValue");
		long queryNo = 0;
		try{
			queryNo = Long.parseLong(tempQueryNo);
		}catch (Exception e){
		
		}	
		mL = mC.retrieveQuery(username, queryNo);	
		session.setAttribute("viewQuery", tempQueryNo);
		session.setAttribute("messageList", mL);
		rd = request.getRequestDispatcher("ViewQuery.jsp");
		rd.forward(request, response);
	}

}
