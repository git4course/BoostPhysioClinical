package com.boostphysioclinic.model;

public class Appointment {
    private Treatment treatment;
    private Patient patient;
    private AppointmentStatus status;

    public Appointment(Treatment treatment, Patient patient) {
        this.treatment = treatment;
        this.patient = patient;
        this.status = AppointmentStatus.BOOKED;
    }

    public void changeStatus(AppointmentStatus newStatus) {
        this.status = newStatus;
    }

    // Getters
    public Treatment getTreatment() { return treatment; }
    public Patient getPatient() { return patient; }
    public AppointmentStatus getStatus() { return status; }
}
