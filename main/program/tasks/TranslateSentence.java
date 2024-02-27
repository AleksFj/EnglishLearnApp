package main.program.tasks;

import main.program.utils.StringUtils;

import java.util.Arrays;
import java.util.Random;

//Translate the sentence by selecting the correct words from the list
public class TranslateSentence extends ChooseWords {


    public TranslateSentence() {
        super("Translate sentence");
    }

    public TranslateSentence(TranslationPair translationPair, RandomWords otherWords) {
        this();

        if(new Random().nextFloat() > 0.5f) {
            this.originalText = translationPair.getOriginal();
            this.correctWords = StringUtils.extractWords(translationPair.getTranslated());
            this.otherWords = otherWords.getTranslatedWords();
        } else {
            this.originalText = translationPair.getTranslated();
            this.correctWords = StringUtils.extractWords(translationPair.getOriginal());
            this.otherWords = otherWords.getOriginalWords();
        }
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String toString() {
        return "TranslateSentence {\n" +
                "\tcorrectWords=" + Arrays.toString(correctWords) + "\n" +
                "\totherWords=" + Arrays.toString(otherWords) + "\n" +
                "\ttitleText=" + titleText + "\n" +
                "\toriginalText=" + originalText + "\n" +
                "\ttranslatedText=" + translatedText + "\n" +
                '}';
    }
}
