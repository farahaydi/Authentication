package com.example.Authentication.Controller;
import com.example.Authentication.Repository.PostRepository;
import com.example.Authentication.Repository.SiteUserRepository;
import com.example.Authentication.exception.userNotFound;
import com.example.Authentication.models.Post;
import com.example.Authentication.models.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class postController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SiteUserRepository siteUserRepository;
    @PostMapping("/add-post")
    public RedirectView addPost(String textContent, Long userId) {
        SiteUser siteUser = siteUserRepository.findById(userId)
                .orElseThrow(() -> new userNotFound("SiteUser not found with ID: " + userId));
        Post post = new Post(textContent, siteUser);
        postRepository.save(post);

        return new RedirectView("/get-post");
    }
    @GetMapping("/get-post")
    public String getPost(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "getPost";
    }
}
