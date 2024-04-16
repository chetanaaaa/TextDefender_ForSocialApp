package com.example.techtalenttwitter.twitter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import com.example.techtalenttwitter.twitter.model.SpamWord;
import com.example.techtalenttwitter.twitter.model.Tweet;
import com.example.techtalenttwitter.twitter.model.TweetDisplay;
import com.example.techtalenttwitter.twitter.model.User;
import com.example.techtalenttwitter.twitter.service.SpamWordService;
import com.example.techtalenttwitter.twitter.service.TweetService;
import com.example.techtalenttwitter.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TweetController {
	
	@Autowired
	private SpamWordService spamWordService;
	
    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping(value = { "/tweets" })
    public String getFeed(@RequestParam(value = "filter", required = false) String filter, Model model) {
        User loggedInUser = userService.getLoggedInUser();
        List<TweetDisplay> tweets = new ArrayList<>();
        if (filter == null) {
            filter = "all";
        }
        if (filter.equalsIgnoreCase("following")) {
            List<User> following = loggedInUser.getFollowing();
            following.add(loggedInUser); // Include loggedInUser in the feed
            tweets = tweetService.findAllByUsers(following);
            model.addAttribute("filter", "following");
        } else {
            tweets = tweetService.findAll();
            model.addAttribute("filter", "all");
        }
        model.addAttribute("tweetList", tweets);
        return "feed";
    }

    @GetMapping(value = "/tweets/new")
    public String getTweetForm(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "newTweet";
    }
    

    @GetMapping(value = "/tweets/{tag}")
    public String getTweetsByTag(@RequestParam(value = "filter", required = false) String filter, @PathVariable(value = "tag") String tag, Model model) {
        User loggedInUser = userService.getLoggedInUser();
        List<TweetDisplay> tweets = new ArrayList<>();
        if (filter == null) {
            filter = "all";
        }
        if (filter.equalsIgnoreCase("following")) {
            List<User> following = loggedInUser.getFollowing();
            following.add(loggedInUser); // Include loggedInUser in the feed
            tweets = tweetService.findByTagsAndByUser(tag, following);
            model.addAttribute("filter", "following");
        } else {
            tweets = tweetService.findAllWithTag(tag);
            model.addAttribute("filter", "all");
        }
        model.addAttribute("tweetList", tweets);
        model.addAttribute("tag", tag);
        return "taggedTweets";
    }

    @PostMapping(value = "/tweets")
    public String submitTweetForm(@Valid Tweet tweet, BindingResult bindingResult, Model model) {
        User user = userService.getLoggedInUser();
        if (!bindingResult.hasErrors()) {
            // Check if the tweet contains spam words
            if (containsSpam(tweet.getMessage())) {
                model.addAttribute("errorMessage", "Your tweet contains spam words. Please remove them and try again.");
            } else {
                tweet.setUser(user);
                tweetService.save(tweet);
                model.addAttribute("successMessage", "Tweet successfully created!");
                model.addAttribute("tweet", new Tweet());
            }
        }
        return "newTweet";
    }

   
    private boolean containsSpam(String content) {
    
        List<SpamWord> spamWords = spamWordService.getAllSpamWords();

        
        for (SpamWord spamWord : spamWords) {
            if (content.toLowerCase().contains(spamWord.getWord().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
