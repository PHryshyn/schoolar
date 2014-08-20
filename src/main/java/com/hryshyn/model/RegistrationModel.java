package com.hryshyn.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Size;


public class RegistrationModel {

    @NotEmpty(message="Enter pupil's username")
    private String username;

    @NotEmpty(message="Enter pupil's first name")
    private String firstName;

    @NotEmpty(message="Enter pupil's last name")
    private String lastName;

    @NotEmpty(message="Enter pupil's classroom")
    private String classRoom;

    @NotEmpty(message="Email must not be empty")
    @Email(message="Please give correct email id")
    private String email;

    @Size(min=8,message="Password must be at least {min} characters long")
    private String password;

    @SafeHtml
    @NotEmpty(message="Re-enter the password")
    private String confirmPassword;

    //Information about parents
    //First parent
    @NotEmpty(message="Enter parent's first name")
    private String firstNamePar1;

    @NotEmpty(message="Enter parent's last name")
    private String lastNamePar1;

    @NotEmpty(message="Enter parent's phone")
    private Integer phonePar1;


    //Second parent
    private String firstNamePar2;
    private String lastNamePar2;
    private Integer phonePar2;

    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


  //getters and setters first parent
    public String getFirstNamePar1() {
        return firstNamePar1;
    }

    public void setFirstNamePar1(String firstNamePar1) {
        this.firstNamePar1 = firstNamePar1;
    }

    public String getLastNamePar1() {
        return lastNamePar1;
    }

    public void setLastNamePar1(String lastNamePar1) {
        this.lastNamePar1 = lastNamePar1;
    }

    public Integer getPhonePar1() {
        return phonePar1;
    }

    public void setPhonePar1(Integer phonePar1) {
        this.phonePar1 = phonePar1;
    }

    public String getFirstNamePar2() {
        return firstNamePar2;
    }


   //getters and setters second parent
    public void setFirstNamePar2(String firstNamePar2) {
        this.firstNamePar2 = firstNamePar2;
    }

    public String getLastNamePar2() {
        return lastNamePar2;
    }

    public void setLastNamePar2(String lastNamePar2) {
        this.lastNamePar2 = lastNamePar2;
    }

    public Integer getPhonePar2() {
        return phonePar2;
    }

    public void setPhonePar2(Integer phonePar2) {
        this.phonePar2 = phonePar2;
    }
}
