package com.example.TT.controller;

import com.example.TT.dto.UserDto;
import com.example.TT.mapper.UserMapper;
import com.example.TT.persistent.model.UserEntity;
import com.example.TT.persistent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserDto user) {
        UserEntity userEntity = userMapper.fromDtoToEntity(user);
        userEntity.setPassword(encoder.encode(user.password()));
        userRepository.save(userEntity);
        return ResponseEntity.ok().body("Success!");
    }

}
