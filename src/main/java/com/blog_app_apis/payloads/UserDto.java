package com.blog_app_apis.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;

   @NotBlank(message = "Name cannot be Empty")
   @Size(max = 100)
   private String name;

   @Email(message = "Invalid email format")
   private String email;

   @NotEmpty(message = "Please fill the Password")
   @Size(min=8,max=10,message = "Password must be min of 8 char and max of 10 char !")
   private String password;

   private String about;

}
