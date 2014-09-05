package com.schoolar.modules.model;

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

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "enabled")
    private int enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Role> role = new HashSet<Role>(0);

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserData userData;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Rating> ratingSet = new HashSet<Rating>(0);

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Discipline> disciplines = new HashSet<Discipline>(0);

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Notes> notesSet = new HashSet<Notes>(0);


    public User() {
    }

    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, int enabled, Set<Role> role) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public User(String username, String password, int enabled, Set<Role> role, UserData userData, Set<Rating> ratingSet, Set<Discipline> disciplines, Set<Notes> notesSet) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.userData = userData;
        this.ratingSet = ratingSet;
        this.disciplines = disciplines;
        this.notesSet = notesSet;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Set<Notes> getNotesSet() {
        return notesSet;
    }

    public void setNotesSet(Set<Notes> notesSet) {
        this.notesSet = notesSet;
    }
}
