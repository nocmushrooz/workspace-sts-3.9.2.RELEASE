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
import com.fdmgroup.Item.Item;
import com.fdmgroup.Message.Message;

public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MessageController mC = new MessageController();
	List<Message> mL = new ArrayList<Message>();
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		int productID = 0;
		ArrayList<Item> itemList = new ArrayList<Item>();
		Item selectedItem = new Item();
		itemList = (ArrayList<Item>)session.getAttribute("adminItemList");
		String tempProductID = request.getParameter("hiddenProductID");
		try{
			productID = Integer.parseInt(tempProductID);
		}catch(Exception e){
			
		}
		for(Item item: itemList){
			if(item.getProductID() == productID){
				selectedItem = item;
			}
		}
		session.setAttribute("selectedItem", selectedItem);
		rd = request.getRequestDispatcher("AdminUpdateItem.jsp");
		rd.forward(request, response);
	}

}
