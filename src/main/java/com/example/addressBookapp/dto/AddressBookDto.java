package com.example.addressBookapp.dto;

public class AddressBookDto {

    private String name;
    private String city;
    private String state;
    private String phoneNumber;

    public void setName(String name) {
        this.name = name;
    }



    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }



    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getState() {
        return state;
    }
}
