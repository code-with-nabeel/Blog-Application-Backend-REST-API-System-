package com.blog_app_apis.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String details;
    private String errorCode;

}
