package com.blog_app_apis.services.Impl;

import com.blog_app_apis.entites.Category;
import com.blog_app_apis.entites.Post;
import com.blog_app_apis.entites.User;
import com.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog_app_apis.mapper.PostMapper;
import com.blog_app_apis.payloads.PostDto;
import com.blog_app_apis.repositories.CategoryRepository;
import com.blog_app_apis.repositories.PostRepository;
import com.blog_app_apis.repositories.UserRepository;
import com.blog_app_apis.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PostMapper postMapper;

//    @Override
//    public PostDto createPost(PostDto postDto) {
//        Post post=postMapper.toEntity(postDto);
//        Post savePost=postRepository.save(post);
//        return postMapper.toDo(savePost);
//    }

    // CREATE POST
    @Override
    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));

        Post post=postMapper.toEntity(postDto);

        post.setUser(user);
        post.setCategory(category);
        post.setAddedDate(LocalDateTime.now());
        post.setImageName("default.png");

        Post savePost=postRepository.save(post);

        return postMapper.toDto(savePost);
    }

    // UPDATE POST
    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post=postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","id",postDto.getPostId()));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = postRepository.save(post);

        return postMapper.toDto(updatedPost);
    }

    // GET POST BY ID
    @Override
    public PostDto getPostById(Long postId) {
        Post post=postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("User","id", postId));
        return postMapper.toDto(post);
    }

    // GET ALL POSTS
    @Override
    public List<PostDto> getAllPost() {
        List<Post>post=postRepository.findAll();
        return  post.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }


    // DELETE POST
    @Override
    public void deletePost(Long postId) {
        Post post= postRepository.findById(postId) .
                orElseThrow(() -> new ResourceNotFoundException("User", "id", postId));
        postRepository.delete(post);

    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
      User user=userRepository.findById(userId)
              .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        List<Post> posts = postRepository.findByUser(user);

        List<PostDto> postDto = posts.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());

        return postDto;
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
        List<Post> posts = postRepository.findByCategory(category);

        List<PostDto> postDto = posts.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());

        return postDto;
    }

    @Override
    public List<PostDto> getAllPostByUser(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        return List.of();
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return List.of();
    }
}
