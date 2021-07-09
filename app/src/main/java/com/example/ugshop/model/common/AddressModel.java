package com.example.ugshop.model.common;

public class AddressModel {
    private String state;
    private String email;
    private int pin;
    private int addressId;
    private String city;
    private String houseNo;
    private String area;
    private String landmark;
    private String typeOfAddress;
    private boolean defaultAddress;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getTypeOfAddress() {
        return typeOfAddress;
    }

    public void setTypeOfAddress(String typeOfAddress) {
        this.typeOfAddress = typeOfAddress;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", pin=" + pin +
                ", addressId=" + addressId +
                ", city='" + city + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", area='" + area + '\'' +
                ", landmark='" + landmark + '\'' +
                ", typeOfAddress='" + typeOfAddress + '\'' +
                ", defaultAddress=" + defaultAddress +
                '}';
    }
}
