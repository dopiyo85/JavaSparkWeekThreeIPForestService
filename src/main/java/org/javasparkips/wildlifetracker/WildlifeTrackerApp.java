package org.javasparkips.wildlifetracker;

import org.javasparkips.wildlifetracker.handlers.AnimalHandler;
import org.javasparkips.wildlifetracker.handlers.SightingHandler;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class WildlifeTrackerApp {

    // Add a public static method to retrieve the database connection
    public static Connection getDBConnection() throws SQLException {
        return DatabaseConnector.getConnection();
    }

    public static void main(String[] args) {
        // Set up routes
        get("/animals", (req, res) -> AnimalHandler.getAllAnimals(req, res));
        get("/sightings", (req, res) -> SightingHandler.getAllSightings(req, res));

        // Route for the index page
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            try (Connection conn = getDBConnection()) {
                // Get all animals and sightings from the database
                model.put("animals", AnimalHandler.getAllAnimals(req, res));
                model.put("sightings", SightingHandler.getAllSightings(req, res));
            } catch (SQLException e) {
                e.printStackTrace();
                res.status(500); // Internal Server Error
            }
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
