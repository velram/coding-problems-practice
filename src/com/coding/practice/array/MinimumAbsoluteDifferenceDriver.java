package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 16/10/2021
 * Problem name : Minimum Absolute Difference

Problem Description

Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j
and |x| denotes the absolute value of x.

Problem Constraints

1 <= length of the array <= 100000

-109 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the minimum value of | A[i] - A[j] |.


Example Input

Input 1:

A = [1, 2, 3, 4, 5]

Input 2:

A = [5, 17, 100, 11]



Example Output

Output 1:

1

Output 2:

6

Example Explanation

Explanation 1:

The absolute difference between any two adjacent elements is 1, which is the minimum value.

Explanation 2:

The minimum value is 6 (|11 - 5| or |17 - 11|).
×
-->
 */
public class MinimumAbsoluteDifferenceDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 3, 4, 5};//Test case #1 - Happy flow - PASS
//        int[] input = {5, 17, 100, 11};//Test case #2 - PASS
        int[] input = {1};//Test case #3 single element
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #

        MinimumAbsoluteDifferenceFinder minimumAbsoluteDifferenceFinder = new MinimumAbsoluteDifferenceFinder();
        int minimumAbsoluteDifference = minimumAbsoluteDifferenceFinder.solve(input);
        System.out.println(" minimumAbsoluteDifference : " + minimumAbsoluteDifference);
    }
}

class MinimumAbsoluteDifferenceFinder {
    public int solve(int[] input) {

        int minimumDifference = Integer.MAX_VALUE;
        int arraySize = input.length;

        Arrays.sort(input);

        for(int loopIndex = 1; loopIndex < arraySize; loopIndex++){
            int difference = input[loopIndex] - input[loopIndex - 1];

            if(difference < minimumDifference) {
                minimumDifference = difference;
            }
        }

        return minimumDifference;
    }
}