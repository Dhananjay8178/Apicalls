package com.example.twitter.controller.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.twitter.controller.TwitterController;
import com.example.twitter.service.TwitterService;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TwitterControllerTest {

    @InjectMocks
    private TwitterController twitterController;

    @Mock
    private TwitterService twitterService;

    @BeforeEach
    public void setup() {
        List<Status> mockTweets = new ArrayList<>();
        try {
			Mockito.when(twitterService.searchTweetsByUser("testUser"))
			        .thenReturn(mockTweets);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			Mockito.when(twitterService.getUserTweets("12345"))
			        .thenReturn(mockTweets);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    public void testSearchUser() throws TwitterException {
        ResponseEntity<?> responseEntity = twitterController.searchUser("testUser");
    }

    @Test
    public void testGetUserTweets() throws TwitterException {
        ResponseEntity<?> responseEntity = twitterController.getUserTweets("12345");
    }
}
