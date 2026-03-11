package com.blog_app_apis.services;

import com.blog_app_apis.payloads.UserDto;

import java.util.List;

public interface userService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Long userId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();
    void deleteUser(Long userId);
}
