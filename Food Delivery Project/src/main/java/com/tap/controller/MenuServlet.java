package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DaoImpl.MenuDaoImpl;
import com.tap.model.Menu;

public class MenuServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetching restaurantId from request object
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		MenuDaoImpl menu=new MenuDaoImpl();
		//fetching menus by restaurantId
		List<Menu> menu_list=menu.getMenuByRestaurant(restaurantId);
		
		//calling session object
		HttpSession session=req.getSession();
		//setting menu list in session
		session.setAttribute("MenuList", menu_list);

		//redirecting to menu.jsp
		RequestDispatcher rd=req.getRequestDispatcher("Menu.jsp");
		rd.forward(req,resp);
	
	}
	

}
