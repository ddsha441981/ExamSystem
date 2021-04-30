package com.codewithcup.springboot;

import com.codewithcup.springboot.model.Role;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamSystemApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {

        SpringApplication.run(ExamSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting point");
//        User user = new User();
////        user.setId(1L);
//        user.setFirstName("Deendayal");
//        user.setLastName("Kumawat");
//        user.setUsername("ddsha441981");
//        user.setEmail("kkumawat1111@gmail.com");
//        user.setPassword("Hello");
//        user.setPhone("9602063435");
//        user.setProfile("1.png");
//
//        Role role1 = new Role();
//        role1.setRoleId(44L);
//        role1.setRoleName("ADMIN");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//
//        userRole.setRole(role1);
//        userRole.setUser(user);
//
//        userRoleSet.add(userRole);
//
//        User user1 = this.userService.createUser(user,userRoleSet);
//        user1.toString();
//        System.out.println(user1.getUsername());



    }
}
