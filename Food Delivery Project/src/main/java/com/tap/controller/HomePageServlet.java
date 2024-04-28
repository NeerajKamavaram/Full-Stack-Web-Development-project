package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;


@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet 
{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetching data from restaurant table
		RestaurantDaoImpl rest=new RestaurantDaoImpl();
		List<Restaurant> list=rest.getAllRestaurants();
		
		//setting restaurant list to request object
		req.setAttribute("restaurants", list);
		
		//redirecting to HomePage.jsp
		RequestDispatcher rd=req.getRequestDispatcher("HomePage.jsp");
		rd.forward(req, resp);
	}
	

}
