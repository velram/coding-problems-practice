package com.coding.practice.bit.manipulation;

/**
 * @author : Velmurugan Moorthy
 * @date : 11/09/2021
 *
 * Problem name : Bulbs
 *
 * Problem Description
 *
 * N light bulbs are connected by a wire.
 *
 * Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
 *
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 *
 * You can press the same switch multiple times.
 *
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 5*105
 * 0 <= A[i] <= 1
 *
 *
 * Input Format
 *
 * The first and the only argument contains an integer array A, of size N.
 *
 *
 * Output Format
 *
 * Return an integer representing the minimum number of switches required.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [0, 1, 0, 1]
 *
 * Input 2:
 *
 *  A = [1, 1, 1, 1]
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
 *  0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  press switch 0 : [1 0 1 0]
 *  press switch 1 : [1 1 0 1]
 *  press switch 2 : [1 1 1 0]
 *  press switch 3 : [1 1 1 1]
 *
 * Explanation 2:
 *
 *  There is no need to turn any switches as all the bulbs are already on.
 */
public class BulbDriver {
    public static void main(String[] args) {

//        int[] input = {1,0,0,0};//Test case#1 Happy flow - PASS
//        int[] input = {0,1,0,1};//Test case#2 - PASS
//        int[] input = {1,1,1,1};//Test case#3 - PASS
//        int[] input = {0,0,0,0};//Test case#4 - PASS
//        int[] input = {1,0,1,0,1,0};//Test case#5 - PASS
//        int[] input = {0};//Test case #6 - PASS
//        int[] input = {1};//Test case #7 - PASS
//        int[] input = {1,1,1,1,1,1,0};//Test case #8 - PASS
//        int[] input = {0,0,0,0,0,0,0,1};//Test case #9 - PASS
//        int[] input = {0,0,0,0,1,0,0,1};//Test case #10 - PASS
          int[] input = {};

        BulbSwitchingTools bulbSwitchingTools = new BulbSwitchingTools();
        int minimalActionRequired = bulbSwitchingTools.findMinimalActionRequired(input);
        System.out.println("minimalActionRequired : " + minimalActionRequired);
    }
}

class BulbSwitchingTools {
    public int findMinimalActionRequired(int[] input){

        int counter = 0;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){

            if(input[loopIndex] == 0 && counter % 2 == 0){
                counter++;
            }
            else if(input[loopIndex] ==1 && counter % 2 != 0){
                counter++;
            }
        }

        //System.out.println("Counter is : " + counter);
        return counter;
    }
}