package main.utils;

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
}
