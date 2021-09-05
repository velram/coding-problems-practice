package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 05/09/2021
 *
 * Problem name : Non decreasing sub-array queries
 *
 * Problem Description
 * Given an array A of size N. You will be given M queries to process. Each query will be of the form B[i][0] B[i][1].
 *
 * If the sub-array from B[i][0] to B[i][1] is non decreasing, the output should be 1 else output should be 0.
 *
 * Return an array of integers answering each query.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= M <= 105
 *
 * 1 <= B[i][0], B[i][1] <= N
 *
 *
 * Input Format
 * First argument contains the array A.
 *
 * Second argument contains B, denoting the queries.
 *
 *
 * Output Format
 * Return an array of integers consisting of 0 and 1
 *
 *
 * Example Input
 * Input :
 *
 * A = [1, 7, 3, 4, 9]
 * B = [ 
 *       [1, 2], 
 *       [2, 4]
 *     ]
 *
 *
 *
 * Example Output
 * Input :
 *
 * [1, 0]
 *
 *
 *
 * Example Explanation
 * Explanation :
 *
 * Query 1: The sub-array in the range [1, 2] is {1, 7} which is non-decreasing. Therefore, ans = 1
 * Query 2: The sub-array in the range [2, 4] is {7, 3, 4, 9} which is not non-decreasing. Therefore, ans = 0
 */
public class NonDecreasingSubArrayDriver {
    public static void main(String[] args) {

        //Test case#1 - Happy flow 0 - PASS
//        int[] input = {1, 7, 3, 4, 9};
//        int[][] queries = {{1, 2}, {2, 4}};

        //Test case#2 - equal element array
        int[] input = {7, 7, 1, 6, 9};
        int[][] queries = {{1,2}};


        //Test case#
//        int[] input = {};
//        int[][] queries = {{}};


        //Test case#
//        int[] input = {};
//        int[][] queries = {{}};


        //Test case#
//        int[] input = {};
//        int[][] queries = {{}};

        NonDecreasingSubArrayTools nonDecreasingSubArrayTools = new NonDecreasingSubArrayTools();
        int[] result = nonDecreasingSubArrayTools.findNonDecreasingSubArray(input, queries);

        System.out.println("Non decreasing array result : ");
        Arrays.stream(result).forEach(element -> {
            System.out.print(element + " ");
            System.out.println();
        });
    }
}

/**
 * Approach :
 *
 * 1. Create flag array to mark increasing order elements.
 * 2. Compare each element with previous element.
 * 3. If it's greater than prev element mark it as 0. Else, 1.
 * 4. After completing the array traversal, find the prefixSum of the flag array.
 * 5. For every query, check the prefix sum array if start & end elements match it's an increasing sub-array.
 */
class NonDecreasingSubArrayTools{
    public int[] findNonDecreasingSubArray(int[] inputArray, int[][] queries) {

        int[] flagArray = prepareFlagArray(inputArray);
        int[] flagPrefixSum = findPrefixSum(flagArray);
        int queryLength = queries.length;
        int[] result = new int[queryLength];

        for(int loopIndex = 0; loopIndex < queryLength; loopIndex++){
            int left = queries[loopIndex][0] - 1;
            int right = queries[loopIndex][1] - 1;

            if(flagPrefixSum[left] == flagPrefixSum[right]){
                result[loopIndex] = 1;
            }
            else {
                result[loopIndex] = 0;
            }
        }
        return result;
    }

    public int[] prepareFlagArray(int[] input){
        int length = input.length;
        int[] flagArray = new int[length];

        flagArray[0] = 0;

        for(int loopIndex = 1; loopIndex < length; loopIndex++){

            if(input[loopIndex] >= input[loopIndex - 1]){
                flagArray[loopIndex] = 0;
            }
            else {
                flagArray[loopIndex] = 1;
            }
        }
        System.out.println("flagArray");
        Arrays.stream(flagArray).forEach(element -> System.out.println(element));
        return flagArray;
    }

    public int[] findPrefixSum(int[] input){

        int length = input.length;
        int[] prefixSum = new int[length];

        prefixSum[0] = input[0];

        for(int loopIndex = 1; loopIndex < length; loopIndex++){
            prefixSum[loopIndex] = prefixSum[loopIndex - 1] + input[loopIndex];
        }
        System.out.println("Prefix sum");
        Arrays.stream(prefixSum).forEach(element -> System.out.println(element));
        return prefixSum;
    }

}
