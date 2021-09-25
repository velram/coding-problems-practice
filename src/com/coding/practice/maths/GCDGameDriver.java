package com.coding.practice.maths;

/**
 * @author : Velmurugan Moorthy
 * @date : 25/09/2021
 * Problem name : Pubg
 *
 * Problem Description
 *
 * There are N players each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game and the game continues in the same manner among other players until only 1 survivor remains.
 *
 * Can you tell the minimum health last surviving person can have?
 *
 *
 * Problem Constraints
 *
 *     1 <= N <= 100000
 *
 *     1 <= A[i] <= 1000000
 *
 *
 *
 * Input Format
 *
 * First and only argument of input contains a single integer array A.
 *
 *
 * Output Format
 *
 * Return a single integer denoting minimum health of last person.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [6, 4]
 *
 * Input 2:
 *
 *  A = [2, 3, 4]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
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
 *  Given strength array A = [6, 4]
 *  Second player attack first player, A =  [2, 4]
 *  First player attack second player twice. [2, 0]
 *
 * Explanation 2:
 *
 *  Given strength array A = [2, 3, 4]
 *  First player attack third player twice. [2, 3, 0]
 *  First player attack second player. [2, 1, 0]
 *  Second player attack first player twice. [0, 1, 0]
 */
public class GCDGameDriver {
    public static void main(String[] args) {

//        int[] input = {2, 3, 4};//Test #1 Happy flow
//         int[] input = {6, 4}; //Test case #2 Min elements
//         int[] input = {97}; //Test case #3 single element
         int[] input = {6, 12, 18, 24}; //Test case #4
        // int[] input = {}; //Test case #5
        // int[] input = {}; //Test case #

        GCDGameTools gcdGameTools = new GCDGameTools();
        int minimumHealth = gcdGameTools.findMinimumHealth(input);
        System.out.println("minimumHealth : " + minimumHealth);
    }
}

class GCDGameTools {
    public int findMinimumHealth(int[] input) {

        int length = input.length;

        if(length == 1){
            return input[0];
        }

        if(length == 2){
            return findGCD(input[0], input[1]);
        }

        int arrayGCD = findGCD(input[0], input[1]);

        for(int loopIndex = 2; loopIndex < length; loopIndex++){
            arrayGCD = findGCD(arrayGCD, input[loopIndex]);
        }

        //System.out.println("arrayGCD : " + arrayGCD);
      return arrayGCD;
    }

    public int findGCD(int firstNumber, int secondNumber){
        //System.out.println("firstNumber : " + firstNumber + " secondNumber : " + secondNumber);
        if(secondNumber == 0){
            return firstNumber;
        }
        return findGCD(secondNumber, firstNumber % secondNumber);
    }
}

