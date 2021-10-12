package com.company;

public class Aufgabe1 {
    public static int[] showInsufficientNotes(int[] notes) {
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
        return insufficientNotes;
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

    public static int[] calculateRoundedNotes(int[] notes) {
        int i;
        int[] roundedNotes = new int[notes.length];
        // 3 cases for rounding
        for (i = 0; i < notes.length; i++) {
            if (notes[i] <= 38)
                roundedNotes[i] = notes[i];
            else if ((notes[i] % 10 <= 5) && (5 - (notes[i] % 10) < 3)) {
                int diff = 5 - (notes[i] % 10);
                roundedNotes[i] = notes[i] + diff;
            } else if ((notes[i] % 10 > 5) && (10 - (notes[i] % 10) < 3)) {
                int diff = 10 - (notes[i] % 10);
                roundedNotes[i] = notes[i] + diff;
            } else
                roundedNotes[i] = notes[i];
        }
        // printing the answer
        System.out.print("\n3. Ausgerundede Noten: ");
        for (i = 0; i < roundedNotes.length; i++) {
            System.out.print(roundedNotes[i] + " ");
        }
        return roundedNotes;
    }

    public static void calculateMaxRoundedNotes(int[] notes) {
        int i;
        int[] maxNote = {0};
        int[] roundedNotes = calculateRoundedNotes(notes);

        for (i = 0; i < roundedNotes.length; i++) {
            if (roundedNotes[i] > maxNote[0])
                maxNote[0] = roundedNotes[i];
        }

        System.out.println("\n4. Maximale abgerundete Note ist: " + maxNote[0]);
    }
}