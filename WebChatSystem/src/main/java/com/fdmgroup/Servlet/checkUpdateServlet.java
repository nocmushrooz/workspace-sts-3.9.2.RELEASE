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
import com.fdmgroup.Item.Item;
import com.fdmgroup.Message.Message;

public class checkUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MessageController mC = new MessageController();
	List<Message> mL = new ArrayList<Message>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		int productID = 0;
		int quantity = 0;
		double price = 0.00;
		boolean success = false;
		String stat;
		ItemController iC = new ItemController();
		List<Item> itemList = new ArrayList<Item>();
		Item selectedItem = new Item();
		itemList = iC.getAllItem();
		
		String tempPrice = (String) request.getParameter("updatePrice");
		String tempQuantity = (String) request.getParameter("updateQuantity");
		String updateDescription = (String) request.getParameter("updateDescription");
		String tempItemID = (String) request.getParameter("hiddenItem");
		
		try{
			productID = Integer.parseInt(tempItemID);
			price = Double.parseDouble(tempPrice);
			quantity = Integer.parseInt(tempQuantity);
		}catch(Exception e){
			
		}
		for(Item item: itemList){
			if(item.getProductID() == productID){
				selectedItem = item;
			}
		}
		if((selectedItem.getQuantity() == quantity) && (selectedItem.getPrice() == price ) 
				&& (selectedItem.getDescription().equalsIgnoreCase(updateDescription))){
			stat = "Nothing has been updated \\n";	
		}else
		{
			stat = "Updated Item: \\n";	
			if(selectedItem.getQuantity() != quantity ){
				success = iC.updateQuantity(productID, quantity);
				if(success){
					stat += "\\t - Quantity \\n";
				}
			}
			if(selectedItem.getPrice() != price ){
				success = iC.updatePrice(productID, price);
				if(success){
					stat += "\\t - Price \\n";
				}
			}
			if(!selectedItem.getDescription().equalsIgnoreCase(updateDescription)){
				success = iC.updateDescription(productID, updateDescription);
				if(success){
					stat += "\\t - Description \\n";
				}
			}
		}	
		request.setAttribute("alertMsg", stat);
		session.removeAttribute("adminItemList");
		session.setAttribute("adminItemList", itemList);
		rd = request.getRequestDispatcher("AdminListAllItem.jsp");
		rd.forward(request, response);
	}

}
