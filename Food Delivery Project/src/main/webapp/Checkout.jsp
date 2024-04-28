<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkout</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
<style>
form{
	margin:300px 600px;
}
.first{
	margin-bottom:10px;
}
.address{
	margin-left:55px;
}
.confirm{
	margin:10px;
	margin-left:60px;
	cursor:pointer;
}





</style>
</head>
<body>
	<form action="OrderConfirmation.jsp">
	<div class=first>
    <label for="address">Address:</label>
    <input type="text" name="address" id="address" class="address"><br>
    </div>
    
    <label for="payment">Payment Method:</label>
    <select name="payment" id="payment">
        <option value="credit_card">Credit Card</option>
        <option value="debit_card">Debit Card</option>
        <option value="paypal">UPI</option>
        <option value="cash">Cash on Delivery</option>
    </select><br>
    
    
    <input  class="confirm" type="submit" value="confirm">
</form>

</body>
</html>