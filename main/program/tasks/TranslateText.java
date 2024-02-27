package main.program.tasks;

//полностью перевести текст
public class TranslateText extends Lesson {

    public TranslateText() {
        super("Translate text");
    }

    public TranslateText(TranslationPair translationPair) {
        this();
        this.originalText = translationPair.getOriginal();
        this.translatedText = translationPair.getTranslated();
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String toString() {
        return "TranslateText {\n" +
                "\ttitleText=" + titleText + "\n" +
                "\toriginalText=" + originalText + "\n" +
                "\ttranslatedText=" + translatedText + "\n" +
                '}';
    }
}
