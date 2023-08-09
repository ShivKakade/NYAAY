package com.example.nyaay;

public class dataholder {
    String Enroll_no, State, address, city, email, experience, mob_no, pimage, username;

    public String getEnroll_no() {
        return Enroll_no;
    }

    public void setEnroll_no(String enroll_no) {
        Enroll_no = enroll_no;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public dataholder(String enroll_no, String state, String address, String city, String email, String experience, String mob_no, String pimage, String username) {
        Enroll_no = enroll_no;
        State = state;
        this.address = address;
        this.city = city;
        this.email = email;
        this.experience = experience;
        this.mob_no = mob_no;
        this.pimage = pimage;
        this.username = username;
    }
}