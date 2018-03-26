package com.fdmgroup.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.Controller.UserController;

public class UpdateUserDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private UserController uC = new UserController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException //Errors to be caught in controller
	{
		RequestDispatcher rd;
		HttpSession session= req.getSession();  
		String username = null, email = null, password = null, address = null;
		int contactNumber = 0, postalCode = 0;
		boolean updateEmail = false, updatePswd = false, updateAddress = false, updateContactNumber = false, updatePostalCode = false;
		
		if(session != null)
		{
			username = (String)session.getAttribute("usernameSession");
	    	email = (String)session.getAttribute("emailAddressSession");  
	    	password = (String)session.getAttribute("passwordSession"); 
	    	address = (String)session.getAttribute("addressSession");
	    	postalCode = (Integer)session.getAttribute("postalCodeSession");
	    	contactNumber = (Integer)session.getAttribute("contactNumberSession");

			String updatedEmail = req.getParameter("email");
			String updatedPswd = req.getParameter("password");
			String updatedAddress = req.getParameter("address");
			String updatedPostalCodeInStr = req.getParameter("postalCode");
			int updatedPostalCode = Integer.parseInt(updatedPostalCodeInStr);
			String updateContactNumInStr = req.getParameter("contactNum");
			int updatedContactNumber = Integer.parseInt(updateContactNumInStr);
			
			
			if(updatedEmail.equals("") || updatedPswd.equals("") || updatedAddress.equals("") || updatedPostalCodeInStr.equals("") || updateContactNumInStr.equals(""))
			{
				req.setAttribute("alertMsg", "Error! Please fill out all required fields!");
				rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp); 
			}
			else
			{
				if (email.equals(updatedEmail) && password.equals(updatedPswd) && address.equals(updatedAddress) && postalCode == updatedPostalCode && contactNumber == updatedContactNumber) // No changes to be commit
				{
					req.setAttribute("alertMsg", "No changes to be committed! Redirecting you to User Menu ...");
					rd = req.getRequestDispatcher("LoginHome.jsp");
					rd.forward(req, resp); 
				}
				else
				{
					String stat = "Updates committed to: \\n";
					
					if (!email.equals(updatedEmail)) //User changed email address
						updateEmail = uC.updateEmailAddress(username, email, updatedEmail);
					
					if (!password.equals(updatedPswd)) //User changed password
						updatePswd = uC.updatePassword(username, password, updatedPswd); 
					
					if (!address.equals(updatedAddress)) //User changed address
						updateAddress = uC.updateAddress(username, address, updatedAddress);
					
					if (postalCode != updatedPostalCode) //User changed postal code
						updatePostalCode = uC.updatePostalCode(username, postalCode, updatedPostalCode);
					
					if (contactNumber != updatedContactNumber) //User changed contact number
						updateContactNumber = uC.updateContactNumber(username, contactNumber, updatedContactNumber);
					
					if(updateEmail == true)
						stat += "\\t - Email \\n";
					
					if(updatePswd == true)
						stat += "\\t - Password \\n";
					
					if(updateAddress == true)
						stat += "\\t - Address \\n";
					
					if(updatePostalCode == true)
						stat += "\\t - Postal Code \\n";
					
					if(updateContactNumber == true)
						stat += "\\t - Contact Number \\n";
					
					stat += "\\nRedirecting you to Login Page ...";
					
					req.setAttribute("alertMsg", stat);
					rd = req.getRequestDispatcher("index.jsp");
					rd.forward(req, resp); 
				}
			}
		}
	}
}
