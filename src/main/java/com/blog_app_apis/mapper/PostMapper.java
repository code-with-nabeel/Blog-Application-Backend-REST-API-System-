package com.blog_app_apis.mapper;

import com.blog_app_apis.entites.Post;
import com.blog_app_apis.payloads.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(Post post);
    Post toEntity(PostDto postDto);
}
