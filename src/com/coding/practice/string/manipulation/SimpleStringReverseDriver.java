package com.coding.practice.string.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 13.08.2021
 * Problem name : Simple Reverse
 *
 * Problem Description
 *
 * Given a string A, you are asked to reverse the string and return the reversed string.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * String A consist only of lowercase characters.
 *
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 * Output Format
 *
 * Return a string denoting the reversed string.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "scaler"
 *
 * Input 2:
 *
 *  A = "academy"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "relacs"
 *
 * Output 2:
 *
 *  "ymedaca"
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Reverse the given string.
 */
public class SimpleStringReverseDriver {
    public static void main(String[] args) {

//        String input = "academy";//Test case #1 Sample input from question - PASS
//        String input = "abcdefghijk";//Test case #2 odd length string - PASS
        String input = "abcdefghij";//Test case #Test case #3 even length string
//        String input = "";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #

        SimpleStringReverseTools simpleStringReverseTools = new SimpleStringReverseTools();
        String result = simpleStringReverseTools.reverseString(input);
        System.out.println("Reversed string : " + result);
    }
}

class SimpleStringReverseTools {
    public String reverseString(String input){

        if(input.length() <= 1){
            return input;
        }

       char[] inputChars = input.toCharArray();
       String result = new String();

       int start = 0;
       int end = inputChars.length - 1;

       while(start <= end){
           char temp = inputChars[start];
           inputChars[start] = inputChars[end];
           inputChars[end] = temp;
           start++;
           end--;
       }

       result = new String(inputChars);

//        System.out.println("Reversed String is : " + result);
        return result;
    }
}
