package com.boostphysioclinic.model;

import java.util.UUID;

// Base Person class for both Physiotherapists and Patients
public abstract class Person {
    private String id;
    private String fullName;
    private String address;
    private String telephoneNumber;

    public Person(String fullName, String address, String telephoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getTelephoneNumber() { return telephoneNumber; }


}
