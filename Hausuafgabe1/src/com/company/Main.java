package com.company;

public class Main {

    public static void showInsufficientNotes(int[] notes) {
        int i, counter = 0;
        // counting how many notes are < 40
        for (i = 0; i < notes.length; i++) {
            if (notes[i] < 40)
                counter = counter + 1;
        }
        // creating new array with size of counter
        int[] insufficientNotes = new int[counter];
        // all notes < 40 are put in the array
        for (i = 0; i < notes.length; i++) {
            if (notes[i] < 40)
                insufficientNotes[i] = notes[i];
        }
        // printing the notes
        System.out.print("1. Nicht ausreichende Noten: ");
        for (i = 0; i < insufficientNotes.length; i++) {
            System.out.print(insufficientNotes[i] + " ");
        }
    }

    public static void calculateAverageNote(int[] notes) {
        int i, average, averageSum = 0;
        // calculating the average
        for (i = 0; i < notes.length; i++) {
            averageSum = averageSum + notes[i];
        }

        average = averageSum / notes.length;
        // printing the answer
        System.out.print("\n2. Durschnittnote: " + average);
    }

    public static void calculateRoundedNotes(int[] notes) {
        int i, average, averageSum = 0;
        int[] roundedNotes = new int[notes.length];

        for (i = 0; i < notes.length; i++) {
            if (notes[i] <= 38)
                roundedNotes[i] = notes[i];


        }


    }

    public static void main(String[] args) {
        // array with notes
        int[] notes = { 10, 28, 30, 40, 50, 60, 70, 84, 90, 100 };

        showInsufficientNotes(notes);
        calculateAverageNote(notes);
    }
}
