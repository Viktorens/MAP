package com.company;

import java.util.Arrays;

public class Aufgabe2 {
    public static void findMax(int[] numbers) {
        int maxValue = numbers[0];
        // finding the max value
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        // printing the result
        System.out.println("Die maximale Zahl ist: " + maxValue);
    }

    public static void findMin(int[] numbers) {
        int minValue = numbers[0];
        // finding the min value
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        // printing the result
        System.out.println("Die minimale Zahl ist: " + minValue);
    }

    public static void findMaxSum(int[] numbers) {
        int maxValue = 0;
        Arrays.sort(numbers);
        for (int i = 0, j = numbers.length - 1; i < numbers.length - 1; i++, j--) {
            maxValue = maxValue + numbers[j];
        }
        // printing the result
        System.out.println("Die maximale Summe von n-1 Zahlen: " + maxValue);
    }

    public static void findMinSum(int[] numbers) {
        int minValue = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            minValue = minValue + numbers[i];
        }
        // printing the result
        System.out.println("Die minimale Summe von n-1 Zahlen: " + minValue);
    }
}
