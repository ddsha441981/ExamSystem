package com.codewithcup.springboot.service;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;

import java.util.Set;


public interface UserService {

//    Creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
//    Get user by username
    public User getUser(String username);
//    Delete User By Id
    public void deleteUSer(Long userId);
//    Update updateUser
}
