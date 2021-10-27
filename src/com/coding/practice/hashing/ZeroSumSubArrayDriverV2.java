package com.coding.practice.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Velmurugan Moorthy
 * @date : 27/10/2021
 * Problem name : Zero Sum - sub-array
 *
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1 else return 0.
 */
public class ZeroSumSubArrayDriverV2 {
    public static void main(String[] args) {

//        int[] inputArray = {1, 2, 3, -5, -1};//Test case #1 - Happy flow - PASS
//        int[] inputArray = {1, 2, 3, 4, 5};//Test case #2 No Zero sum sub-array - PASS
//        int[] inputArray = {1};//Test case #3 - single element array - no sub-array with zero sum - PASS
        int[] inputArray = {0};//Test case #4 - single element array - with zero sum sub-array -
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #

        ZeroSumSubArrayTools zeroSumSubArrayTools = new ZeroSumSubArrayTools();
        int zeroSumSubArrayExists = zeroSumSubArrayTools.isSubArraySumZero(inputArray);

        System.out.println("zeroSumSubArrayExists : " + zeroSumSubArrayExists);

    }
}

/**
 * Approach :
 *  1. Find prefix sum
 *  2. Traverse the prefix sum sub array
 *  3. Add each entry to the HashSet
 *  4. If there's duplicate element found then it's a zero sum sub-array
 *  5. return true (1).
 */
class ZeroSumSubArrayTools{
    public int isSubArraySumZero(int[] inputArray) {

        //TODO handle single element sub-array

        int inputSize = inputArray.length;
        if(inputSize == 1){
            return inputArray[0] == 0 ? 1 : 0;
        }

        int[] prefixSum = findPrefixSum(inputArray);
        int zeroSumSubArrayExists = isZeroSumSubArray(inputSize, prefixSum);

        return zeroSumSubArrayExists;
    }

    private int isZeroSumSubArray(int inputSize, int[] prefixSum) {

        int zeroSumSubArrayExists = 0;
        HashSet<Integer> prefixSumElements = new HashSet<>();

        for(int loopIndex = 0; loopIndex < inputSize; loopIndex++){

            //Edge case - if the prefixSum itself is '0' means the subArray sum is zero.
            if(prefixSum[loopIndex] == 0){
                zeroSumSubArrayExists = 1;
                break;
            }

            zeroSumSubArrayExists = containsZeroSumSubArray(prefixSum[loopIndex], prefixSumElements);
            if(zeroSumSubArrayExists == 1){
                break;
            }

        }
        return zeroSumSubArrayExists;
    }

    private int containsZeroSumSubArray(int prefixSumElement, Set<Integer> prefixSumSet) {

        if(prefixSumSet.contains(prefixSumElement)){
            return 1;
        }
        else {
            prefixSumSet.add(prefixSumElement);
        }
        return 0;
    }

    private int[] findPrefixSum(int[] inputArray) {

        int[] prefixSum = new int[inputArray.length];

        prefixSum[0] = inputArray[0];
        for(int loopIndex = 1; loopIndex < inputArray.length; loopIndex++){
            prefixSum[loopIndex] = prefixSum[loopIndex - 1] + inputArray[loopIndex];
        }

        return prefixSum;
    }
}
