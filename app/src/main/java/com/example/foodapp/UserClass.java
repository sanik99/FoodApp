package com.example.foodapp;

public class UserClass {

    String fullname, email2, phoneNo, address, pass2;

    public UserClass() {

    }


    public UserClass(String fullname, String email2, String phoneNo, String address, String pass2) {
        this.fullname = fullname;
        this.email2 = email2;
        this.phoneNo = phoneNo;
        this.address = address;
        this.pass2 = pass2;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPhoneNo() { return phoneNo; }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}
