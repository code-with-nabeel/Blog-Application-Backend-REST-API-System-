package com.blog_app_apis.controllers;

import com.blog_app_apis.payloads.PostDto;
import com.blog_app_apis.payloads.UserDto;
import com.blog_app_apis.services.PostService;
import com.blog_app_apis.services.userService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);

    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto>updatePost (@Valid @RequestBody PostDto postDto,@PathVariable Long postId){
        return  new ResponseEntity<>(postService.updatePost(postDto,postId),HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto>getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>>getAllUser(){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String>deleteUser(@PathVariable Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
