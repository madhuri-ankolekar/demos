package com.example.demo.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        // No password encoding
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getByEmail(String email) {
        return repo.findByEmail(email);
    }
}
