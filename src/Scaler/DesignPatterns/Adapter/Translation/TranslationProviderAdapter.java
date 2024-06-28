package Scaler.DesignPatterns.Adapter.Translation;

import java.util.List;

public interface TranslationProviderAdapter {
    String translate(TranslationRequest request); // Translates the text in the request

    List<String> getSupportedLanguages(); // Returns a list of supported languages
}
