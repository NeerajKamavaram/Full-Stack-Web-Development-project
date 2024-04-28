package com.tap.model;

public class OrderItem
{
	private int orderItemId;
	
	private String itemName;
	private int quantity;
	private float ratings;
	private float price;
	
	public OrderItem() 
	{
		
	}

	public OrderItem(int orderItemId,String itemName, int quantity, float ratings,
			float price) {
		super();
		this.orderItemId = orderItemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.ratings = ratings;
		this.price = price;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return orderItemId+" "+itemName+" "+quantity+" "+ratings+" "+price;
	}

}

