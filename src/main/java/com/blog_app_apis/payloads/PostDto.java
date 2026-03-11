package com.blog_app_apis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private String imageName;
    private LocalDateTime addedDate;

    private UserDto user;
    private CategoryDto category;
}
