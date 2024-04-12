package com.example.techtalenttwitter.twitter.controller;

import com.example.techtalenttwitter.twitter.model.Tweet;
import com.example.techtalenttwitter.twitter.model.User;
import com.example.techtalenttwitter.twitter.service.TweetService;
import com.example.techtalenttwitter.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LikeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @PostMapping(value = "/like/{tweetId}")
    public String likeTweet(@PathVariable("tweetId") Long tweetId, HttpServletRequest request) {
        User loggedInUser = userService.getLoggedInUser();
        Tweet tweet = tweetService.findById(tweetId);
        tweet.getLikedBy().add(loggedInUser);
        tweetService.save(tweet);
        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping(value = "/unlike/{tweetId}")
    public String unlikeTweet(@PathVariable("tweetId") Long tweetId, HttpServletRequest request) {
        User loggedInUser = userService.getLoggedInUser();
        Tweet tweet = tweetService.findById(tweetId);
        tweet.getLikedBy().remove(loggedInUser);
        tweetService.save(tweet);
        return "redirect:" + request.getHeader("Referer");
    }
}
