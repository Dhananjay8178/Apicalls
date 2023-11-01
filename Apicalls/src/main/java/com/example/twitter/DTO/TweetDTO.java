package com.example.twitter.DTO;

import java.util.Date;

public class TweetDTO {
    private long id;
    private String text;
    private Date createdAt;

    // Getters and setters for the fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
