package com.company;

public class Main {
    public static void main(String[] args) {
        // Aufgabe1
        int[] notes = {10, 28, 30, 48, 51, 60, 70, 84, 90, 100};

        System.out.println("Aufgabe 1");

        Aufgabe1.showInsufficientNotes(notes);
        Aufgabe1.calculateAverageNote(notes);
        Aufgabe1.calculateRoundedNotes(notes);
        Aufgabe1.calculateMaxRoundedNotes(notes);

        // Aufgabe2
//        int[] numbers = {12,4534546,3534556,4234,6456,234,2342,534,45,6456,67,567,56,34,54,45,5445,45,6,675,7,56,435,4,889,89,67};
        int[] numbers = {4, 8, 3, 10, 17};
        System.out.println("\nAufgabe 2");

        Aufgabe2.findMax(numbers);
        Aufgabe2.findMin(numbers);
        Aufgabe2.findMaxSum(numbers);
        Aufgabe2.findMinSum(numbers);

        // Aufgabe3
        int[] firstNumber = {1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] secondNumber = {8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] thirdNumber = {8, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] fourthNumber = {8, 5, 0, 0, 0, 0, 0, 0, 0};
        int[] fifthNumber = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        System.out.println("\nAufgabe 3");
        Aufgabe3.sum(firstNumber, secondNumber);
        Aufgabe3.subtraction(thirdNumber, fourthNumber);
        Aufgabe3.multiplication(fifthNumber, 2);
        Aufgabe3.division(fifthNumber, 2);

        // Aufgabe4
        int [] keyboard = {40, 35, 70, 15, 45};
        int [] usb = {20, 15, 40, 35};
        int budget = 60;
        System.out.println("\nAufgabe 4");
        Aufgabe4.findMin(keyboard);
        Aufgabe4.findExpensive(keyboard, usb);
        Aufgabe4.findUsb(usb, budget);
        Aufgabe4.findProducts(keyboard, usb, budget);
    }
}
