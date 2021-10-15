package com.coding.practice.sorting;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 15/10/2021
 * Problem name : Sum the Difference
 *
 * Problem Description
 * Given an integer array A of size N.
 *
 * You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * NOTE: Subsequence can be non-contiguous.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 10000
 *
 * 1<= A[i] <=1000
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the output.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2]
 *
 * Input 2:
 *
 * A = [1]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
 *
 * Output 2:
 *
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 *
 * Explanation 2:
 *
 *  Only 1 subsequence of 1 element is formed.
 */
public class SumOfDifferenceDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 3, 4, 5};//Test case #1 Happy flow - PASS
//        int[] input = {1};//Test case #2 - Edge case - single element - PASS
//        int[] input = {1, 2};//Test case #3 - two elements - PASS
        int[] input = {1000,1, 1000, 3, 1000, 4, 1000, 9, 1000, 10};//Test case #
//        int[] input = {};//Test case #

        SumDifferenceFinder sumDifferenceFinder = new SumDifferenceFinder();
        int answer = sumDifferenceFinder.findDifferenceSum(input);
        System.out.println("Answer is : " + answer);
    }
}

class SumDifferenceFinder {
    private static final int MODULO_MAX = 1000000007;
    public int findDifferenceSum(int[] input) {
        int size = input.length;

        if(size == 1){
            return 0;
        }

        Arrays.sort(input);

        int min = 0;
        int max = 0;
        long[] twoPowers = findTwoPower(size);
        long answer = 0;

        for(int loopIndex = 0; loopIndex < size; loopIndex++){
            min = (int) twoPowers[size - 1 - loopIndex] % MODULO_MAX;
            max = (int)  twoPowers[loopIndex] % MODULO_MAX;
            answer += (input[loopIndex] * (max - min));
        }

        return (int) (answer + MODULO_MAX % MODULO_MAX);
    }

    private long[] findTwoPower(int arraySize){

        long[] twoPowers = new long[arraySize];
        twoPowers[0] = 1;

        for(int loopIndex = 1; loopIndex < arraySize; loopIndex++){
            twoPowers[loopIndex] = ( 2 * twoPowers[loopIndex - 1]) % MODULO_MAX;
        }

        return twoPowers;
    }
}
