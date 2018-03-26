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
import com.fdmgroup.Controller.ItemController;
import com.fdmgroup.Controller.MessageController;
import com.fdmgroup.Controller.UserController;
import com.fdmgroup.Item.Item;
import com.fdmgroup.Query.QueryObj;
import com.fdmgroup.User.User;

public class LoginServlet extends HttpServlet 
{
	private UserController uC = new UserController();
	private User user = new User();
	private static final long serialVersionUID = 1L;
	private MessageController mC = new MessageController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher rd;
		HttpSession session = req.getSession();
		List<QueryObj> queryList = new ArrayList<QueryObj>();
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		user = uC.loginUser(username, password);		
		
		boolean userExist = uC.usernameExist(username);
		if(userExist == false){
			req.setAttribute("error", "Invalid Username, please try again");
			rd = req.getRequestDispatcher("index.jsp");
		}else{
			if(user != null){
				if(user.getUserType().equalsIgnoreCase("Admin")){
					queryList = mC.retrieveAdminQuery();
					List<User> userList = uC.retrieveAllUser();
					session.setAttribute("queryList", queryList );
					session.setAttribute("userList", userList);
					rd = req.getRequestDispatcher("AdminLoginHome.jsp");
				}else{
					queryList = mC.retrieveUserQuery(username);
					session.setAttribute("queryList", queryList );
					rd = req.getRequestDispatcher("LoginHome.jsp");
				}

				session.setAttribute("usernameSession", user.getUsername());
				session.setAttribute("passwordSession", user.getUserPassword());
				session.setAttribute("addressSession", user.getUserAddress());
				session.setAttribute("postalCodeSession", user.getPostalCode());
				session.setAttribute("emailAddressSession", user.getEmailAddress());
				session.setAttribute("contactNumberSession", user.getContactNumber());
				session.setAttribute("userType", user.getUserType());				
			}
			else{
				req.setAttribute("error", "Incorrect password, please try again");
				rd = req.getRequestDispatcher("index.jsp");
			}
		}
		rd.forward(req, resp);
	}
}
