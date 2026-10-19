package com.niklesh.api.services;

import com.niklesh.api.entities.User;
import com.niklesh.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(User user){

        String hashedPassword = passwordEncoder.encode(user.getPassword());

        User u = new User();

        u.setEmail(user.getEmail());
        u.setPassword(hashedPassword);
        u.setUsername(user.getUsername());
        u.setRole(user.getRole());

        return userRepository.save(u);

    }

    public User getUserByUsername(String username){

        return userRepository.findUserByUsername(username);
    }
}
