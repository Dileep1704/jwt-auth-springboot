package com.example.demo.controller;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthUser;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthUserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody AuthUser user) {

        user.setPassword(encoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }

        userRepo.save(user);

        return "User registered successfully";
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

        AuthUser user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }
}