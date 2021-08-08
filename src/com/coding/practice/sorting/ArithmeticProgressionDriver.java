package com.coding.practice.sorting;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 08.08.2021
 *
 * Problem name :  Arithmetic Progression?
 *
 * Problem Description
 *
 * Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
 *
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 *
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A of size N.
 *
 *
 * Output Format
 *
 * Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 5, 1]
 *
 * Input 2:
 *
 *  A = [2, 4, 1]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  1
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
 *  We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 *
 * Explanation 2:
 *
 *  There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class ArithmeticProgressionDriver {
    public static void main(String[] args) {

        int[] input = {3, 1, 5};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#


        ArithmeticProgressionTools arithmeticProgressionTools = new ArithmeticProgressionTools();
        int isArithmeticProgression = arithmeticProgressionTools.isValidArithmeticProgression(input);
        System.out.println("A.P exists : " + isArithmeticProgression);
    }
}

class ArithmeticProgressionTools {

    public int isValidArithmeticProgression(int[] input) {

        int length = input.length;

        if(length == 2){
            return 1;
        }

        //Find top 2 min elements :
        int[] firstTwoElements = findFirstTwoElements(input);

        if(Integer.MAX_VALUE == firstTwoElements[0] || Integer.MAX_VALUE == firstTwoElements[1]){
            return 0;
        }

        Arrays.sort(input);

        int difference = firstTwoElements[1] - firstTwoElements[0];

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            if(loopIndex == 0 &&  input[loopIndex] == firstTwoElements[0]){
                    continue;
            }

            else if(loopIndex == 1 && input[loopIndex] == firstTwoElements[1]){
                continue;
            }

            else if(input[loopIndex] != firstTwoElements[0] + ((loopIndex) * difference)){
                return 0;
            }

        }


        return 1;
    }

    private int[] findFirstTwoElements(int[] input) {

        int[] firstTwoElements = new int[2];
        int minimumElement = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < input.length ; loopIndex++){

            if(minimumElement > input[loopIndex]){
                minimumElement = input[loopIndex];
            }
        }
        firstTwoElements[0] = minimumElement;
        minimumElement = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            if(minimumElement > input[loopIndex] && input[loopIndex] != firstTwoElements[0]){
                minimumElement = input[loopIndex];
            }
        }
        firstTwoElements[1] = minimumElement;

        return firstTwoElements;
    }
}
