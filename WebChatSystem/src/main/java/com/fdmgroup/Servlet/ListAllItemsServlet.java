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


public class ListAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		List<Item> adminItemList = new ArrayList<Item>();
		ItemController iC = new ItemController();
		adminItemList = iC.getAllItem();
		session.setAttribute("adminItemList", adminItemList);
		rd = request.getRequestDispatcher("AdminListAllItem.jsp");
		rd.forward(request, response);
	}

}
