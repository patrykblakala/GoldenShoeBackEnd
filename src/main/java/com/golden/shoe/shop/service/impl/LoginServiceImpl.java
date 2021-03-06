package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dto.LoginDto;
import com.golden.shoe.shop.domain.dto.LoginResponseDto;
import com.golden.shoe.shop.security.SecurityUtils;
import com.golden.shoe.shop.service.LoginService;
import com.golden.shoe.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static com.golden.shoe.shop.security.SecurityConstants.COMMA;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public LoginResponseDto login(LoginDto loginDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
        var authentication = authenticationManager.authenticate(authenticationToken);

        if (authentication == null) {
            throw new AuthenticationServiceException("login failed");
        }
        var email = authentication.getName();
        var token = SecurityUtils.generateToken(email, authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(COMMA)));

        var user = userService.getByEmail(email);
        user.setLastLoggedDate(LocalDateTime.now());
        userService.save(user);

        return new LoginResponseDto(token);
    }
}
