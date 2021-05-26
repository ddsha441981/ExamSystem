package com.codewithcup.springboot.controller;
import com.codewithcup.springboot.model.Role;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

//    Create User
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

//    Get User
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){

        return this.userService.getUser(username);
    }

//    Delete User By Id
    @DeleteMapping("/{userId}")
    public void deleteUSer(@PathVariable("userId") Long userId){

        this.userService.deleteUSer(userId);
    }

//    Update User

}
