package com.antigaspillage.demo.form;

import com.antigaspillage.demo.data.User;

import java.sql.Timestamp;

public class AppTraderForm {
    private Long id;
    private User user;
    public String companyName, location, description;
    public Timestamp Adddata;

    public AppTraderForm(Long id, User user, String companyName, String location, String description, Timestamp adddata) {
        this.id = id;
        this.user = user;
        this.companyName = companyName;
        this.location = location;
        this.description = description;
        Adddata = adddata;
    }

    public AppTraderForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getAdddata() {
        return Adddata;
    }

    public void setAdddata(Timestamp adddata) {
        Adddata = adddata;
    }

    @Override
    public String toString() {
        return "AppTraderForm{" +
                "id=" + id +
                ", user=" + user +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", Adddata=" + Adddata +
                '}';
    }
}
