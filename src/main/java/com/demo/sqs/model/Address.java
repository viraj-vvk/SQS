package com.demo.sqs.model;

public class Address {
    private String address;
    private String city;
    private String postcode;
    private String state;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setPostCode(String postCode) {
        this.postcode = postCode;
    }

    public String getPostCode() {
        return this.postcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
