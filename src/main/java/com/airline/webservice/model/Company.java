package com.airline.webservice.model;

public class Company {

    private String name;
    private String image;
    private String flights;

    public Company() {
    }

    public Company(String name, String image, String flights) {
        this.name = name;
        this.image = image;
        this.flights = flights;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // flights
    public String getFlights() {
        return flights;
    }

    public void setFlights(String flights) {
        this.flights = flights;
    }

    public String getAllCompaniesQuery() {
        return "SELECT * FROM `company`;";
    }

    public String getCompanyQuery(String name) {
        return "SELECT * FROM `company` WHERE name = " + name + ";";
    }
}
