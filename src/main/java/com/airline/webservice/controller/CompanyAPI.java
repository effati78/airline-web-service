package com.airline.webservice.controller;

import com.airline.webservice.model.Company;
import com.airline.webservice.service.AirlineDBManager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")

public class CompanyAPI {

    AirlineDBManager dbs;
    Company company;

    @Autowired
    public CompanyAPI(AirlineDBManager dbs) {
        this.dbs = dbs;
    }

    @GetMapping("/all")
    public List<Map<String, String>> getCompanies() {
        return dbs.getCompanies();
    }

    @GetMapping
    public Map<String, String> getCompany(@RequestParam(value = "name") String name) {
        return dbs.getCompany(name);
    }
}
