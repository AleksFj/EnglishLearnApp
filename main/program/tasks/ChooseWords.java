package main.program.tasks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//урок где нужно выбрать правильные слова из списка
public abstract class ChooseWords extends Lesson {

    protected String[] correctWords;
    protected String[] otherWords;

    public void setCorrectWords(String[] correctWords) {
        this.correctWords = correctWords;
    }

    public void setOtherWords(String[] otherWords) {
        this.otherWords = otherWords;
    }

    public ChooseWords(String titleText) {
        super(titleText);
    }

    public String[] getCorrectWords() {
        return correctWords;
    }

    public String[] getOtherWords() {
        return otherWords;
    }

    public String[] getAllWords() {
        ArrayList<String> words = new ArrayList<>();

        words.addAll(Arrays.asList(getCorrectWords()));
        words.addAll(Arrays.asList(getOtherWords()));

        Collections.shuffle(words);

        return words.toArray(new String[0]);
    }
}
