package com.coding.practice.maths.gcd;

/**
 * @author : Velmurugan Moorthy
 * @date : 25/09/2021
 * Problem name : Delete one
 *
 * Problem Description
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the maximum value of GCD.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [12, 15, 18]
 *
 * Input 2:
 *
 *  A = [5, 15, 30]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  6
 *
 * Output 2:
 *
 *  15
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 *  If you delete 12, gcd will be 3.
 *  If you delete 15, gcd will be 6.
 *  If you delete 18, gcd will 3.
 *  Maximum vallue of gcd is 6.
 *
 * Explanation 2:
 *
 *  If you delete 5, gcd will be 15.
 *  If you delete 15, gcd will be 5.
 *  If you delete 30, gcd will be 5.
 */
public class MaxGCDDriver {
    public static void main(String[] args) {

//        int[] input = {12, 15, 18};//Test case #1 Happy flow - PASS
//        int[] input = {1,2,3,4,5,6,7};//Test case #2 - PASS
        int[] input = {5, 15, 30};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #

        MaxGCDTools maxGCDTools = new MaxGCDTools();
        int maxGCD = maxGCDTools.solve(input);
        System.out.println("maxGCD : " + maxGCD);

    }
}

/**
 * Approach :
 *
 * 1. Find prefixGCD
 * 2. Find suffixGCD
 * 3. Find gcd of prefix & suffix GCD arrays
 */
class MaxGCDTools {
    public int solve(int[] input) {

        int length = input.length;

        if(length == 1){
            return input[0];
        }

        if(length == 2){
            return Math.max(input[0], input[1]);
        }

        int[] prefixGCD = findPrefixGCD(input);
        int[] suffixGCD = findSuffixGCD(input);
        int maxGCD = suffixGCD[1];

        for(int loopIndex = 1; loopIndex < length -1; loopIndex++){
            maxGCD = Math.max(maxGCD, findGCD(prefixGCD[loopIndex - 1], suffixGCD[loopIndex+1]));
        }

        return maxGCD;
    }

    public int[] findPrefixGCD(int[] input){
        int length = input.length;
        int[] prefixGCD = new int[length];

        prefixGCD[0] = input[0];
        for(int loopIndex = 1; loopIndex < length; loopIndex++){
            prefixGCD[loopIndex] = findGCD(prefixGCD[loopIndex-1], input[loopIndex]);
            //System.out.println(" prefixGCD[loopIndex] : " +  prefixGCD[loopIndex]);
        }

        return prefixGCD;
    }

    public int[] findSuffixGCD(int[] input){

        int length = input.length;
        int[] suffixGCD = new int[length];

        suffixGCD[length - 1] = input[length - 1];

        for(int loopIndex = length - 2; loopIndex >= 0; loopIndex--){
            suffixGCD[loopIndex] = findGCD(suffixGCD[loopIndex+1], input[loopIndex]);
        }

        return suffixGCD;
    }

    public int findGCD(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return firstNumber;
        }
        return findGCD(secondNumber, firstNumber % secondNumber);
    }
}