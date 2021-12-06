package com.leipzigevent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseAccess implements IDatabase {

    @Override
    public List<Event> retrieveEvent(String eventKind) {
        List<Event> eventList = new ArrayList<>();

        try (Connection conn = connectDatabase()) {
            Statement stmt = conn.createStatement();

            String q = sqlQuery(eventKind);

            ResultSet rs = stmt.executeQuery(q);

            Event event;
            while (rs.next()) {
                if (Objects.equals(eventKind, "physicalevent")) {
                    String date = rs.getString("date");
                    String time = rs.getString("time");
                    int duration = rs.getInt("duration");
                    String type = rs.getString("type");
                    String location = rs.getString("location");
                    int capacity = rs.getInt("capacity");

                    event = new PhysicalEvent(date, time, duration, type, location, capacity);
                    eventList.add(event);
                }
                if (Objects.equals(eventKind, "virtualevent")) {
                    String date = rs.getString("date");
                    String time = rs.getString("time");
                    int duration = rs.getInt("duration");
                    String type = rs.getString("type");
                    String platform = rs.getString("platform");
                    String link = rs.getString("link");

                    event = new VirtualEvent(date, time, duration, type, platform, link);
                    eventList.add(event);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return eventList;
    }

    private String sqlQuery(String e) {
        String query = "";

        if (Objects.equals(e, "virtualevent")) {
            query = "SELECT e.date, e.time, e.duration, e.type, e.platform, e.link " +
                    "FROM " + e + " e";
        }

        if (Objects.equals(e, "physicalevent")) {
            query = "SELECT e.date, e.time, e.duration, e.type, e.location, e.capacity " +
                    "FROM " + e + " e";
        }

        return query;
    }

    @Override
    public Connection connectDatabase() {
        Connection con = null;
        String dbUrl = "jdbc:mysql://localhost:3306/leipzigevent";
        String username = "root";
        String password = "Ahmet@1996";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return con;
    }
}
