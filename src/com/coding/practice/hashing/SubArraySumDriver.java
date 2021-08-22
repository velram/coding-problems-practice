package com.coding.practice.hashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Velmurugan
 * @date - 19.08.2021
 *
 * Problem name : Subarray with given sum
 *
 * Problem Description
 *
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 *
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [2, 3]
 *
 * Output 2:
 *
 *  -1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 *
 * Explanation 2:
 *
 *  No sub-array sums up to required number.
 *
 *
 *
 * ×
 * -->
 *
 */
public class SubArraySumDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 3, 4, 5};
//        int requiredSum = 5;
//        int[] input = {5, 10, 20, 100, 105};
//        int requiredSum = 110;
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
//        int requiredSum = 12;
//        int[] input = {5, 10, 20, 100, 105};
//        int requiredSum = 120;
        int[] input = {10,20,30,40,50,62,74,83,99,129,318};
        int requiredSum = 318;
        SubArraySumFinder subArraySumFinder = new SubArraySumFinder();
        int sumExists = subArraySumFinder.findSubArraySumK(input, requiredSum);
        System.out.println("Sum exists : " + sumExists);
    }
}

class SubArraySumFinder {
    public int findSubArraySumK(int[] input, int requiredSum){

        int inputSize = input.length;
        int[] prefixSum = findPrefixSum(input);
        int start = -1;
        int end = -1;

        System.out.println("Prefix sum start ");
        Arrays.stream(prefixSum).forEach(element -> System.out.println(" " + element));
        System.out.println("==================");

        //Map<Integer, int[]> prefixSumDifferenceSet = new HashMap();
        Set<Integer> prefixSumDifferenceSet = new HashSet<>();
        if(prefixSum[0] == requiredSum){
            return 1;
        }

        for(int loopIndex = 0; loopIndex < inputSize; loopIndex++){
            int prefixSumDifference = prefixSum[loopIndex] - requiredSum;
            //System.out.println("prefixSumDifference : " + prefixSumDifference);
            if(prefixSumDifferenceSet.contains(prefixSumDifference)){
                System.out.println("Present in set ");
                System.out.println("prefixSumDifference : " + prefixSumDifference);
                System.out.println("prefixSum[loopIndex] : " + prefixSum[loopIndex]);
                System.out.println("input[loopIndex] : " + input[loopIndex]);
                System.out.println("(loopIndex + 1) : " + (loopIndex + 1));
                return 1;
            }
            else {
                System.out.println("Absent in set ");
                prefixSumDifferenceSet.add(prefixSum[loopIndex]);
                System.out.println("prefixSumDifference : " + prefixSumDifference);
                System.out.println("prefixSum[loopIndex] : " + prefixSum[loopIndex]);
                System.out.println("input[loopIndex] : " + input[loopIndex]);
                System.out.println("(loopIndex + 1) : " + (loopIndex + 1));
                System.out.println("================== \n");
            }
        }

        return -1;
    }

    private int[] findPrefixSum(int[] input) {

        int inputSize = input.length;
        int[] prefixSum = new int[inputSize];

        for(int loopIndex = 0; loopIndex < inputSize; loopIndex++){

          if(loopIndex == 0) {
              prefixSum[loopIndex] = input[loopIndex];
              continue;
          }
              prefixSum[loopIndex] += (prefixSum[loopIndex - 1] + input[loopIndex]) ;

        }

        return prefixSum;
    }
}
