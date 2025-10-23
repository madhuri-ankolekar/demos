package com.example.demo.controller;
import com.example.demo.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.User;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setRole("USER");
        System.out.println("hello world");
        System.out.println("hoping");
        System.out.println("bring");
        System.out.println("hello world");
        System.out.println("hoping");
        System.out.println("bring");
        System.out.println("hello world");
        System.out.println("hoping");
        System.out.println("bring");
        return ResponseEntity.ok(userService.saveUser(user));
    }



    
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers2() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
