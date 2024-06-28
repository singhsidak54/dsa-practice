package Scaler.DesignPatterns.Adapter.Translation;

import Scaler.DesignPatterns.Adapter.Translation.external.GoogleTranslateApi;
import Scaler.DesignPatterns.Adapter.Translation.external.GoogleTranslationRequest;

import java.util.List;

public class GoogleTranslationProvider implements TranslationProviderAdapter {

    GoogleTranslateApi googleTranslateApi = new GoogleTranslateApi();

    @Override
    public String translate(TranslationRequest request) {
        return googleTranslateApi.convert(new GoogleTranslationRequest(request.getText(), request.getSourceLanguage(), request.getTargetLanguage(), request.getConfidenceThreshold()));
    }

    @Override
    public List<String> getSupportedLanguages() {
        return googleTranslateApi.getLanguages();
    }
}
