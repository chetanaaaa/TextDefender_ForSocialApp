package com.ooad.twitwit.controller;

import com.ooad.twitwit.model.Comment;
import com.ooad.twitwit.model.Tweet;
import com.ooad.twitwit.service.CommentService;
import com.ooad.twitwit.service.TweetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class handling HTTP requests related to comments in the Twitter application.
 * Includes methods for handling comment-related endpoints such as posting and retrieving comments.
 */
@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private TweetService tweetService;

    // Endpoint to post a comment
    @PostMapping("/tweet")
public String postComment(@ModelAttribute Comment comment, @RequestParam("tweetId") Long tweetId, @RequestParam("userId") Long userId) {
    // Set the tweet ID and user ID for the comment
    Tweet tweet = tweetService.findById(tweetId);
    comment.getTweet().setId(tweetId);
    comment.getUser().setId(userId);
    
    // Assuming you have logic to validate the comment and associate it with the tweet
    // For simplicity, we assume the comment is associated with the tweet with ID tweetId
    // You can customize this logic as per your requirements
    commentService.saveComment(comment);
    return "redirect:/tweets/" + tweetId; // Redirect to the tweet page after posting the comment
}


    // Endpoint to get comments for a tweet
    @GetMapping("/tweet/{tweetId}")
    public String getCommentsByTweetId(@PathVariable Long tweetId, Model model) {
        List<Comment> comments = commentService.getCommentsByTweetId(tweetId);
        model.addAttribute("comments", comments);
        return "feed"; // Thymeleaf template name to display comments for a tweet
    }

    // Other endpoints as needed...
}
