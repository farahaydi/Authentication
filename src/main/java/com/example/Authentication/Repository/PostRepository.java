package com.example.Authentication.Repository;

import com.example.Authentication.models.Post;
import com.example.Authentication.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(SiteUser userId);
}

