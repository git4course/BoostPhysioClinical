package com.boostphysioclinic.model;

import java.util.ArrayList;
import java.util.List;

public class Physiotherapist extends Person {
    private List<String> areasOfExpertise;
    private List<Treatment> treatments;

    public Physiotherapist(String fullName, String address, String telephoneNumber) {
        super(fullName, address, telephoneNumber);
        this.areasOfExpertise = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public void addAreaOfExpertise(String expertise) {
        areasOfExpertise.add(expertise);
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

    public List<String> getAreasOfExpertise() {
        return areasOfExpertise;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }
}
