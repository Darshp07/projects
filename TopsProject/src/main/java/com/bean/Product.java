package com.bean;

public class Product {

	
	int id , price;
	String productName, Category, model, description;

	public Product() {
		
	}
	public Product(String productName, String category, String model, int price, String description) {

		this.productName = productName;
		Category = category;
		this.model = model;
		this.price = price;
		this.description = description;
	}

	public Product(int id, String productName, String category, String model, int price, String description) {

		this.id = id;
		this.productName = productName;
		Category = category;
		this.model = model;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
