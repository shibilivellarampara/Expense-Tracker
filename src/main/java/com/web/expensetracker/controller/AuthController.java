package com.web.expensetracker.controller;

import com.web.expensetracker.dto.AuthRequestDTO;
import com.web.expensetracker.dto.AuthResponseDTO;
import com.web.expensetracker.model.User;
import com.web.expensetracker.repository.UserRepository;
import com.web.expensetracker.security.JwtUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    public void logLoad() {
        System.out.println("🚀 AuthController loaded successfully!");
    }


    // 🔐 Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        String token = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponseDTO(token, authRequest.getUsername()));
    }

    // 📝 Register Endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequestDTO authRequest) {
        if (userRepository.findByUsername(authRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        User newUser = new User();
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        newUser.setEmail(authRequest.getEmail());
        newUser.setPhoneNumber(authRequest.getPhoneNumber());
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/ping")
    public String ping() {
        return "AuthController is active";
    }

}
