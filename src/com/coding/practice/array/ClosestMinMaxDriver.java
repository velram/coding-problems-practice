package com.coding.practice.array;

/**
 * @author : Velmurugan Moorthy
 * @date : 04/09/2021
 *
 * Problem name :  Closest MinMax
 *
 * Problem Description
 *
 * Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array
 *
 * and atleast one occurrence of the minimum value of the array.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 2000
 *
 *
 * Input Format
 *
 * First and only argument is vector A
 *
 *
 * Output Format
 *
 * Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array
 */
public class ClosestMinMaxDriver {
    public static void main(String[] args) {

        //int[] input = {1, 2, 3, 4, 5}; //Test case #1 Happy flow - PASS
//        int[] input = { 5, 3, 4, 2, 1};//Test case #2 Max @ start. Min @ end - PASS
//        int[] input = {0, 4, 2, 3, 1, 0, 2, 3, 4 ,1}; //Test case #3 Multiple min max elements
        int[] input = {4,4,4,4,4,}; //Test case #4 all elements are same
//        int[] input = {}; //Test case #
//        int[] input = {}; //Test case #
//        int[] input = {}; //Test case #
//        int[] input = {}; //Test case #

        ClosestMinMaxTools closestMinMaxTools = new ClosestMinMaxTools();
        int maximumElement = closestMinMaxTools.findMaximumElement(input);
        int minimumElement = closestMinMaxTools.findMinimumElement(input);

        System.out.println("Max element is : " + maximumElement);
        System.out.println("Min element is : " + minimumElement);

        int closestMinMaxSubArrayLength = closestMinMaxTools.findClosestMinMaxSubArrayLength(input);
        System.out.println("closestMinMaxSubArrayLength : " + closestMinMaxSubArrayLength);
    }
}

/*
 * Approach :
 *  1. Find max element of the array
 *  2. Find min element of the array
 *  3. Traverse array (right to left)
 *  4. Use 2 flags - closestMin & closetMax
 *  5. Find diff b/w the closestMin & max - Keep updating it every time.
 *  6. Repeat this till reaching the first element of the array.
 *  7. Exit loop if difference is 2
 */

class ClosestMinMaxTools{

    public int findClosestMinMaxSubArrayLength(int[] input) {

        int smallestMinMaxSubArrayLength = Integer.MAX_VALUE;

        final int MINIMUM_ELEMENT = findMinimumElement(input);
        final int MAXIMUM_ELEMENT = findMaximumElement(input);

        int closestMinElementIndex = -1;
        int closestMaxElementIndex = -1;
        int length = input.length;

        for(int loopIndex = length - 1; loopIndex >= 0; loopIndex--){
            if(MINIMUM_ELEMENT == input[loopIndex]){
                closestMinElementIndex = loopIndex;
                if(closestMaxElementIndex != -1){
                    int minMaxSubArrayLength = (closestMaxElementIndex - closestMinElementIndex) + 1;
                    smallestMinMaxSubArrayLength = Math.min(smallestMinMaxSubArrayLength, minMaxSubArrayLength);
                }
            }
            if(MAXIMUM_ELEMENT == input[loopIndex]){
                closestMaxElementIndex = loopIndex;
                if(closestMinElementIndex != -1 ){
                    int minMaxSubArrayLength = (closestMinElementIndex - closestMaxElementIndex) + 1;
                    smallestMinMaxSubArrayLength = Math.min(smallestMinMaxSubArrayLength, minMaxSubArrayLength);
                }
            }

            if(smallestMinMaxSubArrayLength == 2){
                return smallestMinMaxSubArrayLength;
            }
        }


        return smallestMinMaxSubArrayLength;
    }

    public int findMaximumElement(int[] input){

        int maximumElement = Integer.MIN_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){

            if(input[loopIndex] > maximumElement){
                maximumElement = input[loopIndex];
            }
        }
        return maximumElement;
    }

    public int findMinimumElement(int[] input){

        int minimumElement = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            if(input[loopIndex] < minimumElement){
                minimumElement = input[loopIndex];
            }
        }

        return  minimumElement;
    }
}