package com.company;

public class Aufgabe4 {
    public static void findMin(int[] numbers) {
        int minValue = numbers[0];
        // finding the min value
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        // printing the result
        System.out.println("Die biligste Tastatur ist: " + minValue);
    }

    public static void findExpensive(int[] keyboard, int[] usb) {
        // finding the max from both arrays
        int maxValueKeyboard = findMax(keyboard);
        int maxValueUsb = findMax(usb);
        // printing the results
        if (maxValueKeyboard > maxValueUsb)
            System.out.println("Der teuerste Gegenstand ist eine Tastatur die " + maxValueKeyboard + " kostet.");
        else
            System.out.println("Der teuerste Gegenstand ist ein USB der " + maxValueUsb + " kostet.");
    }

    public static void findUsb(int[] numbers, int budget) {
        int value = 0;
        // searching item smaller then budget
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > value && numbers[i] <= budget) {
                value = numbers[i];
            }
        }
        // special case when nothing is found
        if (value == 0)
            System.out.println("Markus kann mit " + budget + " nichts kaufen.");
        else
            System.out.println("Der teuerste USB Gegenstand der Markus mit " + budget + " kaufen kann, kostet: " + value);
    }

    public static void findProducts(int[] keyboard, int[] usb, int budget) {
        int price = 0;
        int[] items = new int[2];
        // searching and storing the values < budget
        for (int k : keyboard) {
            for (int i : usb) {
                if (k + i >= price && k + i <= budget) {
                    items[0] = k;
                    items[1] = i;
                    price = k + i;
                }
                // case when price > budget
                if (k + i > budget) {
                    System.out.println(k + " + " + i + " = -1");
                }
            }
        }
        System.out.println(items[0] + " + " + items[1] + " = " + price);
    }

    public static int findMax(int[] numbers) {
        int maxValue = numbers[0];
        // finding the max value
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
}
