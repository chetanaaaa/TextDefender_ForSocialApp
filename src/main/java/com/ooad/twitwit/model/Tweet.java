package com.ooad.twitwit.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "tweet_tag", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    @NotEmpty(message = "Tweet cannot be empty")
    @Length(max = 280, message = "Tweet cannot have more than 280 characters")
    private String message;

    @CreationTimestamp
    private Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tweet_likes", joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likedBy;
    private String imageUrl;

    public Tweet() {
    }

    public Tweet(Long id, User user, List<Tag> tags, String message, Date createdAt, Set<User> likedBy, String imageUrl) {
        this.id = id;
        this.user = user;
        this.tags = tags;
        this.message = message;
        this.createdAt = createdAt;
        this.likedBy = likedBy;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Set<User> getLikedBy() {
        return this.likedBy;
    }

    public void setLikedBy(Set<User> likedBy) {
        this.likedBy = likedBy;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", user='" + getUser() + "'" +
                ", tags='" + getTags() + "'" +
                ", message='" + getMessage() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", likedBy='" + getLikedBy() + "'" +
                ", getImageUrl='" + getImageUrl() + "'" +
                "}";
    }

}
