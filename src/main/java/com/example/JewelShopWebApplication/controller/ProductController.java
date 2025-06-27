package com.example.JewelShopWebApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.Product;
import com.example.JewelShopWebApplication.service.ProductService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/products")
public class ProductController {
    @Autowired private ProductService service;

    @PostMapping
    public Product create(@RequestBody Product p) { return service.save(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) {
        return service.findById(id).map(prod -> {
            prod.setJewelName(p.getJewelName());
            prod.setPricePerGram(p.getPricePerGram());
            prod.setJewelType(p.getJewelType());
            prod.setWeight(p.getWeight());
            return ResponseEntity.ok(service.save(prod));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}