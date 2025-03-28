package com.boostphysioclinic.model;

import java.util.ArrayList;
import java.util.List;

public class BoostPhysioClinic {
    private List<Physiotherapist> physiotherapists;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public BoostPhysioClinic() {
        physiotherapists = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Add physiotherapist
    public void addPhysiotherapist(Physiotherapist physiotherapist) {
        physiotherapists.add(physiotherapist);
    }

    // Add patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Find treatments by expertise
    public List<Treatment> findTreatmentsByExpertise(String expertise) {
        List<Treatment> availableTreatments = new ArrayList<>();
        for (Physiotherapist physio : physiotherapists) {
            for (Treatment treatment : physio.getTreatments()) {
                if (treatment.getExpertise().equalsIgnoreCase(expertise)) {
                    availableTreatments.add(treatment);
                }
            }
        }
        return availableTreatments;
    }
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Find treatments by physiotherapist name
    public List<Treatment> findTreatmentsByPhysiotherapistName(String name) {
        List<Treatment> availableTreatments = new ArrayList<>();
        for (Physiotherapist physio : physiotherapists) {
            if (physio.getFullName().equalsIgnoreCase(name)) {
                availableTreatments.addAll(physio.getTreatments());
            }
        }
        return availableTreatments;
    }

    // Book appointment
    public Appointment bookAppointment(Patient patient, Treatment treatment) {
        Appointment appointment = new Appointment(treatment, patient);
        appointments.add(appointment);
        patient.addAppointment(appointment);
        return appointment;
    }

    // Cancel appointment
    public void cancelAppointment(Appointment appointment) {
        appointment.changeStatus(AppointmentStatus.CANCELLED);
    }

    // Check-in appointment
    public void checkInAppointment(Appointment appointment) {
        appointment.changeStatus(AppointmentStatus.ATTENDED);
    }

    public Patient findPatientByName(String name) {
        for (Patient patient : patients) { // Assuming 'patients' is a list storing all patients
            if (patient.getFullName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    // Generate report
    public void generateReport() {
        System.out.println("Boost Physio Clinic - Treatment Appointments Report");
        System.out.println("------------------------------------------------");

        // Print appointments by physiotherapist
        for (Physiotherapist physio : physiotherapists) {
            System.out.println("\nPhysiotherapist: " + physio.getFullName());
            for (Treatment treatment : physio.getTreatments()) {
                Appointment matchingAppointment = appointments.stream()
                        .filter(a -> a.getTreatment() == treatment)
                        .findFirst()
                        .orElse(null);

                if (matchingAppointment != null) {
                    System.out.printf("Treatment: %s, Patient: %s, Time: %s, Status: %s%n",
                            treatment.getName(),
                            matchingAppointment.getPatient().getFullName(),
                            treatment.getAppointmentTime(),
                            matchingAppointment.getStatus());
                }
            }
        }

        // Rank physiotherapists by attended appointments
        System.out.println("\nPhysiotherapists Ranking (by attended appointments):");
        physiotherapists.stream()
                .sorted((p1, p2) -> {
                    long p1AttendedCount = appointments.stream()
                            .filter(a -> a.getTreatment().getPhysiotherapist() == p1 &&
                                    a.getStatus() == AppointmentStatus.ATTENDED)
                            .count();
                    long p2AttendedCount = appointments.stream()
                            .filter(a -> a.getTreatment().getPhysiotherapist() == p2 &&
                                    a.getStatus() == AppointmentStatus.ATTENDED)
                            .count();
                    return Long.compare(p2AttendedCount, p1AttendedCount);
                })
                .forEach(p -> {
                    long attendedCount = appointments.stream()
                            .filter(a -> a.getTreatment().getPhysiotherapist() == p &&
                                    a.getStatus() == AppointmentStatus.ATTENDED)
                            .count();
                    System.out.println(p.getFullName() + ": " + attendedCount + " attended appointments");
                });
    }
}
