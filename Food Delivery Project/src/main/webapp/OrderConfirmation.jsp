<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tap.model.CartCreator" %>
     <%@page import="com.tap.model.CartItem" %>
     <%@page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order confirmation</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
</head>
<body>
	<p>Thank you for your order</p>
	<p>Your items</p>
	<% 
		CartCreator cc=(CartCreator) session.getAttribute("CartCreator");
		Map<Integer,CartItem> cart_list=cc.getAllItems();%>
		
	 <% for (Map.Entry<Integer, CartItem> entry : cart_list.entrySet()) { %>
            <p><%= entry.getValue().getName() %></p>
            <p>price: <%= entry.getValue().getPrice() %></p>
            <p>quantity:<%=entry.getValue().getQuantity() %>
            <%} %>
      
      <button><a href="Final.jsp">confirm</a></button>
</body>
</html>