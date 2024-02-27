package main.program.utils;

import java.util.*;

public class ArrayUtils {
    @SafeVarargs
    public static <T> T[] mergeArrays(T[]... array) {
        List<T> mergedList = new ArrayList<>();

        for (T[] arr : array) {
            mergedList.addAll(Arrays.asList(arr));
        }

        return mergedList.toArray(Arrays.copyOf(array[0], mergedList.size()));
    }

    public static <T> void print(Collection<T> collection) {
        for (T obj : collection) {
            System.out.print("[" + obj + "]");
        }
        System.out.println();
    }

    // Перегруженный метод для печати элементов массива
    public static <T> void print(T[] array) {
        for (T obj : array) {
            System.out.print("[" + obj + "]");
        }
        System.out.println();
    }

    public static StringIndexPair randomWordAndIndex(Collection<String> collection) {
        String string = null;
        boolean done = false;
        int index = 0;
        Object[] array = collection.toArray();

        while (!done) {
            index = new Random().nextInt(collection.size());
            String str = (String)array[index];
            if(str.chars().anyMatch(Character::isLetter)) {
                string = str;
                done = true;
            }
        }

        return new StringIndexPair(string, index);
    }
}
