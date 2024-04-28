package com.tap.Dao;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDao 
{

	void addOrderItem(OrderItem orderitem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderitem);
	void deleteOrderItem(int orderItemId);
	List<OrderItem> getAllOrderItems();

}
