package main.tasks;


//урок где нужно выбрать правильные слова из списка
public abstract class ChooseWords extends Lesson {

    protected String[] correctWords;
    protected String[] otherWords;

    protected ChooseWords(String titleText) {
        super(titleText);
    }

    public String[] getCorrectWords() {
        return correctWords;
    }

    public String[] getOtherWords() {
        return otherWords;
    }

}
