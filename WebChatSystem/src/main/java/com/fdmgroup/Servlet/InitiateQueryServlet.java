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
import com.fdmgroup.Query.QueryObj;


public class InitiateQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MessageController mC = new MessageController();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		List<QueryObj> queryList = new ArrayList<QueryObj>();
		List<Message> mL = new ArrayList<Message>();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("usernameSession");
		String categoryField = request.getParameter("categoryField");
		String subject = request.getParameter("subjectArea");
		long tempQueryNum = mC.initiateNewQuery(username, categoryField, subject);
		if(tempQueryNum != 0){
			session.removeAttribute("queryList");
			queryList = mC.retrieveUserQuery(username);
			String queryNum =  Long.toString(tempQueryNum);
			mL = mC.retrieveQuery(username, tempQueryNum);	
			session.setAttribute("messageList", mL);
			session.setAttribute("viewQuery", queryNum);
			session.setAttribute("queryList", queryList);
			rd = request.getRequestDispatcher("ViewQuery.jsp");
		
		}else{
			request.setAttribute("error", "Unexpected error");
			rd = request.getRequestDispatcher("newQuery.jsp");
		}
		rd.forward(request, response);
	}
	
}
