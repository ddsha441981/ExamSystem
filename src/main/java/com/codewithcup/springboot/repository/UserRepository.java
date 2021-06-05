package com.codewithcup.springboot.repository;

import com.codewithcup.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String userName);
    public long count();



}
