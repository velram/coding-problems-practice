package com.coding.practice.bit.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 07.08.2021
 *
 *  Count Total Set Bits
 *
 * Problem Description
 *
 * Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
 *
 * Return the count modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 109
 *
 *
 * Input Format
 *
 * First and only argument is an integer A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *
 * Input 2:
 *
 *  A = 1
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 *
 * Output 2:
 *
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *     2          10        1
 *     3          11        2
 *  1 + 1 + 2 = 4
 *  Answer = 4 % 1000000007 = 4
 *
 * Explanation 2:
 *
 *  A = 1
 *   DECIMAL    BINARY  SET BIT COUNT
 *     1          01        1
 *  Answer = 1 % 1000000007 = 1
 */
public class DecimalEquivalentDriver {
    public static void main(String[] args) {

//        int input = 3; //Test case #1 Sample input from question - PASS
//        int input = 1;//Test case #2 Sample input from question - PASS
//        int input = 10;//Test case #3 Even number - PASS
//        int input = 100000000;//Test case #4 Upper limit value -
        int input = 15;//Test case #5 Odd number - PASS
//        int input = 1;//Test case #
        DecimalEquivalentSetBitCounter decimalEquivalentSetBitCounter = new DecimalEquivalentSetBitCounter();
        int setBitCount = decimalEquivalentSetBitCounter.countDecimalEquivalentSetBits(input);
        System.out.println("Sum of Set bit count for number : " + input + " : " + setBitCount);
    }
}

/**
 * Approach use right shift 'i' times
 */
class DecimalEquivalentSetBitCounter {
    public int countDecimalEquivalentSetBits(int input){

        int setBitCount = 0;

        for(int bitIndex = 0; bitIndex < 32 ; bitIndex++){
            for(int currentNumber = 1; currentNumber <= input; currentNumber++){
                if( ((currentNumber >> bitIndex) & 1) == 1) {
                    setBitCount++;
                }
            }
        }

        //System.out.println("setBitCount : " + setBitCount);

        return setBitCount;
    }
}