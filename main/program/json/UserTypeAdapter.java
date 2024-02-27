package main.program.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import main.program.tasks.*;
import main.program.tasks.Module;
import main.program.user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserTypeAdapter extends TypeAdapter<User> {

    @Override
    public void write(JsonWriter jsonWriter, User user) throws IOException {

    }

    @Override
    public User read(JsonReader jsonReader) throws IOException {
        User user = null;
        List<Module> modules = new ArrayList<>();

        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String fieldName = jsonReader.nextName();
            //          System.out.println(fieldName);
            switch (fieldName) {
                case "name" -> {
                    String name = jsonReader.nextString();
                    user = User.create(name);
                }
                case "modules" -> {
                    modules = readModules(jsonReader);
                }
                default -> jsonReader.skipValue();
            }
        }
        jsonReader.endObject();

        assert user != null;

        modules.forEach(user::addModule);

        return user;
    }

    private ArrayList<Module> readModules(JsonReader jsonReader) throws IOException {
        ArrayList<Module> modules = new ArrayList<>();

        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Module module = new ModuleTypeAdapter().read(jsonReader);
//            int current = 0;
//            String title = null;
//            ArrayList<Task> tasks = new ArrayList<>();
//
//            jsonReader.beginObject();
//            while (jsonReader.hasNext()) {
//                String moduleFieldName = jsonReader.nextName();
//                //      System.out.println("moduleFieldName: " + moduleFieldName);
//                switch (moduleFieldName) {
//                    case "title" -> {
//                        title = jsonReader.nextString();
//                        //               System.out.println("title: " + title);
//                    }
//                    case "current" -> {
//                        current = jsonReader.nextInt();
//                        //               System.out.println("current: " + current);
//                    }
//                    case "taskList" -> {
//                        tasks = readTasks(jsonReader);
//                   //     System.out.println(tasks);
//                    }
//                    default -> {
//                        jsonReader.skipValue();
//                    }
//                }
//            }
//
//            assert module != null;
//            module = new Module(title);
//            module.setCurrent(current);
//            tasks.forEach(module::add);
//            jsonReader.endObject();
            modules.add(module);
        }
        jsonReader.endArray();

        return modules;
    }

//    private ArrayList<Task> readTasks(JsonReader jsonReader) throws IOException {
//        ArrayList<Task> tasks = new ArrayList<>();
//
//        jsonReader.beginArray();
//        while (jsonReader.hasNext()) {
//            jsonReader.beginObject();
//
//            Task task = null;
//
//            String type = null;
//            String text = null;
//            String titleText = null;
//            String originalText = null;
//            String translatedText = null;
//            ArrayList<String> correctWords = new ArrayList<>();
//            ArrayList<String> otherWords = new ArrayList<>();
//            String hiddenWord = null;
//            ArrayList<String> textMissingWord = new ArrayList<>();
//            boolean isDone = false;
//
//            while (jsonReader.hasNext()) {
//                String taskFieldName = jsonReader.nextName();
//                //          System.out.println("taskFieldName: " + taskFieldName);
//
//                switch (taskFieldName) {
//                    case "type" -> {
//                        type = jsonReader.nextString();
//                        //System.out.println("type: " + type);
//                    }
//                    case "text" -> {
//                        text = jsonReader.nextString();
//                        //                System.out.println("text: " + text);
//                    }
//                    case "isDone" -> {
//                        isDone = jsonReader.nextBoolean();
//                        //                System.out.println("isDone: " + isDone);
//                    }
//                    case "titleText" -> {
//                        titleText = jsonReader.nextString();
//                        //                System.out.println("titleText: " + titleText);
//                    }
//                    case "originalText" -> {
//                        originalText = jsonReader.nextString();
//                        //                System.out.println("originalText: " + originalText);
//                    }
//                    case "translatedText" -> {
//                        translatedText = jsonReader.nextString();
//                        //                System.out.println("translatedText: " + translatedText);
//                    }
//                    case "correctWords" -> {
//                        correctWords = readWords(jsonReader);
//                    }
//                    case "otherWords" -> {
//                        otherWords = readWords(jsonReader);
//                    }
//                    case "hiddenWord" -> {
//                        hiddenWord = jsonReader.nextString();
//                        //                System.out.println("hiddenWord: " + hiddenWord);
//                    }
//                    case "textWithMissingWord" -> {
//                        textMissingWord = readWords(jsonReader);
//                    }
//                }
//            }
//
//            assert type != null;
//            task = TaskFactory.createTask(type);
//
//            task.setDone(isDone);
//            task.setText(text);
//
//            if(task instanceof Rules) {
//
//            } else if(task instanceof CompleteTranslation) {
//                ((CompleteTranslation) task).setHiddenWord(hiddenWord);
//                ((CompleteTranslation) task).setTextWithMissingWord(textMissingWord);
//                ((CompleteTranslation) task).setTitleText(titleText);
//                ((CompleteTranslation) task).setOriginalText(originalText);
//                ((CompleteTranslation) task).setTranslatedText(translatedText);
//            } else if(task instanceof TranslateSentence) {
//                //System.out.println("Correct words: " + correctWords);
//                ((TranslateSentence) task).setCorrectWords(correctWords.toArray(new String[0]));
//                ((TranslateSentence) task).setOtherWords(otherWords.toArray(new String[0]));
//                ((TranslateSentence) task).setTitleText(titleText);
//                ((TranslateSentence) task).setOriginalText(originalText);
//                ((TranslateSentence) task).setTranslatedText(translatedText);
//            } else if(task instanceof TranslateText) {
//                ((TranslateText) task).setTitleText(titleText);
//                ((TranslateText) task).setOriginalText(originalText);
//                ((TranslateText) task).setTranslatedText(translatedText);
//            }
//
//         //   System.out.println(task);
//
//            tasks.add(task);
//            jsonReader.endObject();
//
//        }
//        jsonReader.endArray();
//
//        return tasks;
//    }

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
