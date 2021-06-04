package com.codewithcup.springboot.controller;
import com.codewithcup.springboot.helper.UserFoundException;
import com.codewithcup.springboot.helper.UserNotFoundException;
import com.codewithcup.springboot.model.Role;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    Create User
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");
        // encode password by using BecryptPassword encoder
       user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

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

//    Getting all user from database
    @PostMapping("/gettingAllUserList")
    public List<User> allUserFromDB(){
//        return this.userService.getAllUsersList();
            List<User> userlist = userService.getAllUsersList();
            long count = userService.count();

        return userlist;
    }

//    Getting all row count from database
    @GetMapping("/usercount")
    public long userListCount(){
        long count = userService.count();

        return count;
    }


//    Update User

    //Handle Exception
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler (UserFoundException ex){
        return ResponseEntity.ok(ex.getMessage());
    }

}
