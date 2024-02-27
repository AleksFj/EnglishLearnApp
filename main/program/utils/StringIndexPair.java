package main.program.utils;

public class StringIndexPair {
    public final String string;
    public final int index;
    public StringIndexPair(String string, int index) {
        this.string = string;
        this.index = index;
    }

    @Override
    public String toString() {
        return "StringIndexPair {\n" +
                "\tstring=" + string + "\n" +
                "\tindex=" + index +
                "\n};";
    }
}
