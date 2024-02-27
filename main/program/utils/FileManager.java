package main.program.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import main.program.json.ModuleTypeAdapter;
import main.program.json.UserTypeAdapter;
import main.program.user.User;
import main.program.tasks.Module;

import java.io.*;

public class FileManager {

    public User loadUser(String name) {
        String fileName = FINAL.USERS_DIR + name + ".json";
        //System.out.println(fileName);
        User user = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(fileName));
            Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserTypeAdapter())
                    .create();
            user = gson.fromJson(reader, new TypeToken<User>() {
            }.getType());
            //    System.out.println(user);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //    System.out.println(user);

        return user;
    }

    public <T> T load(Class<T> clazz, String fileName) {
        T obj = null;

        try {
            JsonReader reader = new JsonReader(new FileReader(fileName));
            GsonBuilder gsonBuilder = new GsonBuilder();

            if (clazz == User.class) {
                gsonBuilder.registerTypeAdapter(clazz, new UserTypeAdapter());
                //obj = gson.fromJson(reader, new TypeToken<User>() {}.getType());
            } else if(clazz == Module.class) {
                gsonBuilder.registerTypeAdapter(clazz, new ModuleTypeAdapter());
            }

            Gson gson = gsonBuilder.create();
            obj = gson.fromJson(reader, clazz);
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    public void save(Object obj, String fileName) {
        //String fileName = User.USERS_DIR + user.getName() + ".json";
        fileName += ".json";
        //System.out.println(fileName);

        File fIle = new File(fileName);
        File parentDir = fIle.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
            return;
        }

        if (!fIle.exists()) {
            try {
                fIle.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            writer.write(gson.toJson(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean exists(String filePath) {
        return new File(filePath).exists();
    }
}

