package com.ra.dto;

import javax.servlet.http.Part;
import java.time.LocalDate;
import java.util.Date;

public class EmployeeRequest {
    private Integer id;
    private String name,address;
    private Date birthDay;
    private Boolean sex;
    private Part image;

    public EmployeeRequest() {
    }

    public EmployeeRequest(Integer id, String name, String address, Date birthDay, Boolean sex, Part image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.sex = sex;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }
}
