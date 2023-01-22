package com.airline.webservice.controller;

import com.airline.webservice.model.User;
import com.airline.webservice.service.AirlineDBManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
//127.0.0.1:8080/user/

public class UserAPI {

    AirlineDBManager dbs;
    User user;

    @Autowired
    public UserAPI(AirlineDBManager dbs) {
        this.dbs = dbs;
    }

    @GetMapping("/register")
    public Map<String, String> registerUser(@RequestParam(value = "name") String name,
            @RequestParam(value = "family") String family,
            @RequestParam(value = "phone") String phone, @RequestParam(value = "role") String role,
            @RequestParam(value = "password") String password, @RequestParam(value = "tickets") String tickets) {

        User user = new User(name, family, phone, role, password, tickets);
        dbs.registerUser(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("status", "201");
        map.put("success", "true");
        map.put("message", "Register User Done");
        return map;
    }
    
    @GetMapping("/all")
    public List<Map<String, String>> getUsers() {
        return dbs.getUsers();
    }

    @GetMapping
    public Map<String, String> getUser(@RequestParam(value = "phone") String phone,
            @RequestParam(value = "password") String password) {
        return dbs.getUser(phone, password);
    }

    @GetMapping("/changeRole")
    public String changeRole(@RequestParam(value = "phone") String phone) {
        return dbs.changeRole(phone);
    }
}
