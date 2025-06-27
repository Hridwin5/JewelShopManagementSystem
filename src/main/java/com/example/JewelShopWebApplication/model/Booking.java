package com.example.JewelShopWebApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private Long productId;
    private double laborCost;
    private double wastageCost;
    private double totalAmount;
    private String estimatedMakingTime;
    private boolean paid;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Long id, Long userId, Long productId, double laborCost, double wastageCost, double totalAmount,
			String estimatedMakingTime, boolean paid) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.laborCost = laborCost;
		this.wastageCost = wastageCost;
		this.totalAmount = totalAmount;
		this.estimatedMakingTime = estimatedMakingTime;
		this.paid = paid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public double getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(double laborCost) {
		this.laborCost = laborCost;
	}
	public double getWastageCost() {
		return wastageCost;
	}
	public void setWastageCost(double wastageCost) {
		this.wastageCost = wastageCost;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getEstimatedMakingTime() {
		return estimatedMakingTime;
	}
	public void setEstimatedMakingTime(String estimatedMakingTime) {
		this.estimatedMakingTime = estimatedMakingTime;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
    
    
}
