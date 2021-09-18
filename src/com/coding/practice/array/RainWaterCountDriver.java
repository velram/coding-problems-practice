package com.coding.practice.array;

/**
 * @author : Velmurugan Moorthy
 * @date : 18/09/2021
 * Problem name : Rain water trapping problem
 * Question URL : https://leetcode.com/problems/trapping-rain-water/
 * Description :
 * Problem Description

Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


Problem Constraints

1 <= |A| <= 100000


Input Format

First and only argument is the vector A


Output Format

Return one integer, the answer to the question


Example Input

Input 1:

A = [0, 1, 0, 2]

Input 2:

A = [1, 2]

Example Output
Output 1:

1

Output 2:

0

Example Explanation

Explanation 1:

1 unit is trapped on top of the 3rd element.

Explanation 2:

No water is trapped.

 */
public class RainWaterCountDriver {
    public static void main(String[] args) {

//        int[] input = {0, 1, 0, 2};//Test case #1 Happy flow - PASS
      int[] input = {1, 2};//Test case #2 No water trapped - PASS
//      int[] input = {};//Test case #

        RainWaterCountTools rainWaterCountTools = new RainWaterCountTools();
        int rainWaterCount = rainWaterCountTools.countRainWater(input);

        System.out.println("rainWaterCount : " + rainWaterCount);

    }
}

/**
 * Approach :
 *
 * 1. Find prefixMax
 * 2. Find suffixMax
 * 3. Find Min(prefixMax, suffixMax) for each element
 * 4. Find diff b/w a[i] & Min value from step #3
 */
class RainWaterCountTools{
    public int countRainWater(int[] input){

        int rainWaterCount = 0;
        int length = input.length;

        int[] prefixMax = findPrefixMax(input);
        int[] suffixMax = findSuffixMax(input);

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            int maxLeft = prefixMax[loopIndex];
            int maxRight = suffixMax[loopIndex];
            int possibleBuildingAndWaterHeight = Math.min(maxLeft, maxRight);
//            System.out.print(" MaxLeft : " + maxLeft);
//            System.out.print(" MaxRight : " + maxRight);
//            System.out.print(" possibleBuildingAndWaterHeight : " + possibleBuildingAndWaterHeight);
//            System.out.print(" building volume : " + input[loopIndex]);
//            System.out.println();
            rainWaterCount += (possibleBuildingAndWaterHeight - input[loopIndex]);
        }

        return rainWaterCount;
    }

    public int[] findPrefixMax(int[] input){
        int length = input.length;
        int[] prefixMax = new int[length];

        prefixMax[0] = input[0];
        for(int loopIndex = 1; loopIndex < length; loopIndex++){

            prefixMax[loopIndex] = Math.max(prefixMax[loopIndex-1], input[loopIndex]);
        }
        return prefixMax;
    }

    public int[] findSuffixMax(int[] input){
        int length = input.length;
        int[] suffixMax = new int[length];

        suffixMax[length-1] = input[length-1];
        for(int loopIndex = length-2; loopIndex >= 0 ; loopIndex-- ){
            suffixMax[loopIndex] = Math.max(suffixMax[loopIndex+1], input[loopIndex]);
        }
        return suffixMax;
    }

}
