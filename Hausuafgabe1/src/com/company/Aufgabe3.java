package com.company;

import java.util.Arrays;

public class Aufgabe3 {
    public static void sum(int[] firstNumber, int[] secondNumber) {
        // convert array to int
        int firstNumberInt = arrayToInt(firstNumber);
        int secondNumberInt = arrayToInt(secondNumber);
        // calculate sum
        int sum = firstNumberInt + secondNumberInt;
        // convert int to array
        int[] newNumberArray = intToArray(sum);
        // printing the result
        System.out.println("Addition: " + Arrays.toString(newNumberArray));
    }

    public static void subtraction(int[] firstNumber, int[] secondNumber) {
        // convert array to int
        int firstNumberInt = arrayToInt(firstNumber);
        int secondNumberInt = arrayToInt(secondNumber);
        // calculate difference
        int subtraction = firstNumberInt - secondNumberInt;
        // convert int to array
        int[] newNumberArray = intToArray(subtraction);
        // printing the result
        System.out.println("Difference: " + Arrays.toString(newNumberArray));
    }

    public static void multiplication(int[] firstNumber, int secondNumber) {
        // convert array to int
        int firstNumberInt = arrayToInt(firstNumber);
        // calculate multiplication
        int subtraction = firstNumberInt * secondNumber;
        // convert int to array
        int[] newNumberArray = intToArray(subtraction);
        // printing the result
        System.out.println("Multiplication: " + Arrays.toString(newNumberArray));
    }

    public static void division(int[] firstNumber, int secondNumber) {
        // Checking the numbers
        if (secondNumber == 0) {
            System.out.println("You can't divide by 0!");
            return;
        }
        // convert array to int
        int firstNumberInt = arrayToInt(firstNumber);
        // calculate division
        int subtraction = firstNumberInt / secondNumber;
        // convert int to array
        int[] newNumberArray = intToArray(subtraction);
        // printing the result
        System.out.println("Division: " + Arrays.toString(newNumberArray));
    }

    public static int arrayToInt(int[] array) {
        StringBuilder stringNumber = new StringBuilder();
        for (int j : array) {
            stringNumber.append(j);
        }
        return Integer.parseInt(String.valueOf(stringNumber));
    }

    public static int[] intToArray(int number) {
        String temp = Integer.toString(number);
        int[] newNumberArray;
        // if the number is < 0
        if (temp.charAt(0) - '0' == -3) {
            newNumberArray = new int[temp.length() - 1];
            newNumberArray[0] = (temp.charAt(1) - '0') - 2 * (temp.charAt(1) - '0');
            for (int i = 2; i < temp.length() - 1; i++)
                newNumberArray[i - 1] = temp.charAt(i) - '0';
        } else {
            newNumberArray = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++)
                newNumberArray[i] = temp.charAt(i) - '0';
        }
        return newNumberArray;
    }
}
