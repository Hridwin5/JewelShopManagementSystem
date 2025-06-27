package com.example.JewelShopWebApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.Booking;
import com.example.JewelShopWebApplication.repository.BookingRepository;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/reports")
public class ReportController {
    @Autowired private BookingRepository repo;

    @GetMapping("/sales")
    public Map<String, Object> report() {
        List<Booking> bookings = repo.findAll();
        double total = bookings.stream().filter(Booking::isPaid)
            .mapToDouble(Booking::getTotalAmount).sum();
        Map<String, Object> res = new HashMap<>();
        res.put("totalSales", total);
        res.put("bookingsCount", bookings.size());
        return res;
    }
}