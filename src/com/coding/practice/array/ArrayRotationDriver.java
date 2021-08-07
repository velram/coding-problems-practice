package com.coding.practice.array;

import java.util.Arrays;
import java.util.Scanner;



/**
 *
 * @author Velmurugan Moorthy
 * @date 02.08.2021
 *
 *  Rotation Game
 *
 * Problem Description
 *
 * You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.
 *
 * NOTE: You can use extra memory.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 106
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
 * Second line contains a single integer B
 *
 *
 *
 * Output Format
 *
 * Print an array of integers which is the Bth right rotation of input array A, on a separate line.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  4 1 2 3 4
 *  2
 *
 * Input 2:
 *
 *  3 1 2 2
 *  3
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3 4 1 2
 *
 * Output 2:
 *
 *  1 2 2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
 *
 *
 * Explanation 2:
 *
 *  [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
 */

public class ArrayRotationDriver {
  
        //Test case #1 - Happy flow from sample input - PASS
//        int[] input = {1, 2, 3, 4};
//        int rotations = 2;

        //Test case #2 -  arraySize = no.of.rotations (odd) - PASS
//        int[] input = {1,2};
//        int rotations = 2;


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
        //int[] input = {1, 2, 3, 4, 5, 7, 8, 9};
//        int rotations = 12;

//        int[] input = {1, 2, 4};
//        int rotations = 1;
//        ArrayRotater arrayRotater = new ArrayRotater();
//        arrayRotater.rotateArray(input, rotations);

    public static void main(String[] args) {


        ArrayRotater arrayRotater = new ArrayRotater();
        Scanner reader = new Scanner(System.in);

        //System.out.println("Before reading input");

        int testCaseCount = 0;
        if(reader.hasNext()){
            testCaseCount = Integer.parseInt(reader.next());
            System.out.println("Test case count : " + testCaseCount);
        }
        for(int loopIndex = 0; loopIndex < testCaseCount; loopIndex++){
            int elementCount = 0;
            if(reader.hasNext()){
                elementCount = Integer.parseInt(reader.next());

                System.out.println("\nelementCount : " + elementCount);
            }
            int[] inputArray = new int[elementCount];
            for(int innerLoopIndex = 0; innerLoopIndex < elementCount; innerLoopIndex++){
                if(reader.hasNext()){
                    inputArray[innerLoopIndex] = Integer.parseInt(reader.next());
                    System.out.println("InputArray[" + innerLoopIndex + "] : " + inputArray[innerLoopIndex]);
                }
            }

            //System.out.println("Inner loop after reading element : ");
            int rotationCount = 0;
            if(reader.hasNext()){
                rotationCount = Integer.parseInt(reader.next());
                System.out.println("rotationCount : " + rotationCount);
            }
            //System.out.println("Inner loop after reading rotation count : " + rotationCount);
            arrayRotater.rotateArray(inputArray, rotationCount);

        }


    }
}

class ArrayRotater {
    public void rotateArray(int[] input, int rotations){

        int length = input.length;

        if(length <= 1 ){
            System.out.println(input[0]);
            return;
        }

        if(rotations % (length) == 0){
            printArray(input);
            return;
        }

        if(rotations >= length){
            rotations = rotations % length;
        }

        int[] result = new int[input.length];
        int oldArrayIndex = length - rotations;
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
        //System.out.println("Rotated array is :  ");
        Arrays.stream(result).forEach(element -> {
            System.out.print(element+ " ");
        });
        System.out.println();
    
}
}
