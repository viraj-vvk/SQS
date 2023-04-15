package com.demo.sqs.model;

public class Physician {
    private String physicianId;
    private String firstName;
    private String lastName;
    private Address physicianAddress;

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getPhysicianId() {
        return this.physicianId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirsyName() {
        return this.firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPhysicianAddress(Address physicianAddress) {
        this.physicianAddress = physicianAddress;
    }

    public Address getPhysicianAddress() {
        return this.physicianAddress;
    }
}
