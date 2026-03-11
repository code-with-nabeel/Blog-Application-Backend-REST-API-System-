package com.blog_app_apis.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private Long categoryId;
    @NotEmpty(message = "Title must be required")
    @Size(max=50)
    private String categoryTitle;
    @NotEmpty
    private String categoryDescription;
}
