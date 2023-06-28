package org.example.Domain;

import java.sql.Blob;

public class Circuit {
    private int id;
    private String name;
    private String location;
    private String information;
    private String fastestLapRecord;
    private String currentWinner;
    private Blob image;

    // Constructor
    public Circuit(int id, String name, String location, String information, String fastestLapRecord,
                   String currentWinner, Blob image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.information = information;
        this.fastestLapRecord = fastestLapRecord;
        this.currentWinner = currentWinner;
        this.image = image;
    }

    public Circuit() {
        this(0," "," "," "," "," ",null);
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getFastestLapRecord() {
        return fastestLapRecord;
    }

    public void setFastestLapRecord(String fastestLapRecord) {
        this.fastestLapRecord = fastestLapRecord;
    }

    public String getCurrentWinner() {
        return currentWinner;
    }

    public void setCurrentWinner(String currentWinner) {
        this.currentWinner = currentWinner;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }


}