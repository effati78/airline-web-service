package com.airline.webservice.controller;

import com.airline.webservice.model.Fly;
import com.airline.webservice.service.AirlineDBManager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fly")

public class FlyAPI {

    AirlineDBManager dbs;
    Fly fly;

    @Autowired
    public FlyAPI(AirlineDBManager dbs) {
        this.dbs = dbs;
    }

    @GetMapping("/all")
    public List<Map<String, String>> getFlights() {
        return dbs.getFlights();
    }

    @GetMapping
    public Map<String, String> getfly(@RequestParam(value = "flyNumber") String flyNumber) {
        return dbs.getFly(flyNumber);
    }
}
