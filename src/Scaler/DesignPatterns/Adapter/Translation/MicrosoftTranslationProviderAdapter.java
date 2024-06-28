package Scaler.DesignPatterns.Adapter.Translation;

import Scaler.DesignPatterns.Adapter.Translation.external.MicrosoftTranslateApi;

import java.util.List;

public class MicrosoftTranslationProviderAdapter implements TranslationProviderAdapter  {

    MicrosoftTranslateApi microsoftTranslateApi = new MicrosoftTranslateApi();
    @Override
    public String translate(TranslationRequest request) {
        return microsoftTranslateApi.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    @Override
    public List<String> getSupportedLanguages() {
        return microsoftTranslateApi.getSupportedLanguages();
    }
}
