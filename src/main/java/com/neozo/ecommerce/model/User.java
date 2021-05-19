package com.neozo.ecommerce.model;

import lombok.Data;

public class User {
    long id;

    String firstName;

    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
