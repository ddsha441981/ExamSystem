package com.codewithcup.springboot.model;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userRoleId;
//User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    @ManyToOne
    private Role role;

//    Default Constructor


    public UserRole() {
    }

//    Getter and Setter

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    ToString

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
