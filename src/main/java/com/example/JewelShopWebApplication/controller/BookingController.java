package com.example.JewelShopWebApplication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.Booking;
import com.example.JewelShopWebApplication.service.BookingService;


@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/bookings")
public class BookingController {
    @Autowired private BookingService bookingService;
    
    @PostMapping("/book/{productId}/user/{userId}")
    public ResponseEntity<Booking> book(@PathVariable Long productId, @PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.createBooking(userId, productId));
    }

    @PostMapping("/pay/{bookingId}")
    public ResponseEntity<String> pay(@PathVariable Long bookingId, @RequestBody Map<String, String> req) {
        bookingService.pay(bookingId);
        String cardNumber = req.get("cardNumber");
        return ResponseEntity.ok("Paid with card: " + cardNumber.substring(12));
    }
}

