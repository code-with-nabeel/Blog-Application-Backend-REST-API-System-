package com.blog_app_apis.services;

import com.blog_app_apis.payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  PostService {
    //create post
    PostDto createPost(PostDto postDto,Long userId,Long categoryId);

    //update post
    PostDto updatePost(PostDto postDto,Long postId);

    //get single post
    PostDto getPostById(Long postId);


    //get all post
    List<PostDto> getAllPost();

    //delete post
    void deletePost(Long postId);

    // get posts by user
    List<PostDto> getPostsByUser(Long userId);

    // get posts by category
    List<PostDto> getPostsByCategory(Long categoryId);

    //get all post by user
    List<PostDto>getAllPostByUser(Long userId);

    //search post
    List<PostDto>searchPost(String keyword);
}
