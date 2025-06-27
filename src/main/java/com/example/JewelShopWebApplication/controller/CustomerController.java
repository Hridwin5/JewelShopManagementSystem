package com.example.JewelShopWebApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.Purchase;
import com.example.JewelShopWebApplication.service.PurchaseService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired private PurchaseService purchaseService;

    @GetMapping("/{userId}/purchases")
    public List<Purchase> getPurchases(@PathVariable Long userId) {
        return purchaseService.getByUser(userId);
    }
    @GetMapping
    public List<Purchase> getAll() {
        return purchaseService.getAll();
    }
}
