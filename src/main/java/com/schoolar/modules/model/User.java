package com.schoolar.modules.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;


    @Column(name = "enabled")
    private int enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


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

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Shedule shedule;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String username, String password, int enabled, String firstName, String lastName, String email, String adress, String fullNamePar1, String fullNamePar2, Integer phone, Shedule shedule, Role role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.fullNamePar1 = fullNamePar1;
        this.fullNamePar2 = fullNamePar2;
        this.phone = phone;
        this.shedule = shedule;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public Shedule getShedule() {
        return shedule;
    }

    public void setShedule(Shedule shedule) {
        this.shedule = shedule;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
