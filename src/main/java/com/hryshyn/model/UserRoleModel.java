package com.hryshyn.model;


public class UserRoleModel {
    private Integer userRoleId;
    private String role;

    //default constructor
    public UserRoleModel(){}

    //getter ans setter UserRoleId
    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    //getter ans setter Role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
