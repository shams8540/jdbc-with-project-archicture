package com.ibm.jdbc_preparedstatement_crud.entity;

public class Product {

	private int id;
	private String name;
	private String color;
	private double price;
	
	//to create constructor ALT+S+A
	public Product() {
		super();
	}

	public Product(int id, String name, String color, double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
	}

	//getter and setter ALT+S+R
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
