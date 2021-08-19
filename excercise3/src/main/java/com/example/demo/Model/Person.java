package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: Thien Trong
 * @Date: 19/8/2021
 * @Desc: This class is model hold person information
 * */
public class Person {

    @NotBlank(message = "Name is required")
    @Size(min = 1, message = "Name too short")
    String fullName;

    String gender;

    @NotBlank(message = "Mobile number is required")
    @Size(min = 9, max = 11, message = "Mobile number is from 9 to 11 numbers")
    @Pattern(regexp = "^[0-9]+$", message = "Only accept number")
    String mobileNumber;



    @NotBlank(message = "Address is required")
    @Size(min = 3, max = 200, message = "Address to short")
    String address;

    @Past(message = "Must choose date from past")
    @NotNull(message = "Please choose date")
    Date birthday;

    public Person() {

    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
