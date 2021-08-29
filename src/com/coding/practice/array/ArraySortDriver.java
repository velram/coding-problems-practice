package com.coding.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySortDriver {

    public static void main(String[] args) {
        //Test cases :

        //0
        //0 1 2 0 1 2
       // int[] input = {0, 1, 2, 0, 1, 2};
        int[] input = {0, 1, 2, 0, 1, 2, 1, 0, 2};
        //
        ArraySorter arraySorter = new ArraySorter();
        int[] result = arraySorter.sortArray(input);
        Arrays.stream(result).forEach(element -> System.out.println(element + " "));
    }
}

class ArraySorter {

    public int[] sortArray(int[] input) {

        if (input == null || input.length == 0) {
            return null;
        }

        sortInputArray(input);
        return input;
    }

    //Find smallest element & put in first index
    //Split the array into 2 halves & sort them
    private void sortInputArray(int[] input) {

        Map<Integer, List<Integer>> indexValueMap = new HashMap<>();



        for (int loopIndex = 0; loopIndex < input.length; loopIndex++) {
            for (int innerLoopIndex = 0; innerLoopIndex < loopIndex; innerLoopIndex++) {
                if (input[loopIndex] < input[innerLoopIndex]) {
                    int temp = input[innerLoopIndex];
                    input[innerLoopIndex] = input[loopIndex];
                    input[loopIndex] = temp;
                }

            }
        }
    }
}
/**
 * private void sortInputArray(int[] input) {
 *
 *         for (int loopIndex = 0; loopIndex < input.length; loopIndex++) {
 *             for (int innerLoopIndex = 0; innerLoopIndex < loopIndex; innerLoopIndex++) {
 *                 if (input[loopIndex] < input[innerLoopIndex]) {
 *                     int temp = input[innerLoopIndex];
 *                     input[innerLoopIndex] = input[loopIndex];
 *                     input[loopIndex] = temp;
 *                 }
 *
 *             }
 *         }
 *     }
 */
