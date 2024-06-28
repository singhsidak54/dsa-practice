package Scaler.DesignPatterns.Factory.AudioPlayer;

public class FLACPlayer extends AudioPlayer {

    public FLACPlayer(int volume, double playBackRate) {
        super(volume, playBackRate);
    }

    public void play() {
        // Simulate playing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Playing FLAC audio");
    }

    public void pause() {
        // Simulate pausing audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Pausing FLAC audio");
    }

    public void stop() {
        // Simulate stopping audio in FLAC format
        // Each media format will have its own implementation
        System.out.println("Stopping FLAC audio");
    }

    public MediaFormat supportsType() {
        return MediaFormat.FLAC;
    }
}