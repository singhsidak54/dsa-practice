package Scaler.DesignPatterns.Adapter.Social.external;

import java.util.List;

import static Scaler.DesignPatterns.Adapter.Social.external.ApiUtils.logTwitterGetPosts;
import static Scaler.DesignPatterns.Adapter.Social.external.ApiUtils.logTwitterPostStatus;

public class TwitterApi {

    public List<TwitterTweet> getTweets(Long userId) {
        // Implementation to fetch Twitter tweets
        logTwitterGetPosts();
        return List.of(new TwitterTweet("1", "Hello World", 1L));
    }

    public void tweet(Long userId, String text) {
        // Implementation to send a tweet on Twitter
        logTwitterPostStatus();
    }
}
