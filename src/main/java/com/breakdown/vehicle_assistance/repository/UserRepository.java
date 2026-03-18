package com.breakdown.vehicle_assistance.repository;

import com.breakdown.vehicle_assistance.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}