package main.program.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * Creates a new string containing a repeated symbol the specified number of times.
     *
     * @param originalString An initial string whose length determines the number of times the symbol is repeated.
     * @param maskChar The symbol to be repeated.
     * @return A string containing a repeated symbol.
     */
    public static String maskString(String originalString, char maskChar) {
        return String.valueOf(maskChar).repeat(originalString.length());
    }

    /**
     * Extracts words from a string by removing punctuation marks.
     *
     * @param text string from which you want to extract words
     * @return string array containing words from the string
     */
    public static String[] extractWords(String text) {
        // Удаляем все знаки пунктуации и символы, оставляя только буквы и пробелы
    //    System.out.print(text);
        String cleanText = text.replaceAll("[^\\p{L}\\p{N}\\s']", "").toLowerCase();

        // Разделяем текст на слова по пробелам
        String[] words = cleanText.split("\\s+");

//        for(String str : words) {
//            System.out.print("[" + str + "]");
//        }
//
//        System.out.println(" ");

        return words;
    }

    public static String[] extractWordsAndSymbols(String text) {
        String[] parts = text.split("\\s+|(?=[,.!?:;])|(?<=[,.!?:;])");
        return parts;
    }

    public static String findWordInBrackets(String text) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
