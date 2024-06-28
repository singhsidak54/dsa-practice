package Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor;

import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.MediaFormat;

public abstract class AudioProcessor {

    private final byte[] audioData;

    public AudioProcessor(byte[] audioData) {
        this.audioData = audioData;
    }

    public byte[] getAudioData() {
        return audioData;
    }

    public abstract MediaFormat supportsFormat();

    public abstract byte[] process();
}
