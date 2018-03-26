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

public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MessageController mC = new MessageController();
	List<Message> mL = new ArrayList<Message>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("usernameSession");
		String tempQuery = (String)session.getAttribute("viewQuery");
		String msg = request.getParameter("message");
		boolean success = mC.sendMessage(username, tempQuery, msg);
		if(success){ 
			long viewQuery = 0;
			try{
				viewQuery = Long.parseLong(tempQuery);
			}catch(Exception e){
				e.printStackTrace();
			}
			mL = mC.retrieveQuery(username, viewQuery);	
			session.removeAttribute("messageList");
			session.setAttribute("messageList", mL);
		}else{
			request.setAttribute("error", "Unexpected Error");
			
		}
		rd = request.getRequestDispatcher("ViewQuery.jsp");
		rd.forward(request, response);
		}
}
