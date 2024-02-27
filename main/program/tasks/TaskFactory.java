package main.program.tasks;

public class TaskFactory {
    public static Task createTask(String className) {
        return switch (className) {
            case "Rules" -> new Rules();
            case "CompleteTranslation" -> new CompleteTranslation();
            case "TranslateSentence" -> new TranslateSentence();
            case "TranslateText" -> new TranslateText();
            default -> null;
        };
    }
}
