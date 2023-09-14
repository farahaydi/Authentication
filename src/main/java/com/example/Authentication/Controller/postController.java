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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class postController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    SiteUserRepository siteUserRepository;
    @PostMapping("/add-post")
    public RedirectView addPost(HttpServletRequest request, String textContent, Long userId) {
        HttpSession session = request.getSession();
        String username= session.getAttribute("username").toString();
        SiteUser siteUser = siteUserRepository.findByUsername(username);
        Post post = new Post(textContent);
        post.setUserId(siteUser);
        postRepository.save(post);
        return new RedirectView("/get-post");
    }
    @GetMapping("/get-post")
    public String getPost(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "getPost";
    }

    @GetMapping("/")
    public String getHomePage() {
        return "index.html";
    }

//    @GetMapping("/withSecret")
//    public String getHomePageWithSecret(HttpServletRequest request, Model m){
//        HttpSession session = request.getSession();
//        String username= session.getAttribute("username").toString();
//        m.addAttribute("username", username);
//
//        return "getPost";
//    }

    @GetMapping("/withSecret")
    public String getHomePageWithSecret(HttpServletRequest request, Model m){
        HttpSession session = request.getSession();
        String username= session.getAttribute("username").toString();
        m.addAttribute("username", username);
        List<Post> posts = postRepository.findAll();
        m.addAttribute("posts", posts);

        return "getPost";
    }

}
