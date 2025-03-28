package com.boostphysioclinic.model;

import java.time.LocalDateTime;

public class Treatment {
    private String name;
    private String expertise;
    private LocalDateTime appointmentTime;
    private Physiotherapist physiotherapist;

    public Treatment(String name, String expertise, LocalDateTime appointmentTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.expertise = expertise;
        this.appointmentTime = appointmentTime;
        this.physiotherapist = physiotherapist;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }
}
