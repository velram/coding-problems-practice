package com.scaler.practice.array;

import java.util.Arrays;

public class ArrayRotationDriver {
    public static void main(String[] args) {

        //Test case #1 - Happy flow from sample input - PASS
//        int[] input = {1, 2, 3, 4};
//        int rotations = 2;

        //Test case #2 -  arraySize = no.of.rotations (odd) - PASS
//        int[] input = {1,2};
//        int rotations = 2;

        //TODO fix failing test cases (length >= rotation - scenarios)
        //Test case #3 - arraySize = no.of.rotations (even number) - PASS
//        int[] input = {1, 2, 2};
//        int rotations = 3;

        //Test case #4 - Single element array - multiple rotations - PASS
//        int[] input = {1};
//        int rotations = 3;

        //Test case #5 - arraySize > rotations (arraysize even, rotation odd)
//        int[] input = {1, 2, 3, 4};
//        int rotations = 5;

        //Test case #6 - arraySize > rotations (arraysize odd, rotation even)
        int[] input = {1, 2, 3, 4, 5, 7, 8, 9};
        int rotations = 12;
        ArrayRotater arrayRotater = new ArrayRotater();
        arrayRotater.rotateArray(input, rotations);

    }
}

class ArrayRotater {
    public void rotateArray(int[] input, int rotations){

        int length = input.length;

        if(length == 1 ){
            System.out.println(input[0]);
            return;
        }

        if(rotations % (length) == 0){
            printArray(input);
            return;
        }

        if(rotations > length){
            rotations = rotations % length;
        }

        int[] result = new int[input.length];
        int oldArrayIndex = rotations;
        //int newArrayIndex = 0;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            if(oldArrayIndex > rotations - 1 && oldArrayIndex < length){
                result[loopIndex] = input[oldArrayIndex++];
                if(oldArrayIndex == length){
                    oldArrayIndex = 0;
                }
            }
            else if (oldArrayIndex >= 0 && oldArrayIndex < rotations){
                result[loopIndex] = input[oldArrayIndex++];
            }
        }
        printArray(result);
    }

    private void printArray(int[] result) {
        Arrays.stream(result).forEach(element -> {
            System.out.print(" " + element);
        });
    }
}
