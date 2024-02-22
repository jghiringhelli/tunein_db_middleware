package com.tunein.services.dbmiddleware.controller;

import com.tunein.services.dbmiddleware.db.entities.User;
import com.tunein.services.dbmiddleware.services.TuneInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class TuneInController {

    @Autowired
    TuneInService tuneInService;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return tuneInService.getUser(id);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body){

        String username = body.get("username");
        String weight = body.get("weight");
        String height = body.get("height");
        String age = body.get("age");
        String sex = body.get("sex");
        String race = body.get("race");
        String ethnicity = body.get("ethnicity");
        String education_level = body.get("education_level");
        String employment_status = body.get("employment_status");
        String created_at = body.get("created_at");

        return tuneInService.saveUser(username, weight, height, age, sex, race,
                ethnicity, education_level, employment_status, created_at);
    }
}
