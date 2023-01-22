package com.airline.webservice.model;

public class User {

    private String name;
    private String family;
    private String phone;
    private String role;
    private String password;
    private String tickets;

    public User() {
    }

    public User(String name, String family, String phone, String role, String password, String tickets) {
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.role = role;
        this.password = password;
        this.tickets = tickets;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // family
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    // phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // tickets
    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String changeRoleQuery(String phone) {
        return "UPDATE `user` SET role='admin' WHERE `user`.`phone` = " + phone + ";";
    }

    public String getAllUsersQuery() {
        return "SELECT * FROM `user`;";
    }

    public String getUserQuery(String phone, String password) {
        return "SELECT * FROM `user` WHERE phone = " + phone + " AND password = " + password + ";";
    }

    public String insertUserQuery() {
        return "INSERT INTO user(name, family, phone, role, password, tickets) VALUES ('" + name + "','" + family
                + "','" + phone + "','" + role + "','" + password + "','" + tickets + "');";
    }
}
