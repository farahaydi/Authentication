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
    public Post( String textContent, SiteUser userId) {
        this.textContent = textContent;
        this.userId = userId;
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

    public SiteUser getUserId() {
        return userId;
    }

}
