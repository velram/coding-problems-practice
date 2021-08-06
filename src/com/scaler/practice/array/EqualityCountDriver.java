package com.scaler.practice.array;

/**
 * @author Velmurugan Moorthy
 * @date 06.08.2021
 * Time to equality
 *
 * Problem Description
 * Given an integer array A of size N. In one second you can increase the value of one element by 1.
 *
 * Find the minimum time in seconds to make all elements of the array equal.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000000
 *
 * 1 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer denoting the minimum time to make all elements equal.
 *
 *
 * Example Input
 * A = [2, 4, 1, 3, 2]
 *
 *
 * Example Output
 * 8
 *
 *
 * Example Explanation
 * We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
 */
public class EqualityCountDriver {

    public static void main(String[] args) {

        int[] input = {2, 4, 1, 3, 2}; //Test case #1 Sample input from question - PASS
//        int[] input = {1}; //Test case #2 Single element - PASS
//        int[] input = {99, 99, 99, 99, 99, 99}; //Test case #3 - All elements are same - PASS
//        int[] input = {0, 0, 0, 0,0, 0, 0, 0}; //Test case #4 All elements are zero - PASS
//        int[] input = {1,2,3,4,5,6,7,8,9,10}; //Test case #5 Max element @ last - PASS
//        int[] input = {1,1,1,1,1,1,1,1,100}; //Test case #6 one max & other min elements (same elements) - PASS
//        int[] input = {0,0,0,0,0,0,0,100}; //Test case #7 all zeros but one max - pass
//        int[] input = {1,1,1,1,1,1,1,1,1}; //Test case #8 All elements are ones - PASS

        EqualityTimeCounter equalityTimeCounter = new EqualityTimeCounter();
        int equalityTime = equalityTimeCounter.findEqualityTime(input);

        System.out.println("Time to equality is : " + equalityTime);

    }
}

class EqualityTimeCounter {
    public int findEqualityTime(int[] input) {

        int length = input.length;
        if(length == 1) {
            return 0;
        }

        int equalityTime = 0;
        int maximumElement = findMaximumElement(input, length);

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            if(input[loopIndex] != maximumElement){
                equalityTime += (maximumElement - input[loopIndex]);
            }
        }

        return equalityTime;
    }

    private int findMaximumElement(int[] input, int length) {
        int maximumElement = Integer.MIN_VALUE;

        for(int loopIndex = 0; loopIndex < length; loopIndex++) {
            if(maximumElement < input[loopIndex]){
                maximumElement = input[loopIndex];
            }
        }
        return  maximumElement;
    }
}
