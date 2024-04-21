package com.example.techtalenttwitter.twitter.model;

import java.util.List;

public class TweetDisplay {
    private Long id; // New property for tweet ID
    private User user;
    private String message;
    private String date;
    private List<Tag> tags;

    public TweetDisplay() {
    }

    public TweetDisplay(Long id, User user, String message, String date, List<Tag> tags) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.date = date;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TweetDisplay [id=" + id + ", date=" + date + ", message=" + message + ", tags=" +
                tags + ", user=" + user + "]";
    }
}
