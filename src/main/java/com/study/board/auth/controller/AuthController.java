package com.study.board.auth.controller;

import com.study.board.auth.dto.AuthDto;
import com.study.board.auth.service.AuthService;
import com.study.board.entity.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/userInput")
    public void userInput(@RequestBody AuthDto authDto){
        authService.insertUser(authDto);
    }

    @GetMapping("/getUser")
    public List<Auth> getUser(){
        return authService.findAllUser();
    }
}
