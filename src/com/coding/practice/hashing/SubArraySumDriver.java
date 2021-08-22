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
 *  No subarray sums up to required number.
 *
 *
 *
 * ×
 * -->
 *
 */
public class SubArraySumDriver {
    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5};
        int requiredSum = 5;
//        int[] input = {5, 10, 20, 100, 105};
//        int requiredSum = 110;
        SubArraySumFinder subArraySumFinder = new SubArraySumFinder();
        int[] sumExists = subArraySumFinder.findSubArraySumK(input, requiredSum);
        System.out.println("Sum exists : " + sumExists[1]);
    }
}

class SubArraySumFinder {
    public int[] findSubArraySumK(int[] input, int requiredSum){

        int inputSize = input.length;
        int[] prefixSum = findPrefixSum(input);

        Arrays.stream(prefixSum).forEach(element -> System.out.println(" " + element));

        Map<Integer, int[]> prefixSumDifferenceSet = new HashMap();

        if(prefixSum[0] == requiredSum){
            return null;
        }

        for(int loopIndex = 0; loopIndex < inputSize; loopIndex++){
            int prefixSumDifference = prefixSum[loopIndex] - requiredSum;
            //System.out.println("prefixSumDifference : " + prefixSumDifference);
            if(prefixSum[loopIndex] == requiredSum){
                return null;
            }
            if(null != prefixSumDifferenceSet.get(prefixSumDifference)){
                return prefixSumDifferenceSet.get(prefixSumDifference);
            }
            else {
                prefixSumDifferenceSet.put(prefixSum[loopIndex], new int[]{input[loopIndex],input[loopIndex]});
            }
        }

        return null;
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
