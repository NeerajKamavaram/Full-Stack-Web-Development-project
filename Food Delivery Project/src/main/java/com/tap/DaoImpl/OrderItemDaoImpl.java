package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderItemDao;
import com.tap.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao
{
	private Connection con;
	
	final static String INSERT_QUERY="insert into `orderItem`(`orderItemId`,`itemName`,`quantity`,`ratings`,`price`) values(?,?,?,?,?)";
	final static String SELECT_QUERY="select * from `orderItem` where `orderItemId`=?";
	final static String UPDATE_QUERY="update `orderItem` set `itemName`=?,`quantity`=?,`ratings`=?,`price`=? where `orderItemId`=?";
	final static String DELETE_QUERY="delete from `orderItem` where `orderItemId`=?";
	final static String SELECT_ALL_QUERY="select * from `orderItem`";
	
	public OrderItemDaoImpl()
	{
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="1106";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
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
	public void addOrderItem(OrderItem orderitem) 
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1,orderitem.getOrderItemId());
			pstmt.setString(2, orderitem.getItemName());
			pstmt.setInt(3, orderitem.getQuantity());
			pstmt.setFloat(4, orderitem.getRatings());
			pstmt.setFloat(5, orderitem.getPrice());
			
			pstmt.executeUpdate();
	
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public OrderItem getOrderItem(int orderItemId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		OrderItem orderitem=null;
		try 
		{
			pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, orderItemId);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				String itemName=res.getString("itemName");
				int quantity=res.getInt("quantity");
				float ratings=res.getFloat("ratings");
				float price=res.getFloat("price");
				
				orderitem= new OrderItem(orderItemId,itemName, quantity, ratings, price);
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return orderitem;
	}
	
	//"update `orderItem` set `userId`=?,`menuId`=?,`itemName`=?,`quantity`=?,`ratings`=?,`price`=? where `orderItemId`=?";
	@Override
	public void updateOrderItem(OrderItem orderitem)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1,orderitem.getItemName());
			pstmt.setInt(2, orderitem.getQuantity());
			pstmt.setFloat(3,orderitem.getRatings());
			pstmt.setFloat(4, orderitem.getPrice());
			pstmt.setInt(5, orderitem.getOrderItemId());
	
			pstmt.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderItem(int orderItemId)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderItemId);
			pstmt.executeUpdate();
	
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<OrderItem> getAllOrderItems()
	{
		
		Statement stmt=null;
		ResultSet res=null;
		OrderItem orderitem=null;
		ArrayList<OrderItem> order_item_List=new ArrayList<OrderItem>();
		
		try
		{
			stmt=con.createStatement();

			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int orderItemId=res.getInt("orderItemId");
				int userId=res.getInt("userId");
				int menuId=res.getInt("menuId");
				String itemName=res.getString("itemName");
				int quantity=res.getInt("quantity");
				float ratings=res.getFloat("ratings");
				float price=res.getFloat("price");
				
				orderitem= new OrderItem(orderItemId,itemName, quantity, ratings, price);
				
				order_item_List.add(orderitem);
				
			}
	
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return order_item_List;
		
	}
	

}
