// Package declaration for services related to comments in the Twitter application
package com.example.techtalenttwitter.twitter.service;

import com.example.techtalenttwitter.twitter.model.Comment;
import com.example.techtalenttwitter.twitter.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class providing operations related to Comments in the Twitter application.
 * Includes methods for finding, saving, and formatting comments.
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    // Method to save a comment
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Method to get all comments for a tweet
    public List<Comment> getCommentsByTweetId(Long tweetId) {
        return commentRepository.findByTweetId(tweetId);
    }

    // Other methods as needed...
}
