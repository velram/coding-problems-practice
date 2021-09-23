package com.coding.practice.bit.manipulation;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 21/09/2021
 * Problem name : Flip
 * Question URL : https://www.interviewbit.com/problems/flip/
 *
 * Problem Description :
 *
 * You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 */
public class FlipBitsDriver {
    public static void main(String[] args) {

        String inputString = "0001110111";

        FlipBitTools flipBitTools = new FlipBitTools();
        flipBitTools.flip(inputString);
    }
}

/**
 * Approach :
 *  1. Change values as -1, 1
 *  2. Find max sum of contiguous array
 *  3. Keep track of the indices
 */
class FlipBitTools{
    public int[] flip(String inputString) {

        int[] inputElements = prepareIntegerArray(inputString);

        int[] maxSubArrayIndices = new int[2];
        maxSubArrayIndices = findMaxSubArrayIndices(inputElements);

        return inputElements;
    }

    private int[] findMaxSubArrayIndices(int[] inputArray) {

        int length = inputArray.length;
        int[] maxSubArrayIndices = new int[2];

        updateArray(inputArray);

        Arrays.stream(inputArray).forEach(element -> System.out.println(element));

        int startIndex = 0;
        int endIndex = 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            currentSum+= inputArray[loopIndex];
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum < 0){
                currentSum = 0;
                startIndex = loopIndex + 1;
                endIndex = loopIndex + 1;
            }
            endIndex++;
        }
        System.out.println(" max sum is : " + maxSum);
        System.out.println("startIndex : " + startIndex + " endIndex : " + endIndex);
        return maxSubArrayIndices;
    }

    private void updateArray(int[] inputArray) {

        for(int loopIndex = 0; loopIndex < inputArray.length; loopIndex++){
            if(inputArray[loopIndex] == 0){
                inputArray[loopIndex] = 1;
            }
            else {
                inputArray[loopIndex] = -1;
            }
        }

    }

    public int[] prepareIntegerArray(String inputStr){
        int length = inputStr.length();
        int[] inputBits = new int[length];

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            inputBits[loopIndex] = Character.getNumericValue(inputStr.charAt(loopIndex));
        }
        //Arrays.stream(inputBits).forEach(element -> System.out.println(element));
        return inputBits;
    }

}