package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao
{
	private Connection con=null;
	
	final static String INSERT_QUERY="insert into `restaurant`(`restaurantId`,`name`,`imagePath`,`ratings`,`eta`,`cuisineType`,`address`,`isActive`) values(?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY="select * from `restaurant` where `restaurantId`=?";
	final static String UPDATE_QUERY="update `restaurant` set `name`=?,`imagePath`=?,`ratings`=?,`eta`=?,`cuisineType`=?,`address`=?,`isActive`=? where `restaurantId`=?";
	final static String DELETE_QUERY="delete from `restaurant` where `restaurantId`=?";
	final static String SELECT_ALL_QUERY="select * from `restaurant`";
	
	
	public RestaurantDaoImpl()
	{
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="1106";
		
		try
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("connection established");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void addRestaurant(Restaurant restaurant) 
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2,restaurant.getName());
			pstmt.setString(3, restaurant.getImagePath());
			pstmt.setFloat(4, restaurant.getRatings());
			pstmt.setInt(5, restaurant.getEta());
			pstmt.setString(6, restaurant.getCuisineType());
			pstmt.setString(7, restaurant.getAddress());
			pstmt.setString(8, restaurant.getIsActive());
			
			pstmt.executeUpdate();
	
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Restaurant restaurant=null;
		
		try
		{
			pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1,restaurantId);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				String imagePath=res.getString("imagePath");
				Float ratings=res.getFloat("ratings");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String address=res.getString("address");
				String isActive=res.getString("isActive");
				
				restaurant=new Restaurant(restaurantId,name,imagePath,ratings,eta,cuisineType,address,isActive);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant)
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			//update `restaurant` set `name`=?,`imagePath`=?,`ratings`=?,`eta`=?,`cuisineType`=?,``address`=?,`isActive`=? where `restaurantId`=?";
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1,restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRatings());
			pstmt.setInt(4, restaurant.getEta());
			pstmt.setString(5, restaurant.getCuisineType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setString(7, restaurant.getIsActive());
			pstmt.setInt(8, restaurant.getRestaurantId());
			
			pstmt.executeUpdate();

		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, restaurantId);
			pstmt.executeUpdate();
			
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Restaurant> getAllRestaurants()
	{
		
		Statement stmt=null;
		ResultSet res=null;
		Restaurant restaurant=null;
		List<Restaurant> restaurant_list=new ArrayList<Restaurant>();
		
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			while(res.next())
			{
				int restaurantId=res.getInt("restaurantId");
				String name=res.getString("name");
				String imagePath=res.getString("imagePath");
				Float ratings=res.getFloat("ratings");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String address=res.getString("address");
				String isActive=res.getString("isActive");
				
				restaurant=new Restaurant(restaurantId,name,imagePath,ratings,eta,cuisineType,address,isActive);
				
				restaurant_list.add(restaurant);
	
			}
	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return restaurant_list;
		
	}
	

}

