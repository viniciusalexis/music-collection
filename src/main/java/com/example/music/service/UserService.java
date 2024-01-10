package com.example.music.service;

import com.example.music.model.UserModel;
import com.example.music.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel registerUser(UserModel user) {
        checkIfUserExists(user.getUsername());
        return userRepository.save(user);
    }

    public UserModel loginUser(String username, String password) {
        Optional<UserModel> existingUser = userRepository.findByUsername(username);

        if (existingUser.isPresent()) {
            UserModel user = existingUser.get();
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new IllegalArgumentException("Incorrect password.");
            }
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    private void checkIfUserExists(String username) {
        Optional<UserModel> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("There is already a registered user with this email.");
        }
    }
}