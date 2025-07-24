package com.mjt.todoapplication.services.Impl;

import com.mjt.todoapplication.dtos.UserDto;
import com.mjt.todoapplication.entities.UserEntity;
import com.mjt.todoapplication.repositories.UserRepo;
import com.mjt.todoapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto signup(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        UserEntity mapped = modelMapper.map(userDto, UserEntity.class);
        UserEntity saved = userRepo.save(mapped);

        return modelMapper.map(saved, UserDto.class);
    }
}
