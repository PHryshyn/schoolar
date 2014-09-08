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

    @Column(name = "role_id")
    private Integer roleId;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "enabled")
    private int enabled;

    @OneToMany
    @JoinColumn(name = "role_id")
    private Set<Role> role = new HashSet<Role>(0);

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserData userData;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Shedule> shedules = new HashSet<Shedule>(0);

    public User() {
    }

    public User(Integer roleId, String username, String password, int enabled, Set<Role> role, UserData userData, Set<Shedule> shedules) {
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.userData = userData;
        this.shedules = shedules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Set<Shedule> getShedules() {
        return shedules;
    }

    public void setShedules(Set<Shedule> shedules) {
        this.shedules = shedules;
    }
}
