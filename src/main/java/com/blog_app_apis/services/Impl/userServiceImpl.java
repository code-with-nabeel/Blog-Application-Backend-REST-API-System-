package com.blog_app_apis.services.Impl;

import com.blog_app_apis.entites.User;
import com.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog_app_apis.mapper.UserMapper;
import com.blog_app_apis.payloads.UserDto;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.userService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        //Dto --> Entity
        User user=userMapper.toEntity(userDto);
        // Save entity in database
        User saveUser=userRepository.save(user);
        // Entity → DTO
        return userMapper.toDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        // 1️⃣ existing user find karo
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userDto.getId()));


//        // 2️⃣ DTO se entity update karo
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());

//        // 3️⃣ save
//        User updatedUser = userRepository.save(user);
//
//        // 4️⃣ return DTO
//        return userMapper.toDto(updatedUser);


        // Short Version Dto to Entity
        User updatedUser = userMapper.toEntity(userDto);
        updatedUser.setId(user.getId());

        // 3️⃣ database me save karo
        User saveUser=userRepository.save(updatedUser);

        // 4️⃣ entity ko DTO me convert karo
        return userMapper.toDto(saveUser);

    }

    @Override
    public UserDto getUserById(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=userRepository.findAll();
//        return users.stream()
//                .map(user->userMapper.toDto(user))
//                .collect(Collectors.toList());

        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
       User user= userRepository.findById(userId) .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}
