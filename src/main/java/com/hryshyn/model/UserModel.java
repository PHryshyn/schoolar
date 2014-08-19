package com.hryshyn.model;

import java.util.HashSet;
import java.util.Set;


public class UserModel {
    private String username;
    private String password;
    private Set<UserRoleModel> userRole = new HashSet<UserRoleModel>(0);


    public UserModel() {}

    //getter and setter Username
    public String getUsername() {
            return username;
        }

    public void setUsername(String username) {
        this.username = username;
    }

    //getter and setter Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getter and setter UserRole
    public Set<UserRoleModel> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoleModel> userRole) {
        this.userRole = userRole;
    }

}





