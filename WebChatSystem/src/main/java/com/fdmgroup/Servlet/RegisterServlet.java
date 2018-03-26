package com.fdmgroup.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.Controller.UserController;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserController uC = new UserController();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;
		int tempPostalcode = 0, tempContactNumber = 0;
		String username = req.getParameter("fieldUsername");
		String userPassword = req.getParameter("fieldPassword");
		String userAddress = req.getParameter("fieldAddress");
		String postalCode = req.getParameter("fieldPostCode");
		String name = req.getParameter("fieldName");
		String contactNumber = req.getParameter("fieldContactNumber");
		String emailAddress = req.getParameter("fieldEmailAddress");
		String userType = "User";
		
		try{
			tempPostalcode = Integer.parseInt(postalCode);
			tempContactNumber = Integer.parseInt(contactNumber);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		boolean usernameExist = uC.usernameExist(username);
		boolean emailAddressExist = uC.emailExist(emailAddress);
		boolean contactExist = uC.contactExist(tempPostalcode);

		if((usernameExist == true ) ||(emailAddressExist == true) || (contactExist == true)){
			if(usernameExist == true){
				req.setAttribute("errorUsernameExist", "Username has been used");
			}
			if(emailAddressExist == true){
				req.setAttribute("errorEmailAddressExist", "Email address has been used");
			}
			if(contactExist == true){
				req.setAttribute("errorContactExist", "Contact number has been used");
			}
			rd = req.getRequestDispatcher("Register.jsp");
			rd.forward(req, resp);
		}else
		{
			boolean createdUser = uC.createNewUser(username, userPassword, userAddress, 
									tempPostalcode, name, tempContactNumber, emailAddress, userType);	
			
			if (createdUser == true){
				String someMessage = "Register Successful. Please Login.";
				req.setAttribute("alertMsg", someMessage);
				rd = req.getRequestDispatcher("index.jsp");
			}
			else{
				req.setAttribute("error", "Unexpected Error");
				rd = req.getRequestDispatcher("Register.jsp");
			}
			rd.forward(req, resp);
		}
	}
}
