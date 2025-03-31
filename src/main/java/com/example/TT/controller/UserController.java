package com.example.TT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class UserController {

    @GetMapping
    public String start() {
        return "Hello World!";
    }

    @GetMapping("/auth-success")
    public String users() {
        return "Sucessfully authed!";
    }

}
