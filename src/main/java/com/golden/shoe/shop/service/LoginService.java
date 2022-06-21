package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dto.LoginDto;
import com.golden.shoe.shop.domain.dto.LoginResponseDto;

public interface LoginService {

    LoginResponseDto login(LoginDto loginDto);
}
