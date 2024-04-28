<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tap.model.Restaurant" %>
     <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/9134/9134355.png">
<style>
*{
    margin:0;
    padding:0;
    font-family: Arial;
    box-sizing: border-box;
    
}

/* Header */
.image_container{
    width:100%;
    height:450px;
    position:relative;
}
.image_container img{
    width:100%;
    height:100%;
    object-fit: cover;
}
/* body of the header */
.header_body{
    width:50%;
    position:absolute;
    top:0;
    padding:180px;
    margin-left: 350px;
}
.header_body h1,p{
    text-align: center;
    color: white;
    font-size: larger;
    font-family: inherit; 
}
.header_body .h1{
    text-align: center;
    text-transform: uppercase;
    color: whitesmoke;
    font-size:100px;
}
.header_body .para{
    font-size:25px;
}
/* Home,signup,login horizontal list */
nav{
    width:100%;
    position:absolute;
    top:0;
    left:0;
    float:left;
    padding:10px 10px;
}
.bar{
    width:100%;
    height:50px;
}
.bar ul{
    float:right;
    list-style-type: none;
    display:flex;
}
.bar ul li{
    padding:20px;
    font-size: larger;
    
}
.bar ul li a{
    margin-right: 20px;
    color: aliceblue;
    text-decoration: none;
}
.bar ul li a:hover{
    background-color: black;
    padding: 10px;
}

/* main */
.body{
    margin-left:80px;
    margin-right:80px;
    height:130px;
}
/* Cuisine Type list */
.body ul{
    float:left;
    list-style-type: none;
    display:flex;
}
.body ul li{
    padding:1px;
    margin:1px;
    justify-content: space-between;
    gap:20px;
}
.body ul li a img{
    width:100%;
    height:100%;
}
.body ul li a:hover img{
    transform: scale(1.1);
}

/* main part division*/
.container{
    margin-left:80px;
    margin-right:10px;
    min-height:300vh;
}

/* Restaurant list */
.container ul{
    margin-left:80px;
    margin-right:80px;
    float:left;
    list-style-type: none;
    display:flex;
    flex-wrap: wrap;
}

.container ul li{
    padding:2px;
    margin:50px;
    justify-content: space-between;

}

.container ul li a{
    text-decoration: none;
    color:black;
}
.container ul li a img{
    border-radius: 8px;
}

.container ul li a:hover img {
    transform: scale(1.1);
}

.heading{
    padding-top: 8px;
}

/* footer section */

.footer{
    background-color: rgb(20, 17, 17);
    color:white;
    height:90vh;
    bottom: 0%;
}

/* footer above part background color lightgrey */
.above{
    margin-top: 40px;
    height:20vh;
    background-color: lightgray;
    bottom: 0%;
}
.above ul{
    float:right;
    list-style-type: none;
    display:flex;
}

.above ul li{
    font-size: 45px;
    color:black
}

/*section part background black*/
.footer .section{
    display:flex;
    justify-content: space-between;
    max-width: 900px;
    min-width: 900px;
    margin:0 auto;
    padding:76px 0;
}

/* logo below line styling */
.food{
    list-style: none;
}

.food a{
    text-decoration: none;
    color:grey;
}

/* list of company,legal,we deliver to,contact us */
.footer-li {
    padding: 20px 10px 1px 0px;
    list-style: none;
}

.footer-li a{
    text-decoration: none;
    color:grey;
}

.legal{
    padding :70px 10px 2px 0px;
}



