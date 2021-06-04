package com.codewithcup.springboot.service.impl;
import com.codewithcup.springboot.helper.UserFoundException;
import com.codewithcup.springboot.helper.UserNotFoundException;
import com.codewithcup.springboot.model.User;
import com.codewithcup.springboot.model.UserRole;
import com.codewithcup.springboot.repository.RoleRepository;
import com.codewithcup.springboot.repository.UserRepository;
import com.codewithcup.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

//    Repository
    @Autowired(required = true)
    private UserRepository userRepository;
    @Autowired(required = true)
    private RoleRepository roleRepository;

    // Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User is Already there!!!!");
            throw new UserFoundException();
        }
        else{
            //Create User Here
            // Save All User
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUsersRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

    //Getting User by Username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsersList() {

        return this.userRepository.findAll();

    }

    @Override
    public long count() {

        return this.userRepository.count();
    }

    //Deleting User using Id
    @Override
    public void deleteUSer(Long userId) {
        this.userRepository.deleteById(userId);
    }

    //Updating User using Id

}
