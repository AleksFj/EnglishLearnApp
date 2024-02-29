package main.program.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import main.program.tasks.Module;
import main.program.tasks.*;

import java.io.IOException;
import java.util.ArrayList;

public class ModuleTypeAdapter extends TypeAdapter<Module> {

    @Override
    public void write(JsonWriter jsonWriter, Module module) throws IOException {

    }

    @Override
    public Module read(JsonReader jsonReader) throws IOException {
        return readModule(jsonReader);
    }

    private Module readModule(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Module module = null;
        int current = 0;
        String title = null;
        ArrayList<Task> tasks = new ArrayList<>();

        while (jsonReader.hasNext()) {
            String fieldName = jsonReader.nextName();
            switch (fieldName) {
                case "title" -> {
                    title = jsonReader.nextString();
                }
                case "current" -> {
                    current = jsonReader.nextInt();
                }
                case "taskList" -> {
                    tasks = readTasks(jsonReader);
                }
            }
        }

        jsonReader.endObject();

        module = new Module(title);
        module.setCurrent(current);
        tasks.forEach(module::add);

        return module;
    }

    private ArrayList<Task> readTasks(JsonReader jsonReader) throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();

        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();

            Task task = null;

            String type = null;
            String text = null;
            String titleText = null;
            String originalText = null;
            String translatedText = null;
            ArrayList<String> correctWords = new ArrayList<>();
            ArrayList<String> otherWords = new ArrayList<>();
            String hiddenWord = null;
            ArrayList<String> textMissingWord = new ArrayList<>();
            boolean isDone = false;

            while (jsonReader.hasNext()) {
                String taskFieldName = jsonReader.nextName();
                //          System.out.println("taskFieldName: " + taskFieldName);

                switch (taskFieldName) {
                    case "type" -> {
                        type = jsonReader.nextString();
                        //System.out.println("type: " + type);
                    }
                    case "text" -> {
                        text = jsonReader.nextString();
                        //                System.out.println("text: " + text);
                    }
                    case "isDone" -> {
                        isDone = jsonReader.nextBoolean();
                        //                System.out.println("isDone: " + isDone);
                    }
                    case "titleText" -> {
                        titleText = jsonReader.nextString();
                        //                System.out.println("titleText: " + titleText);
                    }
                    case "originalText" -> {
                        originalText = jsonReader.nextString();
                        //                System.out.println("originalText: " + originalText);
                    }
                    case "translatedText" -> {
                        translatedText = jsonReader.nextString();
                        //                System.out.println("translatedText: " + translatedText);
                    }
                    case "correctWords" -> {
                        correctWords = readWords(jsonReader);
                    }
                    case "otherWords" -> {
                        otherWords = readWords(jsonReader);
                    }
                    case "hiddenWord" -> {
                        hiddenWord = jsonReader.nextString();
                        //                System.out.println("hiddenWord: " + hiddenWord);
                    }
                }
            }

            assert type != null;
            task = TaskFactory.createTask(type);
            task.setDone(isDone);
            task.setText(text);

            if (task instanceof Rules) {

            } else if (task instanceof CompleteTranslation) {
                ((CompleteTranslation) task).setHiddenWord(hiddenWord);
                ((CompleteTranslation) task).setTitleText(titleText);
                ((CompleteTranslation) task).setOriginalText(originalText);
                ((CompleteTranslation) task).setTranslatedText(translatedText);
            } else if (task instanceof TranslateSentence) {
                //System.out.println("Correct words: " + correctWords);
                ((TranslateSentence) task).setCorrectWords(correctWords.toArray(new String[0]));
                ((TranslateSentence) task).setOtherWords(otherWords.toArray(new String[0]));
                ((TranslateSentence) task).setTitleText(titleText);
                ((TranslateSentence) task).setOriginalText(originalText);
                ((TranslateSentence) task).setTranslatedText(translatedText);
            } else if (task instanceof TranslateText) {
                ((TranslateText) task).setTitleText(titleText);
                ((TranslateText) task).setOriginalText(originalText);
                ((TranslateText) task).setTranslatedText(translatedText);
            }

            //   System.out.println(task);

            tasks.add(task);
            jsonReader.endObject();

        }
        jsonReader.endArray();

        return tasks;
    }

    private ArrayList<String> readWords(JsonReader jsonReader) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String word = jsonReader.nextString();
            words.add(word);
        }
        jsonReader.endArray();
        return words;
    }
}
