package com.coding.practice.array;

/**
 * @author : Velmurugan Moorthy
 * @date : 18/09/2021
 * Problem name : Maximum Absolute Difference
 * Question URL : https://www.interviewbit.com/problems/maximum-absolute-difference/
 * Description :
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 *
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 * For example,
 *
 * A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 */
public class MaxAbsoluteDifferenceDriver {
    public static void main(String[] args) {

//        int[] input = {1, 3, -1};//Test case#1 - Happy flow - PASS
        int[] input = {2};//Test case #2 - single input - PASS
        MaxAbsoluteDifferenceFinder maxAbsoluteDifferenceFinder = new MaxAbsoluteDifferenceFinder();
        int maxAbsoluteDifference = maxAbsoluteDifferenceFinder.findMaxAbsoluteDifference(input);
        System.out.println("maxAbsoluteDifference : " + maxAbsoluteDifference);
    }
}

/**
 * Approach :
 *  1. Find difference between sum of index (i) & array elements (a[i])
 *  2. Find diff b/w diff of indices & array elements a[i]
 *  3. Find Max of both values
 */
class MaxAbsoluteDifferenceFinder{
    public int findMaxAbsoluteDifference(int[] input){

        int maxAbsoluteDifference = 0;

        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            xMax = Math.max(xMax, input[loopIndex] + loopIndex);
            xMin = Math.min(xMin, input[loopIndex] + loopIndex);
            yMax = Math.max(yMax, input[loopIndex] - loopIndex);
            yMin = Math.min(yMin, input[loopIndex] - loopIndex);
        }

        maxAbsoluteDifference = Math.max(xMax - xMin, yMax - yMin);

        return maxAbsoluteDifference;
    }
}