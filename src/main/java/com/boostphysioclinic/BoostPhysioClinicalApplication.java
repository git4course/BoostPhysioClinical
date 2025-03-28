package com.boostphysioclinic;

//package com.boostphysioclinic;
//
//import com.boostphysioclinic.model.*;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Scanner;
//
//public class BoostPhysioClinicalApplication {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BoostPhysioClinic clinic = new BoostPhysioClinic();
//        // Adding initial physiotherapists
//        Physiotherapist physio1 = new Physiotherapist("Dr. Sarah Johnson", "123 Healing St", "555-1234");
//        physio1.addAreaOfExpertise("Physiotherapy");
//        physio1.addAreaOfExpertise("Rehabilitation");
//
//        Physiotherapist physio2 = new Physiotherapist("Dr. Michael Lee", "456 Recovery Rd", "555-5678");
//        physio2.addAreaOfExpertise("Osteopathy");
//        physio2.addAreaOfExpertise("Massage");
//
//        clinic.addPhysiotherapist(physio1);
//        clinic.addPhysiotherapist(physio2);
//
//        // Adding initial treatments
//        physio1.addTreatment(new Treatment("Neural Mobilisation", "Physiotherapy", LocalDateTime.of(2025, 5, 1, 10, 0), physio1));
//        physio1.addTreatment(new Treatment("Acupuncture", "Rehabilitation", LocalDateTime.of(2025, 5, 2, 14, 0), physio1));
//        physio2.addTreatment(new Treatment("Massage Therapy", "Massage", LocalDateTime.of(2025, 5, 3, 11, 0), physio2));
//
//        while (true) {
//            System.out.println("\nChoose an option:");
//            System.out.println("1. Add Patient");
//            System.out.println("2. Remove Patient");
//            System.out.println("3. Look up and book appointment by expertise");
//            System.out.println("4. Look up and book appointment by physiotherapist name");
//            System.out.println("5. Exit");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter patient name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter address: ");
//                    String address = scanner.nextLine();
//                    System.out.print("Enter phone number: ");
//                    String phone = scanner.nextLine();
//                    Patient patient = new Patient(name, address, phone);
//                    clinic.addPatient(patient);
//                    System.out.println("Patient added successfully.");
//                    break;
//
//                case 2:
//                    System.out.print("Enter patient name to remove: ");
//                    String removeName = scanner.nextLine();
//                    Patient patientToRemove = clinic.findPatientByName(removeName);
//                    if (patientToRemove != null) {
//                        clinic.removePatient(patientToRemove);
//                        System.out.println("Patient removed successfully.");
//                    } else {
//                        System.out.println("Patient not found.");
//                    }
//                    break;
//
//                case 3:
//                    System.out.print("Enter area of expertise: ");
//                    String expertise = scanner.nextLine();
//                    List<Treatment> treatments = clinic.findTreatmentsByExpertise(expertise);
//                    if (treatments.isEmpty()) {
//                        System.out.println("No treatments found for this expertise.");
//                        break;
//                    }
//                    displayTreatments(treatments);
//                    bookAppointment(scanner, clinic, treatments);
//                    break;
//
//                case 4:
//                    System.out.print("Enter physiotherapist name: ");
//                    String physioName = scanner.nextLine();
//                    List<Treatment> physioTreatments = clinic.findTreatmentsByPhysiotherapistName(physioName);
//                    if (physioTreatments.isEmpty()) {
//                        System.out.println("No treatments found for this physiotherapist.");
//                        break;
//                    }
//                    displayTreatments(physioTreatments);
//                    bookAppointment(scanner, clinic, physioTreatments);
//                    break;
//
//                case 5:
//                    System.out.println("Exiting application.");
//                    scanner.close();
//                    return;
//
//                default:
//                    System.out.println("Invalid choice, please try again.");
//            }
//        }
//    }
//
//    private static void displayTreatments(List<Treatment> treatments) {
//        System.out.println("Available Treatments:");
//        for (int i = 0; i < treatments.size(); i++) {
//            System.out.println((i + 1) + ". " + treatments.get(i).getName() + " - " + treatments.get(i).getAppointmentTime());
//        }
//    }
//
//    private static void bookAppointment(Scanner scanner, BoostPhysioClinic clinic, List<Treatment> treatments) {
//        System.out.print("Enter patient name: ");
//        String patientName = scanner.nextLine();
//        Patient patient = clinic.findPatientByName(patientName);
//        if (patient == null) {
//            System.out.println("Patient not found.");
//            return;
//        }
//
//        System.out.print("Enter the number of the treatment you want to book: ");
//        int treatmentIndex = scanner.nextInt() - 1;
//        scanner.nextLine();
//        if (treatmentIndex < 0 || treatmentIndex >= treatments.size()) {
//            System.out.println("Invalid selection.");
//            return;
//        }
//        Appointment appointment = clinic.bookAppointment(patient, treatments.get(treatmentIndex));
//        System.out.println("Appointment booked successfully for " + patient.getFullName());
//    }
//}

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
