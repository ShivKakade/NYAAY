package com.example.nyaay;

public class model {
    String pending_fees,case_number;
    String name,case_status,hearing_date,purl,case_type;

    model(){

    }

    public model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public model(String pending_fees, String case_number, String case_status, String hearing_date, String purl, String case_type) {
        this.pending_fees = pending_fees;
        this.case_number = case_number;
        this.case_status = case_status;
        this.hearing_date = hearing_date;
        this.purl = purl;
        this.case_type = case_type;
    }

    public String getPending_fees() {
         return pending_fees;
    }

    public void setPending_fees(String pending_fees) {
        this.pending_fees = pending_fees;
    }

    public String getCase_number() {

        return case_number;
    }

    public void setCase_number(String case_number) {
        this.case_number = case_number;
    }

    public String getCase_status() {
        return case_status;
    }

    public void setCase_status(String case_status) {
        this.case_status = case_status;
    }

    public String getHearing_date() {
        return hearing_date;
    }

    public void setHearing_date(String hearing_date) {
        this.hearing_date = hearing_date;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getCase_type() {
        return case_type;
    }

    public void setCase_type(String case_type) {
        this.case_type = case_type;
    }
}
