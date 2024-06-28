package Scaler.DesignPatterns.AbstractFactory.AudioPlayers;

import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.decoder.AudioDecoder;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor.AudioProcessor;
import Scaler.DesignPatterns.Factory.AudioPlayer.AudioPlayer;

public abstract class AudioFactory {
    public abstract MediaFormat supportsFormat();

    public abstract AudioDecoder createAudioDecoder(byte[] audioData);

    public abstract AudioPlayer createAudioPlayer(int volume, double playbackRate);

    public abstract AudioProcessor createAudioProcessor(byte[] audioData);
}