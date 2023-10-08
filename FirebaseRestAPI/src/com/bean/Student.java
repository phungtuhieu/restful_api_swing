/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {

    private String fullname;
    private String email;
    private Boolean gender;
    private Double marks;
    private String country;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{
            getEmail(),
            getFullname(),
            getMarks(),
            getGender(),
            getCountry()
        };
    }
}