</style>
</head>
<body>
	 <!--Header-->
    <header>
        <div class="image_container">
            <img src="https://b.zmtcdn.com/web_assets/81f3ff974d82520780078ba1cfbd453a1583259680.png" alt="food">

            <div class="header_body">
                <h1 class="h1">Foodie</h1>
                <p class="para">Discover the best food & drinks in Bengaluru</p>
            </div>
            <nav>
                <div class="bar">
                    
                    <ul>
                    	<li><a href="#">Cart</a></li>
                    	<li><a href="#">Orders</a></li>
                        <li><a href="HomePageServlet.java">Logout</a></li>
                    </ul>
        
                </div>
            </nav>
        </div>
    </header>
        <!--Main-->
       <h2>What's on your mind?</h2>

       <div class="body">
        <!--cuisine list-->
        <ul>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029845/PC_Creative%20refresh/3D_bau/banners_new/Burger.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667625/PC_Creative%20refresh/Biryani_2.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029856/PC_Creative%20refresh/3D_bau/banners_new/Pizza.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029858/PC_Creative%20refresh/3D_bau/banners_new/Rolls.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029855/PC_Creative%20refresh/3D_bau/banners_new/Noodles.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1675667626/PC_Creative%20refresh/South_Indian_4.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029852/PC_Creative%20refresh/3D_bau/banners_new/Momos.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029860/PC_Creative%20refresh/3D_bau/banners_new/Sandwich.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029848/PC_Creative%20refresh/3D_bau/banners_new/Chinese.png" width="10%" height="10%"></a></li>
            <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_288,h_360/v1674029845/PC_Creative%20refresh/3D_bau/banners_new/Cakes.png" width="10%" height="10%"></a></li>
        </ul>
        </div>
        
        <!--Restaurant list-->
        <%List<Restaurant> res=(List<Restaurant>)request.getAttribute("restaurants");%>
        <div class="container">
             <%for(Restaurant restaurant:res){ %>
            <ul>
                <li>
                	<!-- This anchor tag describes which restaurant menu should display through restaurantId-->
                    <a href="MenuServlet?restaurantId=<%=restaurant.getRestaurantId()%>">
                        <img src="<%= restaurant.getImagePath() %>" alt="<%= restaurant.getName() %>">
                        <%= restaurant.getName() %>
                        <%= restaurant.getRatings() %>
                        <%= restaurant.getEta() %>
                        <%= restaurant.getCuisineType() %>
                        <%= restaurant.getAddress() %>
                    </a>
                </li>
            </ul>
        <% } %>
        
        </div>

    <!--Footer-->
    <footer class="footer">
        <!-- above part get app on playstore and appstore-->
        <div class="above">
            <ul>
                <li>For better experience,download the Foodie app</li>
                <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/portal/m/play_store.png" alt="playstore" width="120px"></a></li>
                <li><a href="#"><img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/portal/m/app_store.png" alt="appstore" width="120px" height="40px"></a></li>
            </ul>
        </div>
        <!--section part company,legal,we deliver to,contact us-list-->
        <div class="section">
        <div>
            <ul>
                <img src="https://cdn-icons-png.flaticon.com/512/9134/9134355.png" alt="logo" width="25px" height="25px">
                <li class="food"><a href="#">Foodie Technologies Pvt.Ltd</a></li>
            </ul>
        </div>

        <div>
            <ul>
                <b>Company</b>
                <li class="footer-li"><a href="#">About</a></li>
                <li class="footer-li"><a href="#">Careers</a></li>
                <li class="footer-li"><a href="#">Team</a></li>
                <li class="footer-li"><a href="#">Foodie One</a></li>
                <li class="footer-li"><a href="#">Foodie Instmart</a></li>
                <li class="footer-li"><a href="#">Foodie Genie</a></li>
            </ul>
        </div>

        <div>
            <ul>
                <b>Contact us</b>
                <li class="footer-li"><a href="#">Help & Support</a></li>
                <li class="footer-li"><a href="#">Parter with us</a></li>
                <li class="footer-li"><a href="#">Ride with us</a></li>
                <div class="legal">
                <b>Legal</b>
                <li class="footer-li"><a href="#">Terms and Conditions</a></li>
                <li class="footer-li"><a href="#">Cookie Policy</a></li>
                <li class="footer-li"><a href="#">Privacy Policy</a></li>
                </div>
            </ul>
        </div>

        <div>
            <ul>
                <b>We deliver to:</b>
                <li class="footer-li"><a href="#">Bengaluru</a></li>
                <li class="footer-li"><a href="#">Hyderabad</a></li>
                <li class="footer-li"><a href="#">Chennai</a></li>
                <li class="footer-li"><a href="#">Pune</a></li>
                <li class="footer-li"><a href="#">Mumbai</a></li>
                <li class="footer-li"><a href="#">Delhi</a></li>
            </ul>
        </div>

        </div>


    </footer>



</body>
</html>
