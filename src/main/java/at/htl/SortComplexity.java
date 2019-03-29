package at.htl;

import java.util.Random;
import java.util.Scanner;

public class SortComplexity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anzahl der zu sortierenden Arrays: ");
        int arrays = scanner.nextInt();
        System.out.print("Größe der Arrays: ");
        int size = scanner.nextInt();
        long time = 0;
        long average = 0;
        for (int i = 0; i < arrays; i++) {
            time = sortRandomArray(size);
            System.out.print("\nLaufzeit zur Sortierung des "+(i+1)+". Arrays: " + time+" ms");
            average += time;
        }
        average /= arrays;
        System.out.println("\n\nDurschnittliche Laufzeit: "+average+" ms");
    }

    // Sorts an array of random numbers and returns the sorting run time in ms
    public static long sortRandomArray(int length) {
        int[] array = generateRandomArray(length);
        long startTime = System.currentTimeMillis();
        sort(array);
        long endTime = System.currentTimeMillis();

        return (endTime-startTime);
    }

    // Returns an array of random numbers
    public static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000)+1;
        }
        return array;
    }

    // Sorts an array of numbers in ascending order
    public static void sort(int[] array) {
        boolean swaped = false;
        int j = array.length-1;
        do {
            swaped = false;
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i+1]){
                    swap(array,i,i+1);
                    swaped = true;
                }
            }
        }while (swaped);

    }

    // Swaps the array elements with index i and j
    public static void swap(int[] array, int i, int j) {
        int help = array [i];
        array[i] = array[j];
        array[j] = help;

    }
}
