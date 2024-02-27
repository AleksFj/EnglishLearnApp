package main.program.tasks;

//урок
public abstract class Lesson extends Task {

    protected String titleText;
    protected String originalText;

    protected String translatedText;

    public Lesson(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
