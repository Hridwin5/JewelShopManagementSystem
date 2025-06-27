package com.example.JewelShopWebApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String jewelName;
    private double pricePerGram;
    private String jewelType;
    private double weight;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String jewelName, double pricePerGram, String jewelType, double weight) {
		super();
		this.id = id;
		this.jewelName = jewelName;
		this.pricePerGram = pricePerGram;
		this.jewelType = jewelType;
		this.weight = weight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJewelName() {
		return jewelName;
	}
	public void setJewelName(String jewelName) {
		this.jewelName = jewelName;
	}
	public double getPricePerGram() {
		return pricePerGram;
	}
	public void setPricePerGram(double pricePerGram) {
		this.pricePerGram = pricePerGram;
	}
	public String getJewelType() {
		return jewelType;
	}
	public void setJewelType(String jewelType) {
		this.jewelType = jewelType;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
    
    
}
