package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.model.Role;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
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
        log.info("Adding  user  {}.",user);

        return this.userService.createUser(user, roles);
    }

    //    Update User
    @PutMapping("/update-user")
    @CachePut(value = "name",key = "#user.username")
    public User updatingUser(@RequestBody User user ){
        log.info("Updating User {} " + user);
        return this.userService.UpdateUser(user);
    }

//    Get User
    @GetMapping("/{username}")
    @Cacheable(value = "name",key = "#username")
    public User getUser(@PathVariable("username") String username){
        log.info("Getting user with name {}.",username);
        return this.userService.getUser(username);
    }

//    Delete User By Id
    @DeleteMapping("/{userId}")
    @CacheEvict(value = "name",allEntries = false,key="#userId")
    public void deleteUSer(@PathVariable("userId") Long userId){
        log.info("deleting  user with name {}.",userId);
        this.userService.deleteUSer(userId);
    }

//    Getting all user from database
    @GetMapping("/gettingAllUserList")
    public List<User> allUserFromDB(){
//        return this.userService.getAllUsersList();
            List<User> userlist = userService.getAllUsersList();
//            long count = userService.count();
        log.info("getting all user from db {}.",userlist);

        return userlist;
    }

//    Getting all row count from database
    @GetMapping("/usercount")
    public long userListCount(){
        long count = userService.count();

        return count;
    }

    //Handle Exception
//    @ExceptionHandler(UserFoundException.class)
//    public ResponseEntity<?> exceptionHandler (UserFoundException ex){
//        return ResponseEntity.ok(ex.getMessage());
//    }

}
