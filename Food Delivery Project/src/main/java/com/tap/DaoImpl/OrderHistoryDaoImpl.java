package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderHistoryDao;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao
{
private Connection con;
	
	final static String INSERT_QUERY="insert into `orderHistory`(`orderHistoryId`) values(?)";
	final static String SELECT_QUERY="select * from `orderHistory` where `orderHistoryId`=?";
	final static String UPDATE_QUERY="update `orderHistory` set where `orderHistoryId`=?";
	final static String DELETE_QUERY="delete from `orderHistory` where `orderHistoryId`=?";
	final static String SELECT_ALL_QUERY="select * from `orderHistory`";
	
	public OrderHistoryDaoImpl()
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
	public void addOrderHistory(OrderHistory orderhistory) 
	{
		PreparedStatement pstmt=null;
		
		try {
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, orderhistory.getOrderHistoryId());
			
			pstmt.executeUpdate();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		OrderHistory orderhistory=null;
		
		try 
		{
			pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, orderHistoryId);
			
			res=pstmt.executeQuery();
			if(res.next())
			{
				int orderId=res.getInt("orderId");
				int userId=res.getInt("userId");
				
				orderhistory=new OrderHistory(orderHistoryId);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return orderhistory;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderhistory)
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			
			pstmt.setInt(1, orderhistory.getOrderHistoryId());
			
			pstmt.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderHistoryId);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() 
	{
		
		
		Statement stmt=null;
		ResultSet res=null;
		OrderHistory orderhistory=null;
		ArrayList<OrderHistory> order_history_List=new ArrayList<OrderHistory>();
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			while(res.next())
			{
				int orderHistoryId=res.getInt("orderHistoryId");
				int orderId=res.getInt("orderId");
				int userId=res.getInt("userId");
				
				orderhistory=new OrderHistory(orderHistoryId);
				
				order_history_List.add(orderhistory);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return order_history_List;
	}

}
