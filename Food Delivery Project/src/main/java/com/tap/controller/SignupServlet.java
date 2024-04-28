package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoImpl.UserDaoImpl;
import com.tap.model.User;
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetching user details from request object
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
		String username=req.getParameter("username");
		//encrypting username
		String En_username=Encrypt_user(username);
		
		String password=req.getParameter("password");
		//encrypting password
		String Encrypt_pass=Encrypt_pass(password);
		
		//inserting user details in user table
		UserDaoImpl us=new UserDaoImpl();
		User user=new User(0,name, email, phonenumber, null, En_username, password,null,null,null);
		us.addUser(user);
		
		//redirecting to login.jsp
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req,resp);
	}
	
	//Encrypting method for username
	static String Encrypt_user(String username)
	{
		char ar[]=new char[username.length()];
		for(char i=0;i<ar.length;i++)
		{
			ar[i]=(char) (username.charAt(i)+1);
		}
		return ar.toString();
	}
	
	//Encrypting method for password
	static String Encrypt_pass(String password)
	{
		char ar[]=new char[password.length()];
		for(char i=0;i<ar.length;i++)
		{
			ar[i]=(char) (password.charAt(i)+1);
		}
		return ar.toString();
		
	}
	
	

}
