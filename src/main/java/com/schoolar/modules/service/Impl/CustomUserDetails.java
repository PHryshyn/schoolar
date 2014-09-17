package com.schoolar.modules.service.Impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private Integer id;

    public CustomUserDetails(com.schoolar.modules.model.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        id = user.getId();
    }

    public Integer getId() {
        return id;
    }
}
