package main.program.tasks;

import main.program.utils.ArrayUtils;
import main.program.utils.StringIndexPair;
import main.program.utils.StringUtils;

import java.util.*;

//перевести предложение написав пропущенное слово в текст
public class CompleteTranslation extends Lesson {

    private String hiddenWord;

    private ArrayList<String> textWithMissingWord = new ArrayList<>();

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public void setTextWithMissingWord(ArrayList<String> textWithMissingWord) {
        this.textWithMissingWord = textWithMissingWord;
    }

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
        //ArrayUtils.print(words);

        StringIndexPair wordIndex = ArrayUtils.randomWordAndIndex(words);
        words.remove(wordIndex.index);

        //       System.out.println(wordIndex);

        //if(!wordIndex.string.chars().allMatch(Character::isLetter)) {
        String[] parts = StringUtils.extractWordsAndSymbols(wordIndex.string);
        hiddenWord = parts[0];
        parts[0] = StringUtils.maskString(parts[0], '*');
        //           ArrayUtils.print(parts);
//            System.out.println("Insert/Add");
//            System.out.println(wordIndex.index + "/" + words.size());
        for (int i = 0; i < parts.length; ++i) {
            words.add(wordIndex.index + i, parts[i]);
        }
        //ArrayUtils.print(words);

        textWithMissingWord = words;

    }

    // A function that takes a translatedText string and returns a list of strings separated by a random word from
    // translatedText that is replaced by asterisks
    public ArrayList<String> getTextWithMissingWord() {
        return textWithMissingWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String toString() {
        return "CompleteTranslation {\n" +
                "\thiddenWord=" + hiddenWord + "\n" +
                "\ttextWithMissingWord=" + textWithMissingWord + "\n" +
                "\ttitleText=" + titleText + "\n" +
                "\toriginalText=" + originalText + "\n" +
                "\ttranslatedText=" + translatedText + "\n" +
                '}';
    }
}
