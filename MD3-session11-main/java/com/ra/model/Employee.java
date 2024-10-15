package com.ra.model;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Employee {
    private Integer id;
    private String name,image,address;
    private Date birthDay;
    private Boolean sex;

    public Employee() {
    }

    public Employee(Integer id, String name, String image, String address, Date birthDay, Boolean sex) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.birthDay = birthDay;
        this.sex = sex;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    public String formatDate(){
        return new SimpleDateFormat("dd/MM/yyyy").format(birthDay);
    }
}
