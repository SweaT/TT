package com.example.TT.controller;

import com.example.TT.persistent.model.UserEntity;
import com.example.TT.persistent.model.UserRole;
import com.example.TT.persistent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheats")
@RequiredArgsConstructor
public class CHEATS {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/create-admin")
    public ResponseEntity<String> createUser() {
        UserEntity user = new UserEntity();
        user.setLogin("admin");
        user.setPassword(encoder.encode("admin"));
        user.setName("admin");
        user.setRole(UserRole.ADMIN);
        userRepository.save(user);
        return ResponseEntity.ok().body("Success!");
    }

}
