package com.tap.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImpl implements MenuDao
{
	static Connection con;
	
	final static String INSERT_QUERY="insert into `menu`(`menuId`,`name`,`price`,`description`,`imagePath`,`isAvailable`,`ratings`) values(?,?,?,?,?,?,?)";
	final static String SELECT_QUERY="select * from `menu` where `MenuId`=?";
	final static String UPDATE_QUERY="update `menu` set `name`=?,`price`=?,`description`=?,`imagePath`=?,`isAvailable`=?,`ratings`=?,where `menuId`=?";
	final static String DELETE_QUERY="delete from `menu` where `menuId`=?";
	final static String SELECT_ALL_QUERY="select * from `menu`";
	final static String SELECT_MENU_QUERY="select * from `menu` where `restaurantId`=?";
	
	
	public MenuDaoImpl() 
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
	public void addMenu(Menu menu)
	{
		PreparedStatement pstmt;
		
		try 
		{
			pstmt=con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setString(2, menu.getName());
			pstmt.setFloat(3,menu.getPrice());
			pstmt.setString(4, menu.getDescription());
			pstmt.setString(5, menu.getImagePath());
			pstmt.setString(6, menu.getIsAvailable());
			pstmt.setFloat(7, menu.getRatings());
			
			pstmt.executeUpdate();
				
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId)
	{
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Menu menu=null;
		
		try 
		{
			//
			pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, menuId);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				float price=res.getFloat("price");
				String description=res.getString("description");
				String imagePath=res.getString("imagePath");
				String isAvailable=res.getString("isAvailable");
				float ratings=res.getFloat("ratings");
				int restaurantId=res.getInt("restaurantId");
				
				menu=new Menu(menuId, name, price, description, imagePath, isAvailable, ratings,restaurantId);
			}
		
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) 
	{
		PreparedStatement pstmt=null;
		
		try 
		{
			//"update `menu` set `name`=?,`price`=?,`description`=?,`imagePath`=?,`isAvailable`=?,`ratings`=?,`restaurantId`=? where `menuId`=?";
			pstmt=con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1,menu.getName());
			pstmt.setFloat(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagePath());
			pstmt.setString(5, menu.getIsAvailable());
			pstmt.setFloat(6, menu.getRatings());
			pstmt.setInt(7, menu.getMenuId());
			
			pstmt.executeUpdate();
	
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId)
	{
		PreparedStatement pstmt=null;
		
		try
		{
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, menuId);
			pstmt.executeUpdate();
	
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
	
		
	}

	@Override
	public List<Menu> getAllMenu() 
	{
		Statement stmt=null;
		ResultSet res=null;
		Menu menu=null;
		ArrayList<Menu> menu_List=new ArrayList<Menu>();
		
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next());
			{
				int menuId=res.getInt("userId");
				String name=res.getString("name");
				float price=res.getFloat("price");
				String description=res.getString("description");
				String imagePath=res.getString("imagePath");
				String isAvailable=res.getString("isAvailable");
				float ratings=res.getFloat("ratings");
				int restaurantId=res.getInt("restaurantId");
				
				menu=new Menu(menuId, name, price, description, imagePath, isAvailable, ratings, restaurantId);
				
				menu_List.add(menu);
				
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return menu_List;
	
	}
	
	public List<Menu> getMenuByRestaurant(int restaunrantId) 
	{
		Statement stmt=null;
		ResultSet res=null;
		Menu menu=null;
		ArrayList<Menu> menu_List=new ArrayList<Menu>();
		
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next());
			{
				int menuId=res.getInt("userId");
				String name=res.getString("name");
				float price=res.getFloat("price");
				String description=res.getString("description");
				String imagePath=res.getString("imagePath");
				String isAvailable=res.getString("isAvailable");
				float ratings=res.getFloat("ratings");
				int restaurantId=res.getInt("restaurantId");
				
				menu=new Menu(menuId, name, price, description, imagePath, isAvailable, ratings, restaurantId);
				
				menu_List.add(menu);
				
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return menu_List;
	
	}
}

