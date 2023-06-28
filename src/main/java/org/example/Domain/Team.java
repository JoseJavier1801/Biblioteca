package org.example.Domain;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private Blob logo;
    private String headquarters;
    private String currentCar;
    private int constructorsChampionship;
    private List<Driver> drivers;
    private Driver reserveDriver;

    // Constructor
    public Team(int id, String name, Blob logo, String headquarters, String currentCar, int constructorsChampionship) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.headquarters = headquarters;
        this.currentCar = currentCar;
        this.constructorsChampionship = constructorsChampionship;
        this.drivers = new ArrayList<>();
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

    public Blob getLogo() {
        return logo;
    }

    public void setLogo(Blob logo) {
        this.logo = logo;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(String currentCar) {
        this.currentCar = currentCar;
    }

    public int getConstructorsChampionship() {
        return constructorsChampionship;
    }

    public void setConstructorsChampionship(int constructorsChampionship) {
        this.constructorsChampionship = constructorsChampionship;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Driver getReserveDriver() {
        return reserveDriver;
    }

    public void setReserveDriver(Driver reserveDriver) {
        this.reserveDriver = reserveDriver;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }
}
