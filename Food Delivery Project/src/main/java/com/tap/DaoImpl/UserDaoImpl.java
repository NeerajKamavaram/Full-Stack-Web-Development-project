package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.UserDao;
import com.tap.model.User;

public class UserDaoImpl implements UserDao
{
	private Connection con;
	
	final static String INSERT_QUERY="insert into `user` (`userId`,`name`,`email`,`phone_No`,`address`,`userName`,`passWord`,`role`) values(?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY="select * from `user` where `userId`=?";
	final static String UPDATE_QUERY="update `user` set `name`=?, `email`=?, `phone_No`=?, `address`=?,`userName`=?,`passWord`=? where `userId`=?";
	final static String DELETE_QUERY="delete from `user` where `userId`=?";
	final static String SELECT_ALL_QUERY="select * from `user`";
	final static String SELECT_USER_QUERY="select * from `user` where `userName`=? and `passWord`=?";
	
	public UserDaoImpl()
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
	public void addUser(User user) 
	{
		
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3,user.getEmail());
			pstmt.setLong(4,user.getPhone_No());
			pstmt.setString(5,user.getAddress());
			pstmt.setString(6,user.getUserName());
			pstmt.setString(7,user.getPassWord());
			pstmt.setString(8, user.getRole());
			
			pstmt.executeUpdate();
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		User user=null;
		
		try 
		{
			pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				String email=res.getString("email");
				long phone_No=res.getInt("phone_No");
				String address=res.getString("address");
				String userName=res.getString("userName");
				String passWord=res.getString("passWord");
				String role=res.getString("role");
				Timestamp timestamp1=res.getTimestamp("created_Date");
				Timestamp timestamp2=res.getTimestamp("last_LoginDate");
				LocalDateTime created_Date =timestamp1.toLocalDateTime();
				LocalDateTime last_LoginDate =timestamp2.toLocalDateTime();
				
				
				user=new User(userId,name, email, phone_No, address, userName, passWord,role,created_Date,last_LoginDate);
				
			}
			
		}
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}
    //"update `user` set `name`=?, `email`=?, `phone_No`=?, `address`=?,`userName`=?,`passWord`=? where `UserId`=?";
	@Override
	public void updateUser(User user)
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1,user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setLong(3, user.getPhone_No());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassWord());
			pstmt.setString(7, user.getRole());
			pstmt.setInt(8, user.getUserId());
			
			
			
			pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) 
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,userId);
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUsers()
	{
		Statement stmt=null;
		ResultSet res=null;
		User user=null;
		ArrayList<User> users_list= new ArrayList<User>();
		try 
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int userId=res.getInt("userID");
				String name=res.getString("name");
				String email=res.getString("email");
				long phone_No=res.getInt("phone_No");
				String address=res.getString("address");
				String userName=res.getString("userName");
				String passWord=res.getString("passWord");
				String role=res.getString("role");
				Timestamp timestamp1=res.getTimestamp("created_Date");
				Timestamp timestamp2=res.getTimestamp("last_LoginDate");
				LocalDateTime created_Date =timestamp1.toLocalDateTime();
				LocalDateTime last_LoginDate =timestamp2.toLocalDateTime();
				
				user=new User(userId,name, email, phone_No, address, userName, passWord,role,created_Date,last_LoginDate);
				
				users_list.add(user);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return users_list;
		
	
		
	}



	@Override
	public User getDetails(String username, String password)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		User user=null;
		
		try 
		{
			pstmt=con.prepareStatement(SELECT_USER_QUERY);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				int userId=res.getInt("userId");
				String name=res.getString("name");
				String email=res.getString("email");
				long phone_No=res.getInt("phone_No");
				String address=res.getString("address");
				String userName=res.getString("userName");
				String passWord=res.getString("passWord");
				String role=res.getString("role");
				Timestamp timestamp1=res.getTimestamp("created_Date");
				Timestamp timestamp2=res.getTimestamp("last_LoginDate");
				LocalDateTime created_Date =timestamp1.toLocalDateTime();
				LocalDateTime last_LoginDate =timestamp2.toLocalDateTime();
				
				
				user=new User(userId,name, email, phone_No, address, userName, passWord,role,created_Date,last_LoginDate);
			}
			
		}
		catch 
		(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}
	
}