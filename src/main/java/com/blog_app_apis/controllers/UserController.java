package com.blog_app_apis.controllers;

import com.blog_app_apis.payloads.UserDto;
import com.blog_app_apis.services.userService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final userService userService;

    @PostMapping
    public ResponseEntity<UserDto>createUser( @Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto>updateUser( @Valid @RequestBody UserDto userDto,@PathVariable Long userId){
        return  new ResponseEntity<>(userService.updateUser(userDto,userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>>getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String>deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

}
