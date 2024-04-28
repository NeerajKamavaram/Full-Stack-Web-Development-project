package com.tap.model;

public class Restaurant
{
	private int restaurantId;
	private String name;
	private String imagePath;
	private float ratings;
	private int eta;
	private String cuisineType;
	private String address;
	private String isActive;
	
	public Restaurant() 
	{
		
	}

	public Restaurant(int restaurantId, String name, String imagePath, float ratings, int eta, String cuisineType,
			String address, String isActive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
	}
	

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() 
	{
		return restaurantId+" "+name+" "+imagePath+" "+ratings+" "+eta+" "+cuisineType+" "+address+" "+isActive;
	}
	

}
