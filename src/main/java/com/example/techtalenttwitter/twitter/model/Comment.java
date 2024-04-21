package com.example.techtalenttwitter.twitter.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "COMMENT") // Specify the table name to match the database table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID") // Map the id attribute to the COMMENT_ID column
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TWEET_ID")
    private Tweet tweet;

    @NotEmpty(message = "Comment cannot be empty")
    @Column(name = "CONTENT") // Map the content attribute to the CONTENT column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT") // Map the createdAt attribute to the CREATED_AT column
    private Date createdAt;

    public Comment() {
        this.createdAt = new Date(); // Set creation date to current date/time
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", tweet=" + tweet +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public void setId(Long tweetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
