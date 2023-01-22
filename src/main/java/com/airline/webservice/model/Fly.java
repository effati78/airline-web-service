package com.airline.webservice.model;

public class Fly {

    private String company;
    private String origin;
    private String goal;
    private String time;
    private String date;
    private String price;
    private String reservedSeats;
    private String travelers;
    private String flyNumber;

    public Fly() {
    }

    public Fly(String company, String origin, String goal) {
        this.company = company;
        this.origin = origin;
        this.goal = goal;
    }

    // company
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // origin
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    // goal
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    // time
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // price
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    // reservedSeats
    public String getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(String reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    // travelers
    public String getTravelers() {
        return travelers;
    }

    public void setTravelers(String travelers) {
        this.travelers = travelers;
    }

    // flyNumber
    public String getFlyNumber() {
        return flyNumber;
    }

    public void setFlyNumber(String flyNumber) {
        this.flyNumber = flyNumber;
    }

    public String getAllFlightsQuery() {
        return "SELECT * FROM `fly`;";
    }

    public String getFlyQuery(String flyNumber) {
        return "SELECT * FROM `fly` WHERE flyNumber = " + flyNumber + ";";
    }

    public String getCurrentFlightsQuery(String date) {
        return "SELECT * FROM `fly` WHERE date = " + date + ";";
    }
}
