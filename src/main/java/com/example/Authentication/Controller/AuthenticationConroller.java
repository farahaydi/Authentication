package com.example.Authentication.Controller;

import com.example.Authentication.Repository.PostRepository;
import com.example.Authentication.Repository.SiteUserRepository;
import com.example.Authentication.models.SiteUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationConroller {
    @Autowired
    SiteUserRepository siteUserRepository;
    PostRepository postRepository;
    @GetMapping("/signup")
    public String getSignUpPage()
    {
        return "/signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(String username, String password){
        String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt(12));
        SiteUser siteUser = new SiteUser(username,hashedPassword);
        siteUserRepository.save(siteUser);
        return new RedirectView("loginWithSecret");
    }
    @PostMapping("/loginWithSecret")
    public RedirectView logInUSerWithSecret(HttpServletRequest request, String username, String password){
        SiteUser userFromDb=siteUserRepository.findByUsername(username);
        if((userFromDb == null)
                || (!BCrypt.checkpw(password, userFromDb.getPassword())))
        {
            return new RedirectView("/loginWithSecret");
        }
        HttpSession session= request.getSession();
        session.setAttribute("username", username);
        return new RedirectView("/withSecret");
    }
    @GetMapping("/loginWithSecret")
    public String getLoginPageWithSecret(){
        return "/loginWithSecret.html";
    }
    @PostMapping("logoutWithSecret")
    public RedirectView logOutUserWithSecret(HttpServletRequest request){

        HttpSession session= request.getSession();
        session.invalidate();

        return new RedirectView("/loginWithSecret");
    }
}
