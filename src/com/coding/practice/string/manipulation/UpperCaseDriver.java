package com.coding.practice.string.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date : 11.08.2021
 *
 * Problem statement : toupper()
 *
 * Problem Description
 *
 * You are given a function to_upper() consisting of a character array A.
 *
 * Convert each charater of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
 * The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
 *
 * Return the uppercase version of the given character array.
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
 * Return the uppercase version of the given character array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
 *
 * Input 2:
 *
 *  A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']
 *
 * Output 2:
 *
 *  ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  All the characters in the returned array are in uppercase alphabets.
 */
public class UpperCaseDriver {
    public static void main(String[] args) {

        char[] input = {'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'};
        UpperCaseTools upperCaseTools = new UpperCaseTools();
        char[] result = upperCaseTools.toUpper(input);
        String resultString = new String(result);
        System.out.println("Result string : " + resultString);
    }
}

class UpperCaseTools{
    public char[] toUpper(char[] input){

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            boolean isLower = input[loopIndex] >= 'a' && input[loopIndex] <= 'z';
            if(isLower){
                int lowerCaseIntValue = input[loopIndex] - 32;
                input[loopIndex] = (char) lowerCaseIntValue;
            }
        }
        return input;
    }
}
