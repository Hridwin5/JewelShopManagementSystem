package com.example.JewelShopWebApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JewelShopWebApplication.model.Booking;
import com.example.JewelShopWebApplication.model.Product;
import com.example.JewelShopWebApplication.repository.BookingRepository;
import com.example.JewelShopWebApplication.repository.ProductRepository;

@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepo;
    @Autowired private ProductRepository productRepo;

    public Booking createBooking(Long userId, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        double labor = 2000;
        double wastage = product.getPricePerGram() * product.getWeight() * 0.05;
        double total = product.getPricePerGram() * product.getWeight() + labor + wastage;

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setProductId(productId);
        booking.setLaborCost(labor);
        booking.setWastageCost(wastage);
        booking.setTotalAmount(total);
        booking.setEstimatedMakingTime("3 days");
        booking.setPaid(false);
        return bookingRepo.save(booking);
    }

    public Booking pay(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId).orElseThrow();
        booking.setPaid(true);
        return bookingRepo.save(booking);
    }
}

