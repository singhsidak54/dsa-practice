package Scaler.DesignPatterns.AbstractFactory.AudioPlayers;

import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.decoder.AudioDecoder;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.decoder.FLACDecoder;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor.AudioProcessor;
import Scaler.DesignPatterns.AbstractFactory.AudioPlayers.processor.FLACAudioProcessor;
import Scaler.DesignPatterns.Factory.AudioPlayer.AudioPlayer;
import Scaler.DesignPatterns.Factory.AudioPlayer.FLACPlayer;

public class FLACAudioFactory extends AudioFactory {
    @Override
    public MediaFormat supportsFormat() {
        return MediaFormat.FLAC;
    }

    @Override
    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new FLACDecoder(audioData);
    }

    @Override
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new FLACPlayer(volume, playbackRate);
    }

    @Override
    public AudioProcessor createAudioProcessor(byte[] audioData) {
        return new FLACAudioProcessor(audioData);
    }
}
