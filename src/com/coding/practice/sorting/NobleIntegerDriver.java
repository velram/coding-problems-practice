package com.coding.practice.sorting;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Velmurugan Moorthy
 * @date 08.08.2021
 *
 * Problem description : Noble Integer
 *
 * Problem Description
 *
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return 1 if any such integer p is found else return -1.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [3, 2, 1, 3]
 *
 * Input 2:
 *
 *  A = [1, 1, 3, 3]
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
 *  -1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For integer 2, there are 2 greater elements in the array. So, return 1.
 *
 * Explanation 2:
 *
 *  There is no such integer exists.
 */
public class NobleIntegerDriver {
    public static void main(String[] args) {

//        int[] input = {3, 2, 1, 3}; //Test case #1 - Sample input from question - PASS
//        int[] input = {1, 1, 3, 3}; //Test case #2 Sample input from question - PASS
//        int[] input = {5, 6, 2}; //Test case #3 Trivial test case - PASS
          int[] input = {-4, -2, 0, -1, -6}; //Test case #4 - corner case

        NobleIntegerTools nobleIntegerTools = new NobleIntegerTools();
        int nobleIntegerExists = nobleIntegerTools.isNobleInteger(input);
        System.out.println("Noble Integer exists : " + nobleIntegerExists);
    }
}

/*
 * Approach :
 * 1. Find the minimum element in the array
 * 2. Check the minimumElement == (greater elements size)
 * 3. If yes return the number
 *
 * Edge cases :
 * 1. Duplicates
 * 2. No noble integer in array
 * 3. All zeros
 * 4. All ones
 */
class NobleIntegerTools{
    public int isNobleInteger(int[] input){
        int length = input.length;
        if(length == 1){
            return input[0] == 0 ? 1 : -1;
        }

        int nobleIntegerExists = -1;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            int[] smallestElementAndIndex = findSmallestElement(input, loopIndex);
            int smallestElement = smallestElementAndIndex[0];
            int oldIndex = smallestElementAndIndex[1];
            if(smallestElement == Integer.MAX_VALUE || oldIndex == -1){
                return nobleIntegerExists;
            }
            if(input[loopIndex] == smallestElement){
                continue;
            }
            int temp = input[loopIndex];
            input[loopIndex] = smallestElement;
            input[oldIndex] = temp;

        }

        for(int loopIndex = 0; loopIndex <= length - 1; loopIndex++){

            if(loopIndex == length -1){
                return input[loopIndex] == 0 ? 1 : -1;
            }

            if(input[loopIndex] == input[loopIndex+1]){
                continue;
            }
            if(input[loopIndex] ==  ((length - 1) -loopIndex)){
                return 1;
            }

        }

        return nobleIntegerExists;
    }

    private int[] findSmallestElement(int[] input, int startIndex){

        int[] smallestElementAndIndex = {Integer.MAX_VALUE, -1};

        for(int loopIndex = startIndex; loopIndex < input.length; loopIndex++){
            if(smallestElementAndIndex[0] > input[loopIndex]){
                smallestElementAndIndex[0] = input[loopIndex];
                smallestElementAndIndex[1] = loopIndex;
            }
        }

        return smallestElementAndIndex;
    }
}