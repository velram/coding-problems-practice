package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 28/08/2021
 *
 * Problem name : Sort the Unsorted Array
 *
 * Problem Description
 *
 * You are given an integer array A having N integers.
 *
 * You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the minimum length.
 *
 */
public class MinLengthSubArraySortDriver {
    public static void main(String[] args) {

//        int[] input = {0, 1, 15, 25, 6, 7, 30, 40, 50};//Test case #1 sorting reqd @ mid array - PASS
//        int[] input = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};//Test case #2 Happy flow - PASS
//        int[] input = {1, 2, 3, 4};//Test case #3 No sorting required - PASS
//        int[] input = {1};//Test case #4 single element array - PASS
//        int[] input = {2, 1};//Test case #5 two element array (unsorted even sized) - PASS
//        int[] input = {73, 879};//Test case #6 two element array sorted (even sized) - PASS
//        int[] input = {38, 2 , 3, 4, 5, 6, 7, 8 , 1};//Test case #7 max sorting size (start & end elements) - PASS
        int[] input = {-146316343, 179840175, 760528516};//Test case #8 sorted (odd sized)

        MinLengthSortedSubArrayFinder minLengthSortedSubArrayFinder = new MinLengthSortedSubArrayFinder();
        int minLength = minLengthSortedSubArrayFinder.findMinLengthSubArray(input);
        System.out.println("Min Length is : " + minLength);

    }
}

class MinLengthSortedSubArrayFinder{
    public int findMinLengthSubArray(int[] input) {

        //Handle corner cases
        if(input.length == 1){
            return 0;
        }

        //Sort array :
        int[] sortedArray = input.clone();
        Arrays.sort(sortedArray);
        int minimumSizeToSort = 0;
        int[] startEndIndices = getStartEndIndices(input, sortedArray);
        if(startEndIndices[0] == startEndIndices[1]){
            return  minimumSizeToSort;
        }
        minimumSizeToSort = (startEndIndices[1] - startEndIndices[0]) + 1;

        return minimumSizeToSort;
    }

    private int[] getStartEndIndices(int[] input, int[] sortedArray) {
        int start = 0;
        int end = input.length - 1;
        boolean startIndexFound = false;
        boolean endIndexFound = false;
        while(start < end){

           if(!startIndexFound){
                startIndexFound = isNonMatchingIndex(input, sortedArray, start);
                if(startIndexFound){
                    continue;
                }
                start++;
            }

            if(!endIndexFound){
                endIndexFound = isNonMatchingIndex(input, sortedArray, end);
                if(endIndexFound){
                    continue;
                }
                end--;
            }

            if(startIndexFound && endIndexFound){
                break;
            }
        }
        return new int[]{start, end};
    }

    private boolean isNonMatchingIndex(int[] input, int[] sortedArray, int start) {
        return input[start] != sortedArray[start];
    }
}

