package Scaler.DesignPatterns.Strategy.Streaming;

public class VideoStreamingManager {
    private Video video;
    private QualityAdjustmentStrategy adjustmentStrategy;

    public VideoStreamingManager(Video video, QualityAdjustmentStrategy adjustmentStrategy) {
        this.video = video;
        this.adjustmentStrategy = adjustmentStrategy;
    }

    public Video streamVideo() {
        return adjustmentStrategy.adjust(video);
    }
}