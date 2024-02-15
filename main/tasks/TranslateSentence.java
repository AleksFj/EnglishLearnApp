package main.tasks;

//перевести предложение выбирая правильные слова из списка
public class TranslateSentence extends ChooseWords {


    public TranslateSentence() {
        super("Translate sentence");
    }

    public TranslateSentence(String text, String[] correctWords, String[] otherWords) {
        this();
        this.text = text;
        this.correctWords = correctWords;
        this.otherWords = otherWords;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

}
