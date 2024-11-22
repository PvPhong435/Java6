/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author PC
 */

public class Student {
    private String email;
    private String fullname;
    private Double marks;
    private Boolean gender;
    private String country;

    public Student() {
    }

    public Student(String email, String fullname, Double marks, Boolean gender, String country) {
        this.email = email;
        this.fullname = fullname;
        this.marks = marks;
        this.gender = gender;
        this.country = country;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the marks
     */
    public Double getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(Double marks) {
        this.marks = marks;
    }

    /**
     * @return the gender
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    @JsonIgnore
    public Object[] getArray()
    {
        return new Object[]
        {
            getEmail(),
            getFullname(),
            getMarks(),
            getGender(),
            getCountry()
        };
    }
    
}
