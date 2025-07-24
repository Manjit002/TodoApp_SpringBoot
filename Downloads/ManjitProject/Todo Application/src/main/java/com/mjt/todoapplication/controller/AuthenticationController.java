package com.mjt.todoapplication.controller;


import com.mjt.todoapplication.dtos.JwtRequest;
import com.mjt.todoapplication.dtos.JwtResponse;

import com.mjt.todoapplication.dtos.UserDto;
import com.mjt.todoapplication.repositories.UserRepo;
import com.mjt.todoapplication.security.JwtHelper;
import com.mjt.todoapplication.security.JwtUserDetailsService;
import com.mjt.todoapplication.services.UserService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){

        this.doAuthentication(request.getEmail(),request.getPassword());

        UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());

        String token = jwtHelper.generateToken(user);

        JwtResponse jwtResponse = JwtResponse.builder().token(token).user(mapper.map(user, UserDto.class)).build();
        return ResponseEntity.ok(jwtResponse);
    }

    private void doAuthentication(String email, String password) {

        try {
            Authentication authentication= new UsernamePasswordAuthenticationToken(email, password);
            authenticationManager.authenticate(authentication);

        }catch (BadCredentialsException exception){
            throw new BadCredentialsException("Invalid e-mail and password !!");
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        if (userRepo.findByEmail(userDto.getEmail()).isPresent()) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
       }

         userService.signup(userDto);

        return ResponseEntity.ok("Signup Successful");
    }


}
