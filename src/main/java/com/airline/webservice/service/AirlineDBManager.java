package com.airline.webservice.service;

import com.airline.webservice.model.Company;
import com.airline.webservice.model.Fly;
import com.airline.webservice.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Lazy
public class AirlineDBManager {

    String url = "jdbc:mysql://localhost:3306/airline";
    String user = "root";
    String password = "";

    @Autowired
    public AirlineDBManager(@Value("${database-username:root}") String user,
            @Value("${database-password:}") String password) {
        this.password = password;
        this.user = user;
        System.out.println("Database Username: " + user + "    Database Password: " + password);
    }

    // USER
    public String registerUser(User newUser) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            stmt.executeUpdate(newUser.insertUserQuery());
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public List<Map<String, String>> getUsers() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            User user = new User();
            ResultSet rst = stmt.executeQuery(user.getAllUsersQuery());
            List<Map<String, String>> ary = new ArrayList<Map<String, String>>();
            
            while (rst.next()) {
                HashMap<String, String> map = new HashMap<>();
                String name = rst.getString(1);
                String family = rst.getString(2);
                String phone = rst.getString(3);
                String role = rst.getString(4);
                String password = rst.getString(5);
                String tickets = rst.getString(6);

                map.put("name", name);
                map.put("family", family);
                map.put("phone", phone);
                map.put("role", role);
                map.put("password", password);
                map.put("tickets", tickets);

                ary.add(map);
            }

            return ary;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Map<String, String>>();
        }
    }

    public Map<String, String> getUser(String userPhone, String userPassword) {
        HashMap<String, String> map = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            User user = new User();
            ResultSet rst = stmt.executeQuery(user.getUserQuery(userPhone, userPassword));

            if (rst.next()) {
                String name = rst.getString(1);
                String family = rst.getString(2);
                String phone = rst.getString(3);
                String role = rst.getString(4);
                String password = rst.getString(5);
                String tickets = rst.getString(6);

                map.put("name", name);
                map.put("family", family);
                map.put("phone", phone);
                map.put("role", role);
                map.put("password", password);
                map.put("tickets", tickets);
            }

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("status", "error");
            return map;
        }
    }

    public String changeRole(String userPhone) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            User user = new User();
            stmt.executeUpdate(user.changeRoleQuery(userPhone));
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e);
            return "error";
        }
    }

    // COMPANY
    public List<Map<String, String>> getCompanies() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            Company company = new Company();
            ResultSet rst = stmt.executeQuery(company.getAllCompaniesQuery());
            List<Map<String, String>> ary = new ArrayList<Map<String, String>>();

            while (rst.next()) {
                HashMap<String, String> map = new HashMap<>();
                String name = rst.getString(1);
                String image = rst.getString(2);
                String flights = rst.getString(3);

                map.put("name", name);
                map.put("image", image);
                map.put("flights", flights);

                ary.add(map);
            }

            return ary;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Map<String, String>>();
        }
    }

    public Map<String, String> getCompany(String companyName) {
        HashMap<String, String> map = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            Company company = new Company();
            ResultSet rst = stmt.executeQuery(company.getCompanyQuery(companyName));

            if (rst.next()) {
                String name = rst.getString(1);
                String image = rst.getString(2);
                String flights = rst.getString(3);

                map.put("name", name);
                map.put("image", image);
                map.put("flights", flights);
            }

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("status", "error");
            return map;
        }
    }

    // FLY
    public List<Map<String, String>> getFlights() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            Fly fly = new Fly();
            ResultSet rst = stmt.executeQuery(fly.getAllFlightsQuery());
            List<Map<String, String>> ary = new ArrayList<Map<String, String>>();

            while (rst.next()) {
                HashMap<String, String> map = new HashMap<>();
                String company = rst.getString(1);
                String origin = rst.getString(2);
                String goal = rst.getString(3);
                String time = rst.getString(4);
                String date = rst.getString(5);
                String price = rst.getString(6);
                String reservedSeats = rst.getString(7);
                String travelers = rst.getString(8);
                String flyNumber = rst.getString(9);

                map.put("company", company);
                map.put("origin", origin);
                map.put("goal", goal);
                map.put("time", time);
                map.put("date", date);
                map.put("price", price);
                map.put("reservedSeats", reservedSeats);
                map.put("travelers", travelers);
                map.put("flyNumber", flyNumber);

                ary.add(map);
            }

            return ary;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Map<String, String>>();
        }
    }

    public Map<String, String> getFly(String currentFlyNumber) {
        HashMap<String, String> map = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();) {
            Fly fly = new Fly();
            ResultSet rst = stmt.executeQuery(fly.getFlyQuery(currentFlyNumber));

            if (rst.next()) {
                String company = rst.getString(1);
                String origin = rst.getString(2);
                String goal = rst.getString(3);
                String time = rst.getString(4);
                String date = rst.getString(5);
                String price = rst.getString(6);
                String reservedSeats = rst.getString(7);
                String travelers = rst.getString(8);
                String flyNumber = rst.getString(9);

                map.put("company", company);
                map.put("origin", origin);
                map.put("goal", goal);
                map.put("time", time);
                map.put("date", date);
                map.put("price", price);
                map.put("reservedSeats", reservedSeats);
                map.put("travelers", travelers);
                map.put("flyNumber", flyNumber);
            }

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            map.put("status", "error");
            return map;
        }
    }
}
