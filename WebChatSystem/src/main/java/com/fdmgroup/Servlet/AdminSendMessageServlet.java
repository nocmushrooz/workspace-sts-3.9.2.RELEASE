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

public class AdminSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MessageController mC = new MessageController();
	List<Message> mL = new ArrayList<Message>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		long viewQuery = 0;
		boolean success = false;
		String username = (String)session.getAttribute("usernameSession")+"(Admin)";
		String tempQuery = (String)session.getAttribute("viewQuery");
		String tempUsername = (String)session.getAttribute("AdminViewUserQuery");
		String msg = request.getParameter("message");
		String queryStatus = request.getParameter("updateStatus");
		String currentQueryStatus = (String)session.getAttribute("tempQueryStatus");
		
		try{
			viewQuery = Long.parseLong(tempQuery);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(!msg.isEmpty()){
			success = mC.adminSendMessage(tempUsername, username, tempQuery, msg);
		}
		
		if(!currentQueryStatus.equalsIgnoreCase(queryStatus)){
			mC.updateQueryStatus(viewQuery, queryStatus);
			session.removeAttribute("tempQueryStatus");
			session.setAttribute("tempQueryStatus", queryStatus);
			
			session.removeAttribute("queryList");
			List<QueryObj> queryList = mC.retrieveAdminQuery();
			session.setAttribute("queryList", queryList );
		}
		
		if(success){ 		
			mL = mC.retrieveQuery(tempUsername, viewQuery);	
			session.removeAttribute("messageList");
			session.setAttribute("messageList", mL);
		}else{
			request.setAttribute("error", "Unexpected Error");
			
		}
		rd = request.getRequestDispatcher("AdminViewQuery.jsp");
		rd.forward(request, response);
	}

}
