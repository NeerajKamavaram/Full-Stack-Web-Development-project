package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class CartCreator
{
	Map<Integer,CartItem> cart;
	
	public CartCreator() 
	{
		cart=new HashMap<>();
	}
	
	public void addCartItem(CartItem ci)
	{
		if(cart.containsKey(ci.getItemId()))
		{
			CartItem cr=cart.get(ci.getItemId());
			int n=cr.getQuantity();
			int m=ci.getQuantity();
			int res=n+m;
			cr.setQuantity(res);
			cart.put(cr.getItemId(), cr);
		}
		else
		{
			cart.put(ci.getItemId(), ci);
		}
	}
	
	public void updateCartItem(int itemId,int quantity)
	{
		cart.get(itemId).setQuantity(quantity);
	}
	
	public void deleteCartItem(int itemId)
	{
		cart.remove(itemId);
	}
	
	public Map<Integer,CartItem> getAllItems()

	{
		return cart;
	}
	
}
