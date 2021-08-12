package com.coding.practice.string.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 11.08.2021
 *
 *
 * Problem name :
Isalpha()

Problem Description

You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.



Problem Constraints

1 <= |A| <= 105


Input Format

Only argument is a character array A.


Output Format

Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.


Example Input

Input 1:

A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']

Input 2:

A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']



Example Output

Output 1:

1

Output 2:

0



Example Explanation

Explanation 1:

All the characters are alphabets.

Explanation 2:

All the characters are NOT alphabets i.e ('#', '2', '0', '2', '0').
 *
 */
public class AlphabetDriver {
    public static void main(String[] args) {
//        char[] input = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};//Test case #1 - sample input from question - PASS
        char[] input = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};//Test case # -
//        char[] input = {};//Test case # -
//        char[] input = {};//Test case # -
//        char[] input = {};//Test case # -
//        char[] input = {};//Test case # -
//        char[] input = {};//Test case # -


        AlphabetTools alphabetTools = new AlphabetTools();
        int isAlphabet = alphabetTools.isAlpha(input);
        System.out.println("Given string has only alphabets : " + isAlphabet);
    }
}

/**
 * Approach :
 * 1. Iterate thru array
 * 2. Check for alphabet between (a-z) or (A-Z)
 * 3. If yes continue. Else, break loop & return false.
 */
class AlphabetTools {
    public int isAlpha(char[] input) {

        int length = input.length;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            boolean isLower = input[loopIndex] >= 'a' && input[loopIndex] <= 'z';
            boolean isUpper = input[loopIndex] >= 'A' && input[loopIndex] <= 'Z';
            if(isLower || isUpper){
                continue;
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}