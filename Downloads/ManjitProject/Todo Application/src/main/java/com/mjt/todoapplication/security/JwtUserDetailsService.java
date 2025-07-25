package com.mjt.todoapplication.security;

import com.mjt.todoapplication.entities.UserEntity;
import com.mjt.todoapplication.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("email not found"));

        return new User(user.getEmail(),user.getPassword(),new ArrayList<>());

    }
}
