package org.javasparkips.wildlifetracker.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.javasparkips.wildlifetracker.WildlifeTrackerApp;
import org.javasparkips.wildlifetracker.models.Animal;

import spark.Request;
import spark.Response;

public class AnimalHandler {
    public static Object getAllAnimals(Request req, Response res) {
        try (Connection conn = WildlifeTrackerApp.getDBConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM animals")) {

            List<Animal> animals = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Animal animal = new Animal(id, name);
                animals.add(animal);
            }

            return animals;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}