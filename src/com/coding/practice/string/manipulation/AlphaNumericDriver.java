package com.coding.practice.string.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 12.08.2021
 *
 * Problem name : Isalnum()
 *
 * Problem Description
 *
 * You are given a function isalpha() consisting of a character array A.
 *
 * Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 *
 * Input Format
 *
 * Only argument is a character array A.
 *
 *
 * Output Format
 *
 * Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
 *
 * Input 2:
 *
 *  A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
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
 *  All the characters are alphanumeric.
 *
 * Explanation 2:
 *
 *  All the characters are NOT alphabets i.e ('#').
 */
public class AlphaNumericDriver {
    public static void main(String[] args) {

//        char[] input = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};//Test case #1 Sample input from question
        char[] input = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};//Test case #2 Sample input from question
        AlphaNumericTools alphaNumericTools = new AlphaNumericTools();
        int result = alphaNumericTools.isAlphaNumeric(input);
        System.out.println("Input is alphaNumeric : " + result);
    }
}

class AlphaNumericTools{
    public int isAlphaNumeric(char[] input){

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            boolean isLowerCase = input[loopIndex] >= 'a' && input[loopIndex] <= 'z';
            boolean isUpperCase = input[loopIndex] >= 'A' && input[loopIndex] <= 'Z';
            boolean isNumeric = input[loopIndex] >= '0' && input[loopIndex] <= '9';

            if( !(isLowerCase || isUpperCase || isNumeric)){
                return 0;
            }
        }

        return 1;
    }
}