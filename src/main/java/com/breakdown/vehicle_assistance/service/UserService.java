package com.breakdown.vehicle_assistance.service;

import com.breakdown.vehicle_assistance.model.User;
import com.breakdown.vehicle_assistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User loginUser(String email, String password) {

    User user = userRepository.findByEmail(email);

    if (user != null && user.getPassword().equals(password)) {
        return user;
    }

    return null;
}

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

}
