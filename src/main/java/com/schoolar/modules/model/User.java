package com.schoolar.modules.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
    private Set<Discipline> disciplines;



    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
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

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
