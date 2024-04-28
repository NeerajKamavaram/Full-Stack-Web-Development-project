package com.tap.model;

public class OrderHistory
{
	private int orderHistoryId;
	
	
	public OrderHistory()
	{
		
	}

	public OrderHistory(int orderHistoryId) {
		super();
		this.orderHistoryId = orderHistoryId;
		
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}


	
	@Override
	public String toString()
	{
		return orderHistoryId+" ";
	}

}
