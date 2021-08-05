package com.scaler.practice.array;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 05.08.2021
 * Elements which have at-least two greater elements
 *
 * Problem Description
 *
 * You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.
 *
 * NOTE: The result should have the order in which they are present in the original array.
 *
 *
 *
 * Problem Constraints
 *
 * 3 <= |A| <= 105
 *
 * -109 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer array containing the elements of A which have at-least two greater elements than themselves in A.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *
 * Input 2:
 *
 *  A = [11, 17, 100, 5]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 2, 3]
 *
 * Output 2:
 *
 *  [11, 5]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Number of elements greater than 1: 4
 *  Number of elements greater than 2: 3
 *  Number of elements greater than 3: 2
 *  Number of elements greater than 4: 1
 *  Number of elements greater than 5: 0
 *  Elements 1, 2 and 3 have atleast 2 elements strictly greater than themselves.
 *
 * Explanation 2:
 *
 *  Number of elements greater than 11: 2
 *  Number of elements greater than 17: 1
 *  Number of elements greater than 100: 0
 *  Number of elements greater than 5: 3
 *  Elements 5 and 11 have atleast 2 elements strictly greater than themselves.
 */
public class TopTwoElementsDriver {
    public static void main(String[] args) {

        //int[] input = {1, 2, 3, 4, 5};//Testcase #1 - sample input from question - PASS
        //int[] input = {11, 17, 100, 5}; //Testcase #2 - sample input from question - PASS
        int[] input = {1000000, 939938, 1 , 2}; //Testcase #
        //int[] input = {}; //Testcase #
        //int[] input = {}; //Testcase #
        //int[] input = {}; //Testcase #
        //int[] input = {}; //Testcase #
        //int[] input = {}; //Testcase #
        //int[] input = {}; //Testcase #
        MinimumElementsCounter minimumElementsCounter = new MinimumElementsCounter();
        int[] result = minimumElementsCounter.findMinimumElements(input);

        Arrays.stream(result).forEach(System.out::println);
    }
}

class MinimumElementsCounter {
    public int[] findMinimumElements(int[] input){

        int[] topTwoElements = findTopTwoElements(input);
        int[] result = new int[input.length - 2];
        int resultIndex = 0;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++) {
            if(input[loopIndex] != topTwoElements[0] && input[loopIndex] != topTwoElements[1]){
                result[resultIndex++] = input[loopIndex];
            }
        }


        return result;
    }

    private int[] findTopTwoElements(int[] input) {

        int[] topTwoElements = new int[2];
        int firstElement = Integer.MIN_VALUE;
        int secondElement = Integer.MIN_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++) {
            if(firstElement < input[loopIndex]){
                firstElement = input[loopIndex];
            }
        }

        for(int loopIndex = 0; loopIndex < input.length ; loopIndex++){
            if(input[loopIndex] != firstElement && secondElement < input[loopIndex]) {
                secondElement = input[loopIndex];
            }
        }

        topTwoElements[0] = firstElement;
        topTwoElements[1] = secondElement;

        return topTwoElements;
    }
}
