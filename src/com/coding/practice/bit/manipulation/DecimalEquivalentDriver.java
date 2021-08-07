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

class DecimalEquivalentSetBitCounter {
    public int countDecimalEquivalentSetBits(int input){

        if(input == 1 || input == 2){
            return 1;
        }

        input += 1;

        int setBitCount = 0;
        int loopIndex = 1;

        while(loopIndex <= input){

            if(loopIndex == 1){
                setBitCount += (input / 2);
            }
            else {

                int twoPowerI = (int) Math.pow(2, loopIndex);
                int twoPowerIMinusOne = (int) Math.pow(2, loopIndex  - 1);
                int remainingBitCount =  (input % twoPowerI)  -  twoPowerIMinusOne;
                int groupBitCount = (input / twoPowerI) * (twoPowerIMinusOne);

                if(remainingBitCount < 0){
                    setBitCount += groupBitCount;
                }
                else {
                    setBitCount += (groupBitCount + remainingBitCount);
                }
            }
            loopIndex++;
        }

        return setBitCount % (1000000009);
    }

}