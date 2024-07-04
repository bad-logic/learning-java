package com.example.partA.products;

public class Product {
	private String name;
	private double price;
	private String slug;

	public Product(String name, String slug, double price) {
		this.name = name;
		this.slug = slug;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}
