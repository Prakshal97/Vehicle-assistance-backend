package com.breakdown.vehicle_assistance.controller;

import com.breakdown.vehicle_assistance.model.User;
import com.breakdown.vehicle_assistance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
public User loginUser(@RequestBody User user) {
    return userService.loginUser(user.getEmail(), user.getPassword());
}
}
