package com.tap.model;

public class Order 
{

	int orderId;
	//int restaurantId;
	//int userId;
	float totalAmount;
	String modeOfPayment;
	String status;
	
	
	public Order() 
	{
		
	}


	public Order(int orderId, float totalAmount, String modeOfPayment, String status) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString()
	{
		return orderId+" "+totalAmount+" "+" "+modeOfPayment+" "+status;
	}

}

