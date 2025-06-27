package com.example.JewelShopWebApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Purchase {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private String userEmail;
    private String userPhone;
    private Long bookingId;
    
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(Long id, Long userId, String userEmail, String userPhone, Long bookingId) {
		super();
		this.id = id;
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.bookingId = bookingId;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
    
    
}