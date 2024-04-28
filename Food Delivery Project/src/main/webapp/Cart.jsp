<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tap.DaoImpl.RestaurantDaoImpl" %>
    <%@ page import="com.tap.model.Restaurant" %>
    <%@ page import="com.tap.model.CartItem" %>
    <%@ page import="com.tap.model.CartCreator" %>
    <%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
<style>
    body{
        background-color: lightgray;
    }
   .restaurant {
	    display: flex;
	    align-items: center;
    }
    .content{
        margin:50px 550px;
        padding:5px 30px;
        background-color: white

    }

    .info {
        display: flex;
        align-items: flex-start;
    }

    .details {
        margin-left: 10px; 
    }


    img {
    margin-top:20px;
    }
    .restname{
        margin-bottom:10px;
    }
    .address{
        margin-top:10px;
    }
    .quantity {
        display: flex;
        align-items: center;
    }
    .quantity-input {
        width: 50px;
        text-align: center;
    }

    .decrement, .increment {
        width: 30px;
        height: 30px;
        font-size: 16px;
        background-color: whitesmoke;
        border: none;
        cursor: pointer;
    }

    .decrement:hover, .increment:hover {
        color: skyblue;
    }

    .update:hover, .remove:hover{
        background-color: skyblue;
        color: white;
    }

</style>
</head>
<body>
<!-- fetching cart data from map -->
<% 
CartCreator cc=(CartCreator) session.getAttribute("CartCreator");
Map<Integer,CartItem> cart_list=cc.getAllItems();
RestaurantDaoImpl rest=new RestaurantDaoImpl();

// Check if the cart is not empty
if (cart_list != null && !cart_list.isEmpty()) 
{
    // Get the first cart item to retrieve the restaurant details
    Map.Entry<Integer, CartItem> firstEntry = cart_list.entrySet().iterator().next();
    Restaurant res = rest.getRestaurant(firstEntry.getValue().getRestId());
%>
    <!-- Display the restaurant image and details -->
    <div class="content">
        <div class="restaurant">
            <div class="info">
                <img src="<%=res.getImagePath() %>" width="50px" height="50px">
                <div class="details">
                    <p class="restname"><b><%=res.getName() %></b></p>
                    <p class="address"><%=res.getAddress() %></p>
                </div>
            </div>
        </div>
    
    <!-- Loop through cart items and display each item -->
    <% for (Map.Entry<Integer, CartItem> entry : cart_list.entrySet()) { %>
        <div class="item">
            <p><%= entry.getValue().getName() %></p>
            <p>price: <%= entry.getValue().getPrice() %></p>
            <div class="quantity">
                <form action="CartServlet1" method="POST">
                    <label for="quantity_<%= entry.getValue().getItemId()%>">Quantity:</label>
                    <input type="number" class="quantity-input" name="quantity_<%= entry.getValue().getItemId()%>" value="<%= entry.getValue().getQuantity() %>" >
                    <input type="hidden" name="itemId" value="<%= entry.getKey() %>">
                    <button class="update" type="submit" name="action" value="Update">Update</button>
                    <input type="hidden" name="itemId" value="<%= entry.getKey() %>">
                    <button class="remove" type="submit" name="action" value="Remove">Remove</button>
                </form>
            </div>
        </div>
    <% } %>
    </div> <!-- Close the content container here -->
<% } else { %>
    <!-- Display an empty cart message -->
    <div class="empty">
        <img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/2xempty_cart_yfxml0">
        <p>Your cart is empty</p>
    </div>
<% } %>

<a href="#">View Cart</a>
<br>
<a href="MenuServlet.java">Add More Items</a>
</body>

</html>
