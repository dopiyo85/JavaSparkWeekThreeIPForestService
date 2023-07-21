package org.javasparkips.wildlifetracker.models;

public class Sighting {
    private int id;
    private int animalId;
    private String location;
    private String rangerName;

    public Sighting(int id, int animalId, String location, String rangerName) {
        this.id = id;
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
}
