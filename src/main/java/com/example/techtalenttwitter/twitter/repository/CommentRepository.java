// Package declaration for repositories related to comments in the Twitter application
package com.example.techtalenttwitter.twitter.repository;

import com.example.techtalenttwitter.twitter.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing comments in the Twitter application.
 * Provides methods for database operations on comments.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTweetId(Long tweetId);

    // Other query methods as needed...
}
