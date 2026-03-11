package com.blog_app_apis.repositories;

import com.blog_app_apis.entites.Category;
import com.blog_app_apis.entites.Post;
import com.blog_app_apis.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
