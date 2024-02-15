package main.utils;

import main.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileHandler {

    public ArrayList<User> readUsers(String filePath) {
        ArrayList<User> users = new ArrayList<>();

        File file = new File(filePath);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Преобразуем JSON из файла в список пользователей
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            users = new Gson().fromJson(reader, userListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void saveUsers(ArrayList<User> users, String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(users));
            System.out.println(filePath + " is written");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        String jsonContent = gson.toJson(users);
//
//        JSONArray jsonArray = new JSONArray(jsonContent);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("user", jsonArray);
//
//        String xmlContent = XML.toString(jsonObject, "users", 4);
//
//        System.out.println(jsonContent);
//        System.out.println(xmlContent);
//        System.out.println(users);
//
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(xmlContent);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
