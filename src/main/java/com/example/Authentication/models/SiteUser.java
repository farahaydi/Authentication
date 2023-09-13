package com.example.Authentication.models;
import javax.persistence.*;
import java.util.List;
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Post>post;
    public SiteUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public SiteUser()
    {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }
}
