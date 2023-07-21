package org.javasparkips.wildlifetracker.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.javasparkips.wildlifetracker.WildlifeTrackerApp;
import org.javasparkips.wildlifetracker.models.Sighting;

import spark.Request;
import spark.Response;

public class SightingHandler {
    public static Object getAllSightings(Request req, Response res) {
        try (Connection conn = WildlifeTrackerApp.getDBConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sightings")) {

            List<Sighting> sightings = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int animalId = rs.getInt("animal_id");
                String location = rs.getString("location");
                String rangerName = rs.getString("ranger_name");
                Sighting sighting = new Sighting(id, animalId, location, rangerName);
                sightings.add(sighting);
            }

            return sightings;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
