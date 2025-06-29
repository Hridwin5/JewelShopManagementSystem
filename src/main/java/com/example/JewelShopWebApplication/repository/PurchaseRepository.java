package com.example.JewelShopWebApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JewelShopWebApplication.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByUserId(Long userId);
}

