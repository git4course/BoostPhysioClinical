package com.boostphysioclinic.model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Appointment> appointments;

    public Patient(String fullName, String address, String telephoneNumber) {
        super(fullName, address, telephoneNumber);
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return patient.getId().equals(patient.getId()); // Assuming id is unique
    }

    @Override
    public int hashCode() {
        return getId().hashCode(); // Assuming id is unique
    }
}
