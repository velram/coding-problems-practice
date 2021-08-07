package com.coding.practice.hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Velmurugan Moorthy
 * @date : 04.08.2021
 * Problem Description
 *
 * Given an 1D integer array A containing N distinct integers.
 *
 * Find the number of unique pairs of integers in the array whose XOR is equal to B.
 *
 * NOTE:
 *
 *     Pair (a, b) and (b, a) is considered to be same and should be counted once.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 105
 *
 * 1 <= A[i], B <= 107
 *
 *
 *
 * Input Format
 *
 * First argument is an 1D integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [5, 4, 10, 15, 7, 6]
 *  B = 5
 *
 * Input 2:
 *
 *  A = [3, 6, 8, 10, 15, 50]
 *  B = 5
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
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  (10 ^ 15) = 5
 *
 * Explanation 2:
 *
 *  (3 ^ 6) = 5 and (10 ^ 15) = 5
 */

public class XORPairDriver {
    public static void main(String[] args) {

        XORPairTools xorPairTools = new XORPairTools();
//        int[] input = {5, 4, 10, 15, 7, 6}; //Test case #1 - Sample input-1 from question
//        int target = 5;
//
//        int[] input = {3, 6, 8, 10, 15, 50}; //Test case #2 - Sample input-2 from question
//        int target = 5;
        int[] input = {17, 18, 8, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3}; //Test case #
        int target = 9;
////        int[] input = {}; //Test case #
////        int target = 5;
////        int[] input = {}; //Test case #
////        int target = 5;
////        int[] input = {}; //Test case #
////        int target = 5;
        int xorPairCount = xorPairTools.countXORPairs(input, target);
        System.out.println("XOR pair count : " + xorPairCount);
    }
}

class XORPairTools {
    public int countXORPairs(int[] input, int target){

        int result = 0;

        Set<Integer> inputNumberSet = new HashSet<>();
        Map<Integer, Integer> xorPairMap = new HashMap<>();

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            inputNumberSet.add(input[loopIndex]);
        }

        for(int loopIndex = 0; loopIndex < input.length ; loopIndex++) {
            int requiredElement = target ^ input[loopIndex];
            if(inputNumberSet.contains(requiredElement)){
                if(!xorPairMap.containsKey(requiredElement)){
                    xorPairMap.put(input[loopIndex], requiredElement);
                    result++;
                }
            }
        }

        return result;
    }
}
