<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
 <style>
       
        p{
         text-align: center;
         color: black;
         font-size: medium;
         font-family: 'Times New Roman', Times, serif;
        }
        body{
         background-color: whitesmoke;
         font-family:'Times New Roman', Times, serif;
        }
         #sign{
            background-color: skyblue;
            border-radius: 10px;
            text-align:center;
            margin-top:8%;
            margin-left:40%;
            margin-right:40%; 
         }
         form{
             width:150px;
             margin-left:30px;
 
         }
         form input{
 
             width:180px;
             height:30px;
             border-radius: 6px;
             padding:5px;
             margin:auto;
             margin-top:10%;
             margin-left:20%;
         }
 
         input[type="submit"]{
             background-color: blanchedalmond;
             width:130%;
             height:30px;
             cursor:pointer;
 
         }
         
         .signup a{
         	text-decoration:none;
         }
   
     </style>
</head>
<body>
	<body>
    <div id="sign">
        <legend><h2>Login</h2></legend>

    <form action="HomeRestaurantServlet">
        <input type="text" name="username" placeholder="username" required><br>
        
        <input type="password" name="password" placeholder="password" required><br>

        <input type="submit" value="login">

        
    </form>

    <p class="signup">Don't have an account  <a href="Signup.jsp">Signup</a></p>

    </div>
</body>
</body>
</html>
