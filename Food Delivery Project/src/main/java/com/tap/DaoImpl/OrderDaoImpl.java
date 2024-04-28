package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderDao;
import com.tap.model.Order;

public class OrderDaoImpl implements OrderDao
{
	private Connection con=null;
	
	final static String INSERT_QUERY="insert into `order`(`orderId`,`totalAmount`,`modeOfPayment`,`status`) values(?,?,?,?)";
	final static String SELECT_QUERY="select * from `order` where `orderId`=?";
	final static String UPDATE_QUERY="update `order` set `totalAmount`=?,`modeOfPayment`=?,`status`=? where `orderId`=?";
	final static String DELETE_QUERY="delete from `order` where `orderId`=?";
	final static String SELECT_ALL_QUERY="select * from `order`";
	
	
	public OrderDaoImpl()
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
	public void addOrder(Order order)
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, order.getOrderId());
			pstmt.setFloat(2, order.getTotalAmount());
			pstmt.setString(3, order.getModeOfPayment());
			pstmt.setString(4, order.getStatus());
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrder(int orderId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Order order=null;
		
		try
		{
			pstmt=con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				int restaurantId=res.getInt("restaurantId");
				int userId=res.getInt("userId");
				float totalAmount=res.getFloat("totalAmount");
				String modeOfPayment=res.getString("modeOfPayment");
				String status=res.getString("status");
				
				order=new Order(orderId, totalAmount, modeOfPayment, status);
				
			}
	
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public void updateOrder(Order order)
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setFloat(1, order.getTotalAmount());
			pstmt.setString(2, order.getModeOfPayment());
			pstmt.setString(3,order.getStatus());
			pstmt.setInt(4, order.getOrderId());
			
			pstmt.executeUpdate();
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getAllOrders()
	{
		Statement stmt=null;
		ResultSet res=null;
		Order order=null;
		
		ArrayList<Order> orders_List=new ArrayList<Order>();
		try
		{
			stmt=con.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int orderId=res.getInt("orderId");
				int restaurantId=res.getInt("restaurantId");
				int userId=res.getInt("userId");
				float totalAmount=res.getFloat("totalAmount");
				String modeOfPayment=res.getString("modeOfPayment");
				String status=res.getString("status");
				
				order=new Order(orderId,totalAmount, modeOfPayment, status);
				
				orders_List.add(order);
				
			}
	
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return orders_List;
		
		
	}
	
	
}

