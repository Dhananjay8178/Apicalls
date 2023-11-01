package com.example.twitter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.twitter.DTO.TweetDTO;
import com.example.twitter.service.TwitterService;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/twitter")
public class TwitterController {
    private final TwitterService twitterService;

    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/searchUser")
    public ResponseEntity<?> searchUser(@RequestParam String username) {
        try {
            List<Status> tweets = twitterService.searchTweetsByUser(username);

            // Convert Twitter4J Status objects to TweetDTO objects
            List<TweetDTO> response = convertTweetsToDTOs(tweets);

            return ResponseEntity.ok(response);
        } catch (TwitterException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred while searching for tweets.");
        }
    }

    @GetMapping("/getUserTweets")
    public ResponseEntity<?> getUserTweets(@RequestParam String userId) {
        try {
            List<Status> tweets = twitterService.getUserTweets(userId);

            // Convert Twitter4J Status objects to TweetDTO objects
            List<TweetDTO> response = convertTweetsToDTOs(tweets);

            return ResponseEntity.ok(response);
        } catch (TwitterException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred while fetching user tweets.");
        }
    }

    private List<TweetDTO> convertTweetsToDTOs(List<Status> tweets) {
        // Convert Twitter4J Status objects to TweetDTO objects
        List<TweetDTO> dtos = new ArrayList<>();
        for (Status tweet : tweets) {
            TweetDTO dto = new TweetDTO();
            dto.setId(tweet.getId());
            dto.setText(tweet.getText());
            dto.setCreatedAt(tweet.getCreatedAt());
            dtos.add(dto);
        }
        return dtos;
    }
}
