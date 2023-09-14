package com.example.Authentication.models;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textContent;
    @ManyToOne
    private SiteUser userId;

    public Post() {
    }
    public Post( String textContent) {
        this.textContent = textContent;
    }

    public Long getId() {
        return id;
    }
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setUserId(SiteUser userId) {
        this.userId = userId;
    }

    public SiteUser getUserId() {
        return userId;
    }

}
