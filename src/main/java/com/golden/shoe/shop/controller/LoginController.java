package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.LoginDto;
import com.golden.shoe.shop.domain.dto.LoginResponseDto;
import com.golden.shoe.shop.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/login", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }
}
