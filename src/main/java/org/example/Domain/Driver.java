package org.example.Domain;

import java.sql.Blob;

public class Driver {
    private int id;
    private String name;
    private String nationality;
    private int driverNumber;
    private int wins;
    private int driversChampionship;
    private Blob driver_image;

    // Constructor
    public Driver(int id, String name, String nationality, int driverNumber, int wins, int driversChampionship, Blob driver_image) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.driverNumber = driverNumber;
        this.wins = wins;
        this.driversChampionship = driversChampionship;
        this.driver_image = driver_image;
    }

    public Driver() {
        this(0," "," ",0,0,0,null);
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(int driverNumber) {
        this.driverNumber = driverNumber;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDriversChampionship() {
        return driversChampionship;
    }

    public void setDriversChampionship(int driversChampionship) {
        this.driversChampionship = driversChampionship;
    }

    public Blob getdriver_image() {
        return driver_image;
    }

    public void setdriver_image(Blob driver_image) {
        this.driver_image = driver_image;
    }
}
