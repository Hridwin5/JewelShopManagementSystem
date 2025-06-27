package com.example.JewelShopWebApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JewelShopWebApplication.model.User;
import com.example.JewelShopWebApplication.service.UserService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        return ResponseEntity.ok(userService.signup(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User req) {
        return userService.login(req.getEmail(), req.getPassword())
            .map(user -> ResponseEntity.ok(user))
            .orElse(ResponseEntity.status(401).build());
    }
}
