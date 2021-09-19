package com.coding.practice;

/**
 * @author : Velmurugan Moorthy
 * @date : 20/09/2021
 * Problem name : Maximum sum contiguous sub-array
 * Question URL : https://leetcode.com/problems/maximum-subarray/
 * Description :
 * Problem Description
 *
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 *
 *
 * Input Format
 *
 * The first and the only argument contains an integer array, A.
 *
 *
 * Output Format
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, -10]
 *
 * Input 2:
 *
 *  A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  10
 *
 * Output 2:
 *
 *  6
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Explanation 2:
 *
 *  The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxContiguousSubArrayDriver {
    public static void main(String[] args) {

//        int[] input = {4,-1,2,1};//Test case #1 - Happy flow - PASS
//        int[] input = {1, 2, 3, 4};//Test case #2 - no negative inputs - PASS
//        int[] input = {-1};//Test case #3 single element array - PASS
        //
//        int[] input = {-2,1,-3,4,-1,2,1,-5,4};//Test case #4 combo of positive & negative array
//        int[] input = {5,4,-1,7,8};//Test case #5 - negative value @ mid of the array
        int[] input = {-163, -20}; //Test case #6 - all negative inputs
//        int[] input = {};//Test case #

//

        MaxContiguousSubArraySumFinder maxContiguousSubArraySumFinder = new MaxContiguousSubArraySumFinder();
        int maxContiguousSubArraySum = maxContiguousSubArraySumFinder.findMaxContiguousSubArraySum(input);
        System.out.println("maxContiguousSubArraySum : " + maxContiguousSubArraySum);
    }
}

/**
 * Approach :
 *  1. Declare 2 variables - currentSum & maxSum
 *  2. Sum the array elements
 *  3. whenever the current sum is negative, reset it to zero.
 *  4. Calculate maxSum for every element & update accordingly.
 *  5. Do this till the last element of the array.
 */
class MaxContiguousSubArraySumFinder {
    public int findMaxContiguousSubArraySum(int[] input){

        int length = input.length;

        if(length == 1){
            return input[0];
        }

        int maxContiguousSubArraySum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            currentSum += input[loopIndex];
            maxContiguousSubArraySum = Math.max(maxContiguousSubArraySum, currentSum);
            if(currentSum < 0){
                currentSum = 0;
            }
        }

        return maxContiguousSubArraySum;
    }
}

