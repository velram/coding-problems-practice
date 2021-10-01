package com.coding.practice.bit.manipulation;

/**
 * @author : Velmurugan Moorthy
 * @date : 01/10/2021
 * Problem name : Single Number II
 *
 * Problem Description
 *
 * Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 *
Problem Constraints

2 <= A <= 5*106

0 <= A <= INTMAX



Input Format

First and only argument of input contains an integer array A.


Output Format

Return a single integer.


Example Input

Input 1:

A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]

Input 2:

A = [0, 0, 0, 1]



Example Output

Output 1:

4

Output 2:

1



Example Explanation

Explanation 1:

4 occurs exactly once in Input 1.
1 occurs exactly once in Input 2.
 */
public class UniqueNumberDriverV2 {
    public static void main(String[] args) {

        int[] input = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};//Test case#1 - Happy flow
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#

        UniqueAmongThreeDupesFinder uniqueAmongThreeDupesFinder = new UniqueAmongThreeDupesFinder();
        int uniqueNumber = uniqueAmongThreeDupesFinder.findUniqueNumber(input);

        System.out.println("unique number is : " + uniqueNumber);
    }
}

/**
 * Approach :
 *  1. Find setbits of all input numbers in the array
 *  2. If the setBitCount is odd then answer's ith bit should be 1. else, leave as it is (i.e., 0).
 *
 *  How to count setBits :
 *  1. Do a right of the number till ith bit then, perform and operation on that.
 *  2. If the and operation returns '1' it's a setBit
 *  3. if it's a setBit increment the count of setBits
 */
class UniqueAmongThreeDupesFinder {

    public int findUniqueNumber(final int[] input){

        int uniqueNumber = 0;

        for(int bitIndex = 0; bitIndex < 32; bitIndex++){
            int setBitCount = 0;
            for(int arrayIndex = 0; arrayIndex < input.length; arrayIndex++){
                if(((input[arrayIndex] >> bitIndex) & 1) == 1){
                    setBitCount++;
                }
            }
//            System.out.println("setBit at bitIndex : " + bitIndex + " is : " + setBitCount);
            if(setBitCount % 3 == 1){
                uniqueNumber = (uniqueNumber | (1 << bitIndex));
            }
        }

        return uniqueNumber;
    }

}