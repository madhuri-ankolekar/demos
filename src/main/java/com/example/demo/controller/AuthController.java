package com.example.demo.controller;
import com.example.demo.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.User;

import com.example.demo.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerAdmin(@RequestBody User user) {
        user.setRole("ADMIN");
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.get("email"), request.get("password")));
        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = jwtUtil.generateToken(request.get("email"));
        User u = userService.getByEmail(request.get("email")).get();

        Map<String, Object> res = new HashMap<>();
        res.put("token", token);
        res.put("role", u.getRole());
        res.put("email", u.getEmail());


        System.out.println("************************************************************done");
        return ResponseEntity.ok(res);
    }
}
