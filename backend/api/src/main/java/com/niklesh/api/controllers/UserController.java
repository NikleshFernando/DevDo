package com.niklesh.api.controllers;

import com.niklesh.api.dto.UserDTO;
import com.niklesh.api.entities.User;
import com.niklesh.api.repositories.UserRepository;
import com.niklesh.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserDTO user){

       return userService.createUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }
}
