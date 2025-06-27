package com.example.JewelShopWebApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.Product;
import com.example.JewelShopWebApplication.service.ProductService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired private ProductService service;

    @GetMapping
    public List<Product> search(@RequestParam(required = false) String type,
                                @RequestParam(required = false) Double weight) {
        return service.getCatalog(type, weight);
    }
}
