package main.program.tasks;

import main.program.utils.ArrayUtils;
import main.program.utils.StringIndexPair;
import main.program.utils.StringUtils;

import java.util.*;

//перевести предложение написав пропущенное слово в текст
public class CompleteTranslation extends Lesson {

    private String hiddenWord = null;

    public CompleteTranslation() {
        super("Complete translation");
    }

    /**
     * Creates a lesson with one word hidden in the text, which the user must spell correctly based on the original
     * text.
     * <p>
     * Usage examples for CompleteTranslation:
     * <p>
     * To select the word that we want to hide, we need to highlight in square brackets {@code [Word]}, if you don't,
     * the word will be selected randomly.
     * <p>
     * To select a word at random:
     * <pre>
     * new CompleteTranslation(new TranslationPair(
     *      "She found an interesting article in a magazine.",
     *      "Она нашла интересную статью в журнале."));
     * </pre>
     * <p>
     * To select a specific word:
     * <pre>
     * new CompleteTranslation(new TranslationPair(
     *      "She found an interesting [article] in a magazine.",
     *      "Она нашла интересную [статью] в журнале."));
     * </pre>
     *
     * @param translationPair initializes an object with a pair of strings in the original language and its translation
     * @see TranslateSentence
     * @see Rules
     * @see TranslateText
     */
    public CompleteTranslation(TranslationPair translationPair) {
        this();

        if (new Random().nextFloat() > 0.5f) {
            this.originalText = translationPair.getOriginal();
            this.translatedText = translationPair.getTranslated();
        } else {
            this.originalText = translationPair.getTranslated();
            this.translatedText = translationPair.getOriginal();
        }

        String string = this.translatedText;
        String[] temp = string.split(" ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(temp));

        StringIndexPair wordIndex = ArrayUtils.randomWordAndIndex(words);
        words.remove(wordIndex.index);

        String[] parts = StringUtils.extractWordsAndSymbols(wordIndex.string);
        hiddenWord = parts[0];
        parts[0] = StringUtils.maskString(parts[0], '*');

        for (int i = 0; i < parts.length; ++i) {
            words.add(wordIndex.index + i, parts[i]);
        }

    }

    public ArrayList<String> getWords() {
        String string = this.translatedText;
        String[] temp = string.split(" ");
        ArrayList<String> words = new ArrayList<>(Arrays.asList(temp));

        String extractedWord = "";
        int extractedIndex = 0;

        for(int i = 0; i < words.size(); ++i) {
            if(words.get(i).contains(hiddenWord)) {
                extractedWord = words.get(i);
                words.remove(i);
                extractedIndex = i;
                break;
            }
        }

        String[] parts = StringUtils.extractWordsAndSymbols(extractedWord);
        for (int i = 0; i < parts.length; ++i) {
            words.add(extractedIndex + i, parts[i]);
        }
//        StringIndexPair wordIndex = ArrayUtils.randomWordAndIndex(words);
//        words.remove(wordIndex.index);
//
//        String[] parts = StringUtils.extractWordsAndSymbols(wordIndex.string);
//        hiddenWord = parts[0];
//        parts[0] = StringUtils.maskString(parts[0], '*');
//
//        for (int i = 0; i < parts.length; ++i) {
//            words.add(wordIndex.index + i, parts[i]);
//        }

        return words;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String toString() {
        return "CompleteTranslation {\n" +
                "\thiddenWord=" + hiddenWord + "\n" +
                "\ttitleText=" + titleText + "\n" +
                "\toriginalText=" + originalText + "\n" +
                "\ttranslatedText=" + translatedText + "\n" +
                '}';
    }
}
