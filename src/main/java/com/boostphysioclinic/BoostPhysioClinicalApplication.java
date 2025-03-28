package com.boostphysioclinic;

import com.boostphysioclinic.model.*;

import java.time.LocalDateTime;

public class BoostPhysioClinicalApplication {
    public static void main(String[] args) {
        // Create clinic system
        BoostPhysioClinic clinic = new BoostPhysioClinic();

        // Create Physiotherapists
        Physiotherapist physio1 = new Physiotherapist("Dr. Sarah Johnson", "123 Healing St", "555-1234");
        physio1.addAreaOfExpertise("Physiotherapy");
        physio1.addAreaOfExpertise("Rehabilitation");

        Physiotherapist physio2 = new Physiotherapist("Dr. Michael Lee", "456 Recovery Rd", "555-5678");
        physio2.addAreaOfExpertise("Osteopathy");
        physio2.addAreaOfExpertise("Massage");

        Physiotherapist physio3 = new Physiotherapist("Dr. Emily Davis", "789 Wellness Blvd", "555-9012");
        physio3.addAreaOfExpertise("Chiropractic");
        physio3.addAreaOfExpertise("Sports Therapy");


        // Create Treatments for a 4-week timetable
        LocalDateTime startDate = LocalDateTime.of(2025, 5, 1, 9, 0); // Start date for the timetable
        for (int week = 0; week < 4; week++) {
            for (int day = 0; day < 5; day++) { // Assuming treatments are available Monday to Friday
                for (int hour = 9; hour <= 17; hour += 2) { // Treatments every 2 hours
                    LocalDateTime treatmentTime = startDate.plusDays(week * 7 + day).withHour(hour);
                    Treatment treatment = new Treatment("Neural Mobilisation", "Physiotherapy", treatmentTime, physio1);
                    physio1.addTreatment(treatment);
                    Treatment treatment2 = new Treatment("Acupuncture", "Rehabilitation", treatmentTime, physio2);
                    physio2.addTreatment(treatment2);
                    Treatment treatment3 = new Treatment("Massage Therapy", "Massage", treatmentTime, physio3);
                    physio3.addTreatment(treatment3);
                }
            }
        }


        // Add Physiotherapists to Clinic
        clinic.addPhysiotherapist(physio1);
        clinic.addPhysiotherapist(physio2);
        clinic.addPhysiotherapist(physio3);

        // Create Patients
        Patient patient1 = new Patient("John Doe", "789 Patient Lane", "555-9012");
        Patient patient2 = new Patient("Jane Smith", "234 Wellness Ave", "555-3456");
        Patient patient3 = new Patient("Alice Brown", "321 New Patient St", "555-6789");
        Patient patient4 = new Patient("Bob White", "654 Old Patient St", "555-4321");
        Patient patient5 = new Patient("Charlie Black", "987 Another St", "555-8765");

        // Add Patients to Clinic
        clinic.addPatient(patient1);
        clinic.addPatient(patient2);
        clinic.addPatient(patient3);
        clinic.addPatient(patient4);
        clinic.addPatient(patient5);


        // Book Appointments
        Appointment appointment1 = clinic.bookAppointment(patient1, physio1.getTreatments().get(0));
        Appointment appointment2 = clinic.bookAppointment(patient2, physio2.getTreatments().get(0));




        // Check-in one appointment
        clinic.checkInAppointment(appointment1);

        // Generate Report
        clinic.generateReport();

        // Remove a patient
        System.out.println("Removing patient: " + patient1.getFullName());
        clinic.removePatient(patient2);

        // Generate Report after removal
        System.out.println("Generating report after removing a patient:");
        clinic.generateReport();

        // Add a new patient
        Patient patient6 = new Patient("Alice Brown", "321 New Patient St", "555-6789");
        System.out.println("Adding new patient: " + patient3.getFullName());
        clinic.addPatient(patient3);

        // Book an appointment for the new patient
        Appointment appointment3 = clinic.bookAppointment(patient3, physio3.getTreatments().get(0));
        System.out.println("Booking appointment for new patient: " + patient3.getFullName());

        // Generate final report
        System.out.println("Final report:");
        clinic.generateReport();
    }
}
