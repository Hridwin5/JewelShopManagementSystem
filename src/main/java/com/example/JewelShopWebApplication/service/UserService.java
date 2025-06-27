package com.example.JewelShopWebApplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JewelShopWebApplication.model.User;
import com.example.JewelShopWebApplication.repository.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;

    public User signup(User user) {
        return userRepo.save(user);
    }

    public Optional<User> login(String email, String rawPassword) {
        return userRepo.findByEmail(email)
            .filter(user -> user.getPassword().equals(rawPassword));
    }
}
