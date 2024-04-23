package com.ooad.twitwit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooad.twitwit.model.Tweet;
import com.ooad.twitwit.model.TweetDisplay;
import com.ooad.twitwit.model.User;
import com.ooad.twitwit.repository.TweetRepository;

@Service
public class TweetServiceFacade {

    @Autowired
    private TweetRepository tweetRepository;

    public List<TweetDisplay> findAll() {
        List<Tweet> tweets = tweetRepository.findAllByOrderByCreatedAtDesc();
        return formatTweets(tweets);
    }

    public List<TweetDisplay> findAllByUser(User user) {
        List<Tweet> tweets = tweetRepository.findAllByUserOrderByCreatedAtDesc(user);
        return formatTweets(tweets);
    }

    public List<TweetDisplay> findAllByUsers(List<User> users) {
        List<Tweet> tweets = tweetRepository.findAllByUserInOrderByCreatedAtDesc(users);
        return formatTweets(tweets);
    }

    public List<TweetDisplay> findAllWithTag(String tag) {
        List<Tweet> tweets = tweetRepository.findByTags_PhraseOrderByCreatedAtDesc(tag);
        return formatTweets(tweets);
    }

    private List<TweetDisplay> formatTweets(List<Tweet> tweets) {
        List<TweetDisplay> formattedTweets = new ArrayList<>();
        for (Tweet tweet : tweets) {
            TweetDisplay tweetDisplay = new TweetDisplay();
            tweetDisplay.setUser(tweet.getUser());
            tweetDisplay.setMessage(tweet.getMessage());
            // Add more fields as needed

            // Add the formatted tweet display to the list
            formattedTweets.add(tweetDisplay);
        }
        return formattedTweets;
    }

    public List<TweetDisplay> findByTagsAndByUser(String tag, List<User> users) {
        List<Tweet> userTweets = tweetRepository.findAllByUserInOrderByCreatedAtDesc(users);
        List<Tweet> tagTweets = tweetRepository.findByTags_PhraseOrderByCreatedAtDesc(tag);
        List<Tweet> outTweets = new ArrayList<Tweet>();

        for (Tweet tagTweet : tagTweets) {
            for (Tweet userTweet : userTweets) {
                if (userTweet.getUser().getUsername() == tagTweet.getUser().getUsername()) {
                    outTweets.add(tagTweet);
                    break;
                }
            }
        }
        return formatTweets(outTweets);
    }

    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    public Tweet findById(Long id) {
        return tweetRepository.findById(id).orElse(null);
    }
}