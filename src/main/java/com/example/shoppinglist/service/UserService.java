package com.example.shoppinglist.service;

import com.example.shoppinglist.model.User;
import com.example.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepresentation representation) {
        User user = new User();
        user.setUserName(representation.getUserName());
        user.setPassword(passwordEncoder.encode(representation.getPassword()));

        repository.save(user);
    }
}
