package com.example.Authentication.Controller;

import com.example.Authentication.Repository.PostRepository;
import com.example.Authentication.Repository.SiteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SiteUserRepository siteUserRepository;

//    @GetMapping("/")
//    public String getHomePage() {
//        return "index.html";
//    }
//
//    @GetMapping("/withSecret")
//    public String getHomePageWithSecret(HttpServletRequest request, Model m){
//        HttpSession session = request.getSession();
//        String username= session.getAttribute("username").toString();
//        m.addAttribute("username", username);
//
//        return "getPost";
//    }
}
