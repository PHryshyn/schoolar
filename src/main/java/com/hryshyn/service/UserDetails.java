package com.hryshyn.service;

/**
 * Created by pahr on 13.08.2014.
 */
public interface UserDetails {
    UserDetails loadUserByUsername(final String username);
}
