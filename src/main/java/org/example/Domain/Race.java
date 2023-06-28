package org.example.Domain;

import java.sql.Date;

public class Race {
    private int idCircuit;
    private int idTeam;
    private Date eventDate;

    // Constructor
    public Race(int idCircuit, int idTeam, Date eventDate) {
        this.idCircuit = idCircuit;
        this.idTeam = idTeam;
        this.eventDate = eventDate;
    }

    // Getters and Setters
    public int getIdCircuit() {
        return idCircuit;
    }

    public void setIdCircuit(int idCircuit) {
        this.idCircuit = idCircuit;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
