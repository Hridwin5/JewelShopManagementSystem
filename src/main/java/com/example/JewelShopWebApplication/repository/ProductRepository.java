package com.example.JewelShopWebApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JewelShopWebApplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByJewelType(String jewelType);
    List<Product> findByWeightLessThanEqual(double weight);
    List<Product> findByJewelTypeAndWeightLessThanEqual(String jewelType, double weight);
}