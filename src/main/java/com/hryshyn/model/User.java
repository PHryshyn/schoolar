package com.hryshyn.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pahr on 13.08.2014.
 */
public class User {
    private String username;
    private String password;
    private boolean enabled;
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    //default constructor
    public User() {}

    //getters and setters
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}





