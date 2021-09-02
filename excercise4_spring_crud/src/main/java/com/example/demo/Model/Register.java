package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: Tran Thien Trong
 * @Date: 2/9/2021
 * @Desc: This class is model hold person information
 * */

@Entity
@Table(name="register")
public class Register {

    /*____________ ID ____________*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    /*____________ Full Name ____________*/
    @NotBlank
    @Size(min=2, max=30)
    @Column(name = "fullname", nullable = false)
    String fullName;

    /*____________ Gender ____________*/
    @Column(name = "gender", nullable = false)
    String gender;

    /*____________ Mobile Number ____________*/
    @NotBlank(message = "Mobile number is required")
    @Size(min = 9, max = 11, message = "Mobile number is from 9 to 11 numbers")
    @Pattern(regexp = "^[0-9]+$", message = "Only accept number")
    @Column(name = "mobile_number", nullable = false)
    String mobileNumber;

    /*____________ Address ____________*/
    @NotBlank(message = "Address is required")
    @Size(min = 3, max = 200, message = "Address to short")
    @Column(name = "address", nullable = false)
    String address;

    /*____________ Birthdate ____________*/
    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should be less than current date!!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birthdate", nullable = false)
    LocalDate birthdate;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Register() {

    }

    public Register(String fullName, String gender, String mobileNumber, String address, LocalDate birthdate) {
        this.fullName = fullName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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
