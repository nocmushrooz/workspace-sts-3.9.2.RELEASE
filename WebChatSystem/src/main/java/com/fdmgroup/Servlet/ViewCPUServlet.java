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
import com.fdmgroup.Item.Item;


public class ViewCPUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		HttpSession session = request.getSession();
		ItemController iC = new ItemController();
		List<Item> itemList = new ArrayList<Item>();
		List<Item> CPUList = new ArrayList<Item>();
		itemList = iC.getAllItem();
		for(Item item : itemList){
			if(item.getCategory().equalsIgnoreCase("CPU")){
				CPUList.add(item);
			}
		}
		session.setAttribute("CPUList", CPUList);
		rd = request.getRequestDispatcher("CPU.jsp");
		rd.forward(request, response);
	}

}