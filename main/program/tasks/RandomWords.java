package main.program.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomWords {


    private final ArrayList<String> original = new ArrayList<>(Arrays.asList(
            "hello", "goodbye", "please", "thank you", "sorry",
            "yes", "no", "maybe", "excuse", "help",
            "good", "bad", "how", "what", "nice", "love"
    ));

    private final ArrayList<String> translated = new ArrayList<>(Arrays.asList(
            "привет", "пока", "пожалуйста", "спасибо", "извините",
            "да", "нет", "возможно", "извините", "помощь",
            "хорошо", "плохо", "как", "что", "приятно", "любовь"
    ));

    private static final int MAX_WORDS = 5;

    private ArrayList<String> originalWords = new ArrayList<>();
    private ArrayList<String> translatedWords = new ArrayList<>();

    public RandomWords() {
        while(originalWords.size() < MAX_WORDS) {
            int index = new Random().nextInt(original.size());
            if(originalWords.contains(original.get(index))) continue;
            originalWords.add(original.get(index));
            translatedWords.add(translated.get(index));
        }
    }

    public RandomWords addToOriginal(String... words) {
        originalWords.addAll(Arrays.asList(words));
        return this;
    }

    public String[] getOriginalWords() {
        return originalWords.toArray(new String[0]);
    }

    public String[] getTranslatedWords() {
        return translatedWords.toArray(new String[0]);
    }

}
