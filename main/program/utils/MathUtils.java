package main.program.utils;

public class MathUtils {
    /**
     * Calculates the percentage of the part from the total.
     * @param part a number that is a fraction of the total
     * @param total total number
     * @return percentage of part of the total
     */
    public static float calculatePercentage(float part, float total) {
        // Calculate the percentage by dividing the part by the total number and multiplying by 100
        return (part / total) * 100;
    }
}
