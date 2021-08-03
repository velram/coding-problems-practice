package com.scaler.practice.array;

import java.util.Arrays;

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