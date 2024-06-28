package Scaler.DesignPatterns.Adapter.Social;

import Scaler.DesignPatterns.Adapter.Social.external.TwitterApi;
import Scaler.DesignPatterns.Adapter.Social.external.TwitterTweet;

import java.util.ArrayList;
import java.util.List;

public class TwitterAdapter implements SocialMediaAdapter {
    TwitterApi api;

    public TwitterAdapter() {
        super();
        this.api = new TwitterApi();
    }

    @Override
    public List<SocialMediaPost> getPosts(Long user, Long timestamp) {
        List<TwitterTweet> tweets =  api.getTweets(user);
        List<SocialMediaPost> posts = new ArrayList<>();
        for(TwitterTweet tweet : tweets) {
            posts.add(new SocialMediaPost(tweet.getId(), tweet.getUserId(), tweet.getTweet(), null));
        }

        return posts;
    }

    @Override
    public void postMessages(Long user, String message) {
        api.tweet(user, message);
    }
}
