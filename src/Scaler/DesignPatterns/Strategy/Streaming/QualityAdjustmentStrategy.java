package Scaler.DesignPatterns.Strategy.Streaming;

public interface QualityAdjustmentStrategy {
    VideoQuality supportsType(); // Returns the type of video quality the strategy supports

    Video adjust(Video video); // Adjusts the video according to the strategy
}