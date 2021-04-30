package com.codewithcup.springboot.service;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;

import java.util.Set;


public interface UserService {

//    Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
