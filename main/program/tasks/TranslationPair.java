package main.program.tasks;

public class TranslationPair {
    private final String original;
    private final String translated;

    public TranslationPair(String originalText, String translatedText) {
        this.original = originalText;
        this.translated = translatedText;
    }

    public String getTranslated() {
        return translated;
    }

    public String getOriginal() {
        return original;
    }
}
