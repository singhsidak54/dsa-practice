package Scaler.DesignPatterns.Adapter.Social;

import java.util.List;

public interface SocialMediaAdapter {
    List<SocialMediaPost> getPosts(Long user, Long timestamp);
    void postMessages(Long user, String message);
}