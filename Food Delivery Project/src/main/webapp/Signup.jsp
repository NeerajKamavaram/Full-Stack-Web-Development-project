<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
<style>
       
       p{
        text-align: center;
        color: black;
        font-size: medium;
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
            margin-left:20px;

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
        .login a{
        	text-decoration:none;
        }
  
    </style>
</head>
<body>
	 <div id="sign">
        <legend><h2>Sign up</h2></legend>
    <form action="SignupServlet" method="post">
	    <input type="text" name="name" placeholder="Enter your name" required><br>
	    <input type="email" name="email" placeholder="Enter your Email" required><br>
	    <input type="text" name="phonenumber" placeholder="Enter your Phone number" required><br>
	    <input type="text" name="username" placeholder="username" required><br>
	    <input type="password" name="password" placeholder="password" required>
	    <input type="submit" value="Sign up">
	</form>

    
    <p class="login"> Already have an account <a href="Login.jsp">login</a></p>
    </div>
    
</body>
</html>