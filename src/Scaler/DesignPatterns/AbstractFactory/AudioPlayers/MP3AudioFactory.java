package Scaler.DesignPatterns.AbstractFactory.AudioPlayers;

import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.decoder.AudioDecoder;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.decoder.MP3Decoder;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor.AudioProcessor;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor.MP3AudioProcessor;
import Scaler.DesignPatterns.Factory.AudioPlayer.AudioPlayer;
import Scaler.DesignPatterns.Factory.AudioPlayer.MP3Player;

public class MP3AudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }

    @Override
    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new MP3Decoder(audioData);
    }

    @Override
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new MP3Player(volume, playbackRate);
    }

    @Override
    public AudioProcessor createAudioProcessor(byte[] audioData) {
        return new MP3AudioProcessor(audioData);
    }
}
