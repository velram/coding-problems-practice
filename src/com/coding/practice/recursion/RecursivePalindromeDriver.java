package com.coding.practice.recursion;

/**
 * @author Velmurugan Moorthy
 * @date 14.08.2021
 *
 * Problem name : Check Palindrome
 *
 * Problem Description
 *
 * Write a recursive function that checks whether a string A is a palindrome or Not.
 * Return 1 if the string A is palindrome, else return 0.
 *
 * Note: A palindrome is a string that's the same when reads forwards and backwards.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 50000
 *
 * String A consist only of lowercase letters.
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
 * Return 1 if the string A is palindrome, else return 0.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "naman"
 *
 * Input 2:
 *
 *  A = "strings"
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
 *  "naman" is a palindomic string, so return 1.
 *
 * Explanation 2:
 *
 *  "strings" is not a palindrome, so return 0.
 */
public class RecursivePalindromeDriver {
    public static void main(String[] args) {

//        String input = "strings"; //Test case #1 Sample input from question - PASS
//        String input = "abcdeedcba"; //Test case #2 Palindrome (even sized) - PASS
//        String input = "abcdedcba"; //Test case #3 Palindrome (odd sized) - PASS
//        String input = "a"; //Test case #4 single char string - PASS
//        String input = "abcdecba"; //Test case #5 Non palindrome (even size)
        String input = "abcdba"; //Test case #6 Non-palindrome (odd size)- PASS
//        String input = ""; //Test case #
//        String input = ""; //Test case #
//        String input = ""; //Test case #
        RecursivePalindromeTools recursivePalindromeTools = new RecursivePalindromeTools();
        boolean isPalindrome = recursivePalindromeTools.isPalindrome(input);

        System.out.println("Given string is a palindrome : " + isPalindrome);
    }
}

class RecursivePalindromeTools {
    public boolean isPalindrome(String input){

        return isPalindrome(input, 0, input.length() - 1);
    }

    public boolean isPalindrome(String input, int start, int end){

        if(start >= end){ //Base condition
            return true;
        }

        if(input.charAt(start) == input.charAt(end)){
            return  isPalindrome(input, start + 1, end - 1);
        }

        return false;
    }
}
