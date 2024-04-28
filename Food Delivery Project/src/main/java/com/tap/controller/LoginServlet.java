package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.UserDaoImpl;
import com.tap.model.User;

public class LoginServlet extends HttpServlet
{
	static int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetching username and password from request object
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//calling getWriter() method to display on browser
		PrintWriter out=resp.getWriter();
		//displaying content as login page
		resp.setContentType("type/html");
		
		//fetching user details using username and password 
		UserDaoImpl us=new UserDaoImpl();
		User user=us.getDetails(username, password);
		
		//validating user credentials
		if(user!=null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("HomeRestaurantServlet");
			rd.forward(req, resp);
		}
		else if(count>0)
		{
			out.println("Invalid Credentails "+count+" Attempts left");
			count++;
		}
		else
		{
			out.println("Attempts over try after sometime");
		}
	}

}
