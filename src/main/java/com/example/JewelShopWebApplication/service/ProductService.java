package com.example.JewelShopWebApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JewelShopWebApplication.model.Product;
import com.example.JewelShopWebApplication.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepo;

    public List<Product> getCatalog(String type, Double grams) {
        if (type != null && grams != null)
            return productRepo.findByJewelTypeAndWeightLessThanEqual(type, grams);
        if (type != null)
            return productRepo.findByJewelType(type);
        if (grams != null)
            return productRepo.findByWeightLessThanEqual(grams);
        return productRepo.findAll();
    }

    public Product save(Product p) { 
    	return productRepo.save(p); 
    	}
    public Optional<Product> findById(Long id) { 
    	return productRepo.findById(id); 
    	}
    public void delete(Long id) { 
    	productRepo.deleteById(id); 
    	}
}

