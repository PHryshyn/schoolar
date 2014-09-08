package com.schoolar.modules.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    @Column(name = "full_name_p1")
    private String fullNamePar1;

    @Column(name = "full_name_p2")
    private String fullNamePar2;

    @Column(name = "phone")
    private Integer phone;


    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    public UserData() {
    }

    public UserData(String firstName, String lastName, String email, String adress, String fullNamePar1, String fullNamePar2, Integer phone, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.fullNamePar1 = fullNamePar1;
        this.fullNamePar2 = fullNamePar2;
        this.phone = phone;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFullNamePar1() {
        return fullNamePar1;
    }

    public void setFullNamePar1(String fullNamePar1) {
        this.fullNamePar1 = fullNamePar1;
    }

    public String getFullNamePar2() {
        return fullNamePar2;
    }

    public void setFullNamePar2(String fullNamePar2) {
        this.fullNamePar2 = fullNamePar2;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}