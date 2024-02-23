package com.tunein.services.dbmiddleware.services;

import com.tunein.services.dbmiddleware.db.entities.User;
import com.tunein.services.dbmiddleware.db.repositories.TuneInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class TuneInService {

    @Autowired
    TuneInRepository tuneInRepository;

    TuneInService() {
    }

    public Optional<User> getUser(String userId) {
        try {
            assert userId != null : "User id cannot be null";
            int userIdInt = Integer.parseInt(userId);
            return tuneInRepository.findById(userIdInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid user id");
        }
    }

    public User saveUser(String username, int weight, int height, int age, boolean sex,
                         String race, String ethnicity, String educationLevel, String employmentStatus, Timestamp createdAt) {
        return tuneInRepository.save(new User(username, weight, height, age, sex, race, ethnicity, educationLevel, employmentStatus, createdAt));
    }
}
