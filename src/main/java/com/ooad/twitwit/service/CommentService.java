// Package declaration for services related to comments in the Twitter application
package com.ooad.twitwit.service;

import com.ooad.twitwit.model.Comment;
import com.ooad.twitwit.repository.CommentRepository;

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
