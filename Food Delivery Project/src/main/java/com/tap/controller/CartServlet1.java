package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartCreator;
import com.tap.model.CartItem;

public class CartServlet1 extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		   //create CartCreator object from session
	       HttpSession session=req.getSession();
	       CartCreator cc=(CartCreator) session.getAttribute("CartCreator");
	       if(cc==null)
	       {
	    	   
	    	  cc=new CartCreator();
	    	  session.setAttribute("CartCreator", cc);
	       }
	       
	       //fetching action value from action attribute
	       String action=req.getParameter("action");
	       System.out.println(action);
	       //Add cart item
	       if("Add".equalsIgnoreCase(action))
	       {
	    	   // Retrieve the submitted parameters
	    	   String name = req.getParameter("name");
		       float price = Float.parseFloat(req.getParameter("price"));
		       int itemId = Integer.parseInt(req.getParameter("menuId"));
		       int restId=Integer.parseInt(req.getParameter("restId"));
		       int quantity = Integer.parseInt(req.getParameter("quantity_" + itemId));
	           CartItem ci=new CartItem(itemId, restId, name,price,quantity);
	           cc.addCartItem(ci);
	           
	        
	       }
	       //update the cart item quantity
	       else if("Update".equalsIgnoreCase(action))
	       {
	    	   int itemId = Integer.parseInt(req.getParameter("itemId"));
	    	   int quantity = Integer.parseInt(req.getParameter("quantity_"+ itemId));
	    	   cc.updateCartItem(itemId, quantity);
	       }
	       //delete the cart item
	       else if("Remove".equalsIgnoreCase(action))
	       {
	    	   int itemId = Integer.parseInt(req.getParameter("itemId"));
	    	   cc.deleteCartItem(itemId);
	    	   
	       }
	       else 
	       {
	    	   System.out.println("Action required");
	       }
	       
	       
	       
//	       
	     //forwarding to Cart.jsp
	       RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
	       rd.forward(req, resp); 
	       
	    }
	}

