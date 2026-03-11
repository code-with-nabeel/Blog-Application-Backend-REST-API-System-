package com.blog_app_apis.mapper;

import com.blog_app_apis.entites.User;
import com.blog_app_apis.payloads.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}