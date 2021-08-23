package com.coding.practice.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *  @author Velmurugan Moorthy
 *  @date : 23.08.2021
 *
 *  Problem name :
 */
public class ZeroSumSubArrayDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 3, 4, 5};//Test case #1 - Sub array not exists - PASS
//        int[] input = {1,-1};//Test case #2 sub-array exists (just 2 elements) - PASS
//        int[] input = {0};//Test case #3 single element array & the element is zero - PASS
//        int[] input = {1,-1, 5, 7, 93, 64, 31, 108, 203};//Test case #4 - sub array at the end of input array - PASS
//        int[] input = {5, 7, 93, 64, 31, 108, 203, 1,-1};//Test case #5 - sub array at the end of input array - PASS
//        int[] input = {5, 7, 93, 64, -4, -2, 3, 3 };//Test case #6 - sub array at the middle of input array - PASS
        int[] input = {1,0,0,0,0,0,1};//Test case #7 - Multiple zeroes as array elements - PASS
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
        ZeroSumSubArrayFinder zeroSumSubArrayFinder = new ZeroSumSubArrayFinder();
        int zeroSumSubArrayExists = zeroSumSubArrayFinder.isZeroSumSubArray(input);
        System.out.println("Zero sum sub array : " + zeroSumSubArrayExists);
    }
}

class ZeroSumSubArrayFinder{

    public int isZeroSumSubArray(int[] input){

        Set<Long> prefixSumSet = new HashSet<>();
        long[] prefixSum = findPrefixSum(input);

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            if(prefixSum[loopIndex] == 0){
                return 1;
            }
            if(prefixSumSet.contains(prefixSum[loopIndex])){
                return 1;
            }
            else {
                prefixSumSet.add(prefixSum[loopIndex]);
            }
        }

        return 0;
    }

    public long[] findPrefixSum(int[] input){

        long[] prefixSum = new long[input.length];

        prefixSum[0] = input[0];
        for(int loopIndex = 1; loopIndex < input.length; loopIndex++){
            prefixSum[loopIndex] += (prefixSum[loopIndex - 1] + input[loopIndex]);
        }
        return prefixSum;
    }
}
