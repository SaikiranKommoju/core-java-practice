package com.vsks.immutable;

public class Address {

    private String houseOrFlatNo;
    private String houseOrApartmentName;
    private String street;
    private String landmark;
    private String cityOrVillage;
    private String state;
    private Long pinCode;

    public Address() {
    }

    protected Address(Address address) {
        this.houseOrFlatNo = address.houseOrFlatNo;
        this.houseOrApartmentName = address.houseOrApartmentName;
        this.street = address.street;
        this.landmark = address.landmark;
        this.cityOrVillage = address.cityOrVillage;
        this.state = address.state;
        this.pinCode = address.pinCode;
    }

    public String getHouseOrFlatNo() {
        return houseOrFlatNo;
    }

    public Address setHouseOrFlatNo(String houseOrFlatNo) {
        Address address = new Address(this);
        address.houseOrFlatNo = houseOrFlatNo;
        return address;
    }

    public String getHouseOrApartmentName() {
        return houseOrApartmentName;
    }

    public Address setHouseOrApartmentName(String houseOrApartmentName) {
        Address address = new Address(this);
        address.houseOrApartmentName = houseOrApartmentName;
        return address;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        Address address = new Address(this);
        address.street = street;
        return address;
    }

    public String getLandmark() {
        return landmark;
    }

    public Address setLandmark(String landmark) {
        Address address = new Address(this);
        address.landmark = landmark;
        return address;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public Address setCityOrVillage(String cityOrVillage) {
        Address address = new Address(this);
        address.cityOrVillage = cityOrVillage;
        return address;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        Address address = new Address(this);
        address.street = state;
        return address;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public Address setPinCode(Long pinCode) {
        Address address = new Address(this);
        address.pinCode = pinCode;
        return address;
    }
}
