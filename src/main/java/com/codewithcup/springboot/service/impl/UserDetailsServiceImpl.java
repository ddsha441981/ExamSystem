package com.codewithcup.springboot.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Data fetch from database
        User user = this.userRepository.findByUsername(username);
//        System.out.println("User is " + user);
        if(user == null){
//            System.out.println("User not found!!!");
            throw new UsernameNotFoundException("User with this username not found in database!!!");
        }
        return user;
    }
}
