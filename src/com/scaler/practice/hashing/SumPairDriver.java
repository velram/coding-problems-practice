package com.scaler.practice.hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Velmurugan Moorthy
 * @date 04.08.2021
 *
 * 2 Sum
 *
 * Problem Description
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
 *
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class SumPairDriver {
    public static void main(String[] args) {

//        int[] input = {2, 7, 11, 15}; //PASS
//        int target = 9;
       int[] input = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8}; //PASS
        int target = -3;

        PairSumFinder pairSumFinder = new PairSumFinder();
        int[] pairSum = pairSumFinder.findPairSum(input, target);

        System.out.println("Index-1 : " + pairSum[0] + " |||   Index-2 : " + pairSum[1]);
    }
}

class PairSumFinder {
    public int[] findPairSum(final int[] inputArray, int target) {
        int[] result = null;
        Map<Integer, Integer> inputIndexMap = new HashMap<>();
        for(int loopIndex = 0; loopIndex < inputArray.length; loopIndex++) {
            int requiredNumber = target - inputArray[loopIndex];
            if(inputIndexMap.containsKey(requiredNumber)){
                result = new int[2];
                result[0] = inputIndexMap.get(requiredNumber) + 1;
                result[1] = loopIndex + 1;
                break;
            }
            if(!inputIndexMap.containsKey(inputArray[loopIndex])){
                inputIndexMap.put(inputArray[loopIndex], loopIndex);
            }

        }
        if(result == null){
            result = new int[0];
        }
        return result;
    }
}