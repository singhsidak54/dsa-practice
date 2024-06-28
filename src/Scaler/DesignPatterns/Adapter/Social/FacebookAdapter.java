package Scaler.DesignPatterns.Adapter.Social;

import Scaler.DesignPatterns.Adapter.Social.external.FacebookApi;
import Scaler.DesignPatterns.Adapter.Social.external.FacebookPost;

import java.util.ArrayList;
import java.util.List;

public class FacebookAdapter implements SocialMediaAdapter {
    FacebookApi api;

    public FacebookAdapter() {
        super();
        this.api = new FacebookApi();
    }

    @Override
    public List<SocialMediaPost> getPosts(Long user, Long timestamp) {

        List<FacebookPost> fbPosts =  api.fetchFacebookPosts(user, timestamp);
        List<SocialMediaPost> posts = new ArrayList<>();
        for(FacebookPost fbPost : fbPosts) {
            posts.add(new SocialMediaPost(fbPost.getId(), fbPost.getUserId(), fbPost.getStatus(), fbPost.getTimestamp()));
        }

        return posts;
    }

    @Override
    public void postMessages(Long user, String message) {
        api.postFacebookStatus(user, message);
    }
}
