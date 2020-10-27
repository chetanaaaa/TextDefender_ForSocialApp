package com.example.techtalenttwitter.twitter.repository;

import java.util.List;

import com.example.techtalenttwitter.twitter.model.Tweet;
import com.example.techtalenttwitter.twitter.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAllByOrderByCreatedAtDesc();
    List<Tweet> findAllByUserOrderByCreatedAtDesc(User user);
    List<Tweet> findAllByUserInOrderByCreatedAtDesc(List<User> users);
}