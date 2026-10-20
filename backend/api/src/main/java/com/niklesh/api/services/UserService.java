package com.niklesh.api.services;

import com.niklesh.api.dto.UserDTO;
import com.niklesh.api.entities.User;
import com.niklesh.api.entities.UserDetails;
import com.niklesh.api.repositories.UserDetailsRepository;
import com.niklesh.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(UserDTO user){

        String hashedPassword = passwordEncoder.encode(user.getPassword());

        String[] name = user.getFullname().split(" ");

        String username = name[0];

        User u = new User();
        UserDetails ud = new UserDetails();

        //Setting up the user table
        u.setEmail(user.getEmail());
        u.setPassword(hashedPassword);
        u.setUsername(username);
        u.setRole(user.getRole());

        User savedUser =  userRepository.save(u);

        //Setting up the user details table
        ud.setFullname(user.getFullname());
        ud.setUid(savedUser.getUid());
        ud.setDob(user.getDob());
        ud.setEducation(user.getEducation());
        ud.setProfession(user.getProfession());

        userDetailsRepository.save(ud);

        return savedUser;

    }

    public User getUserByUsername(String username){

        return userRepository.findUserByUsername(username);
    }
}
