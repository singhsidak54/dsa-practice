package Scaler.DesignPatterns.Adapter.Social.external;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TwitterTweet {
    private String id;
    private String tweet;
    private Long userId;
}