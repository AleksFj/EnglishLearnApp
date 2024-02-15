package main.tasks;

import main.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//перевести предложение написав пропущенное слово в текст
public class CompleteTranslation extends Lesson {

    private String translatedText;
    private String hiddenWord;

    public CompleteTranslation() {
        super("Complete translation");
    }

    public CompleteTranslation(String textToTranslate, String translatedText) {
        this();
        this.text = textToTranslate;
        this.translatedText = translatedText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    // A function that takes a translatedText string and returns a list of strings separated by a random word from
    // translatedText that is replaced by asterisks
    public ArrayList<String> getTextWithMissingWord() {

        // Split the translatedText string into an array of words using spaces and punctuation marks as delimiters
        String[] words = translatedText.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");
        // Declare a variable to store a random index
        int indexToRemove;

//        for(String word : words) {
//            System.out.print("[" + word + "]" + " ");
//        }

        // Repeat until we find a word consisting of only letters
        do {
            indexToRemove = new Random().nextInt(words.length);
        } while (!words[indexToRemove].matches("\\p{Alpha}+"));

        hiddenWord = words[indexToRemove];
        System.out.println("\nHidden word: " + hiddenWord);

        // Create two subarrays from the words array: one before the random index and one after it
        String[] part1 = Arrays.copyOf(words, indexToRemove);
        String[] part2 = Arrays.copyOfRange(words, indexToRemove + 1, words.length);

        // Create a list for the result
        ArrayList<String> result = new ArrayList<>();

        if (part1.length != 0) result.add(String.join(" ", Arrays.asList(part1)));
        result.add(StringUtils.maskString(words[indexToRemove], '*'));
        if (part2.length != 0) result.add(String.join(" ", Arrays.asList(part2)));

        for(int i = 0; i < result.size(); ++i) {
            // Remove spaces before punctuation marks using a regular expression
            String str = result.get(i).replaceAll("\\s+(?=\\p{Punct})", "");
            result.set(i, str);
      //      System.out.print("[" + result.get(i) + "]" + " ");
        }

        return result;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
