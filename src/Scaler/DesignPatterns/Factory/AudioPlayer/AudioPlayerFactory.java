package Scaler.DesignPatterns.Factory.AudioPlayer;

public class AudioPlayerFactory {
    public static AudioPlayer createAudioPlayer(MediaFormat mediaFormat, int volume, double playBackRate) {
        switch (mediaFormat) {
            case MP3:
                return new MP3Player(volume, playBackRate);
            case WAV:
                return new WAVPlayer(volume, playBackRate);
            case FLAC:
                return new FLACPlayer(volume, playBackRate);
            default:
                return null;
        }
    }
}
