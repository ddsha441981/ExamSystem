package com.codewithcup.springboot;

import com.codewithcup.springboot.helper.UserFoundException;
import com.codewithcup.springboot.model.Role;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableCaching //For Redis Sever
@Slf4j
@SpringBootApplication
public class ExamSystemApplication implements CommandLineRunner {
    private static final Log logger = LogFactory.getLog(ExamSystemApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(ExamSystemApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        try {
            logger.info("<=================Application Start Point=================>");

            User user = new User();
            //        user.setId(1L);
            user.setFirstName("Deendayal");
            user.setLastName("Kumawat");
            user.setUsername("admin");
            user.setEmail("kkumawat1111@gmail.com");
            user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
            user.setPhone("9602063435");
            user.setProfile("1.png");

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();

            userRole.setRole(role1);
            userRole.setUser(user);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
//            user1.toString();
//            System.out.println(user1.getUsername());
        }catch(UserFoundException e){
            logger.info("<==================Exception occurred==================> " + e.getMessage());
            e.printStackTrace();
        }
    }

}
