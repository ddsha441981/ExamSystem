package com.codewithcup.springboot.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private String authority;

    //Default Constructor
    public Authority() {
    }

    //Parameterized Constructor
    public Authority(String authority) {
        this.authority = authority;
    }

    // Pre Define Method of GrantedAuthority Interface
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
