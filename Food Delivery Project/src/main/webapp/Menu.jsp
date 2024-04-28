<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tap.model.Menu" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
<style>
        *{
            margin:0;
            padding:0;
        }
        .menu_container{
            margin-top:150px;
            margin-left: 350px;
        }
        .menu_item{
            height:max-content;
            width:max-content;
            display:inline-flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding-bottom: 20px;
        }
        .menu_info{
            margin-right: 180px;
            padding-top:70px;
        }
        
        .image_info img{
            position: relative;
            border-radius: 8px;
        }
        .image_info a{
            position:absolute;
            border:1px solid whitesmoke;
            padding: 10px 35px;
            background-color: white;
            text-decoration: none;
            color: aqua;
            border-radius: 6px;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            font-weight: 900;
            font-size: larger;
            top: 310px;
            margin-left:30px;
            font-size: medium;
        }
    </style>
</head>
<body>
	<div class="menu_container">
		<!-- fetching menu list from session object -->
        <% List<Menu> menuList = (List<Menu>) request.getAttribute("MenuList"); %>
        <% for(Menu item : menuList) { %>
            <div class="menu_item">
                <div class="menu_info">
                    <h2><%= item.getName() %></h2>
                    <p class="price">Price: <%= item.getPrice() %></p>
                    <p class="desc"><%= item.getDescription() %></p>
                </div>
                <div class="image_info">
                    <img src="<%= item.getImagePath() %>" alt="<%= item.getName() %>" width="180px" height="180px">
                    <div class="quantity">
                    	 <!-- Form to add items to cart -->
                    	<form action="CartServlet1" method="GET">
                    	
                    	<label for="quantity_<%= item.getMenuId()%>">Quantity:</label>
						<input type="text" name="quantity_<%= item.getMenuId() %>" id="quantity_<%= item.getMenuId() %>">
                        <input type="hidden" name="name" value="<%= item.getName() %>">
                        <input type="hidden" name="price" value="<%= item.getPrice() %>">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="restId" value="<%=item.getRestaurantId() %>"><br>
                        <input type="submit" name="action" value="Add" class="add_button">
                        
                    	</form>
                    </div>
                </div>
            </div>
        <% } %>
    </div>
</body>
</html>