# BoostPhysioClinical
**BoostPhysioClinical Application******

**UML Class diagram. (10 marks)**

https://github.com/user-attachments/assets/3d6069cf-2acf-4394-9141-8d877396baeb


**System functions. (40 marks)**
Key System Functions

**1. Add Physiotherapist** 

**Purpose:** To add a new physiotherapist to the clinic.      
**Input:** Physiotherapist details (ID, name, address, phone, areas of expertise).    
**Output:** Confirmation of the addition.  
**Implementation:** This function will create a new Physiotherapist object and add it to the clinic's list of physiotherapists.




    public void addPhysiotherapist(String id, String name, String address, String phone, List<String> expertise) {
     Physiotherapist physiotherapist = new Physiotherapist(id, name, address, phone, expertise);
     physiotherapists.add(physiotherapist);
     System.out.println("Physiotherapist added: " + name);
    }



**2. Add Patient**

**Purpose:** To register a new patient in the clinic.  
**Input:** Patient details (ID, name, address, phone).  
**Output:** Confirmation of the addition.  
**Implementation:** This function will create a new Patient object and add it to the clinic's list of patients.



 
 

  
    public void addPatient(String id, String name, String address, String phone) {
     Patient patient = new Patient(id, name, address, phone);
     patients.add(patient);
     System.out.println("Patient added: " + name);
    }
   

**3. Add Treatment to Physiotherapist**

**Purpose:** To add a treatment option to a physiotherapist's offerings.  
**Input:** Physiotherapist ID, treatment name, duration.   
**Output:** Confirmation of the addition.  
**Implementation:** This function will find the specified physiotherapist and add a new Treatment object to their list of treatments.

 


    public void addTreatmentToPhysiotherapist(String physiotherapistId, String treatmentName, int duration) {
     Physiotherapist physiotherapist = findPhysiotherapistById(physiotherapistId);
     if(physiotherapist != null) {
         Treatment treatment = new Treatment(treatmentName, duration);
         physiotherapist.addTreatment(treatment);
         System.out.println("Treatment added: " + treatmentName + " to " + physiotherapist.getName());
     } else {
        System.out.println("Physiotherapist not found.");
     }
    }


**4. Book Appointment**

**Purpose:** To book an appointment for a patient with a physiotherapist.  
**Input:** Patient ID, physiotherapist ID, treatment name, date and time.  
**Output:** Confirmation of the booking.  
**Implementation:** This function will create a new Appointment object and associate it with the patient and physiotherapist.
 

 


    public void bookAppointment(String patientId, String physiotherapistId, String treatmentName, LocalDateTime dateTime) {
     Patient patient = findPatientById(patientId);
     Physiotherapist physiotherapist = findPhysiotherapistById(physiotherapistId);
     Treatment treatment = findTreatmentByName(physiotherapist, treatmentName);
     if (patient != null && physiotherapist != null && treatment != null) {
         Appointment appointment = new Appointment(dateTime, physiotherapist, treatment, patient);
         appointments.add(appointment);
         patient.bookAppointment(appointment);
         System.out.println("Appointment booked for " + patient.getName() + " with " + physiotherapist.getName());
     } else {
        System.out.println("Booking failed: Invalid patient, physiotherapist, or treatment.");
     }
    }


**5. Cancel Appointment**

**Purpose:** To cancel an existing appointment.  
**Input:** Patient ID, appointment ID.  
**Output:** Confirmation of the cancellation.  
**Implementation:** This function will find the specified appointment and change its status to "cancelled".
 
 

    public void cancelAppointment(String patientId, String appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    if (appointment != null && appointment.getPatient().getId().equals(patientId)) {
        appointment.changeStatus("cancelled");
        System.out.println("Appointment cancelled for " + appointment.getPatient().getName());
    } else {
        System.out.println("Cancellation failed: Appointment not found or does not belong to the patient.");
    }
    }
    


**6. Check In Patient**

**Purpose:** To mark a patient as checked in for their appointment.  
**Input:** Appointment ID.  
**Output:** Confirmation of the check-in.  
**Implementation:** This function will find the specified appointment and change its status to "attended".


 
 
    public void checkInPatient(String appointmentId) {
    Appointment appointment = findAppointmentById(appointmentId);
    if (appointment != null) {
        appointment.changeStatus("attended");
        System.out.println("Patient checked in for appointment with " + appointment.getPhysiotherapist().getName());
    } else {
        System.out.println("Check-in failed: Appointment not found.");
    }
    }


    
   

**7. Generate Report**

**Purpose:** To generate a report of all appointments, including their status.  
**Input:** None.  
**Output:** A formatted report of appointments.  
**Implementation:** This function will iterate through the list of appointments and print the details.
 
 


  
   
     public void generateReport() {
      System.out.println("Appointment Report:");
      for (Appointment appointment : appointments) {
         System.out.println("Physiotherapist: " + appointment.getPhysiotherapist().getName() +
                           ", Treatment: " + appointment.getTreatment().getName() +
                           ", Patient: " + appointment.getPatient().getName() +
                           ", Time: " + appointment.getDateTime() +
                           ", Status: " + appointment.getStatus());
     }
    }



**Summary of System Functions**
The above functions cover the core functionalities of the Boost Physio Clinic booking system. Each function is designed to handle specific tasks related to managing physiotherapists, patients, treatments, and appointments.

**Implementation Considerations**

**Error Handling:** Ensure that each function includes error handling to manage cases where inputs are invalid or when objects are not found.  
**Data Validation:** Validate inputs (e.g., check for valid dates and times) to prevent issues during execution.  
**User Interface:** Depending on your implementation, you may want to create a simple console-based or GUI interface to allow users to interact with these functions easily.

**Conclusion**
By implementing these system functions, you will fulfill a significant portion of the assignment requirements, demonstrating your ability to design and implement a substantial software artifact. If you have any specific questions about any of the functions or need further assistance, feel free to ask!
