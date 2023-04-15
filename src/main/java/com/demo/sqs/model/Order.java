package com.demo.sqs.model;

import java.time.LocalDate;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private LocalDate orderDate;
    private String productCode;
    private String productName;
    private Double quantity;
    private String firstName;
    private String lastName;
    private Address orderAddress;
    private String email;
    private String mobileNumber;
    private String notes;
    private Physician physician;

    public void setOrderId(UUID uuid) {
        this.orderId = uuid;
    }

    public UUID getOrderId() {
        return this.orderId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setOrderAddress(Address orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Address getOrderAddress() {
        return this.orderAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Physician getPhysician() {
        return this.physician;
    }
}
