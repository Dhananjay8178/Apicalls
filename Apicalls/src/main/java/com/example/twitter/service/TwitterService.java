package com.example.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {
    private final Twitter twitter;

    @Autowired
    public TwitterService() {
        // Initialize Twitter configuration with your API credentials
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("tCxYOnwyEEyN7rSFhSw6epMeQ")
                .setOAuthConsumerSecret("r0Km1Aqd1l90kKDm66Whuto1cQrZE1JitPXo5HItejNV3h4qiK");

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    public List<Status> searchTweetsByUser(String username) throws TwitterException {
        Query query = new Query("from:" + username);
        query.setCount(10); //This gives us the desired number of tweets
        QueryResult result = twitter.search(query);
        return result.getTweets();
    }

    public List<Status> getUserTweets(String userId) throws TwitterException {
        List<Status> tweets = new ArrayList<>();
        try {
            tweets = twitter.getUserTimeline(Long.parseLong(userId));
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return tweets;
    }
}
