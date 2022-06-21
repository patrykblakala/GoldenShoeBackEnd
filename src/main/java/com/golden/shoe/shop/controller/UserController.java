package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.UserDto;
import com.golden.shoe.shop.mapper.UserMapper;
import com.golden.shoe.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.userDaoToUserDto(userService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserDto> pageUser(@RequestParam int page, @RequestParam int size) {
        return userService.page(PageRequest.of(page, size))
                .map(userMapper::userDaoToUserDto);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto, @PathVariable Long id) {
        return userMapper.userDaoToUserDto(userService.update(userMapper.userDtoToUser(userDto), id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody @Valid UserDto userDto) {
        return userMapper.userDaoToUserDto(userService.register(userMapper.userDtoToUser(userDto)));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
