package com.example.JewelShopWebApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JewelShopWebApplication.model.Purchase;
import com.example.JewelShopWebApplication.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired private PurchaseRepository purchaseRepo;
    public Purchase save(Purchase p) { 
    	return purchaseRepo.save(p);
    	}
    public List<Purchase> getByUser(Long userId) {
    	return purchaseRepo.findByUserId(userId); 
    	}
	public List<Purchase> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}