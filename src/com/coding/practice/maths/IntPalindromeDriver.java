package com.coding.practice.maths;

/**
 * @author Velmurugan Moorthy
 * @date 15.08.2021
 *
 * Problem description :  Palindrome Integer
 *
 * Problem Description
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.
 *
 * Example :
 *
 * Input : 12121
 * Output : True
 *
 * Input : 123
 * Output : False
 *
 */
public class IntPalindromeDriver {
    public static void main(String[] args) {

        //int input = Integer.MAX_VALUE;
        //int input = 147483647;
        //int input = 47483647;
        //int input = 7483647;
        //int input = 483647;
        //int input = 83647;
        //int input = 3647;
        //int input = 647;
        //int input = 47;
        //int input = 7;

//        int input = 0;//Test case #1 palindrome - lower limit - PASS
//        int input = 121121;//Test case #2 palindrome (even digit count) - PASS
//        int input = 12121;//Test case #3 palindrome (odd digit count) - PASS
//        int input = 1234567;//Test case #4 Non palindrome (odd digit count) - PASS
//        int input = 12345678;//Test case #5 Non palindrome (even digit count) - PASS
//        int input = -2147483648;//Test case #6 negative number - PASS
//        int input = 6;//Test case #7 Single digit - PASS
        int input =  2147447412;//Test case #8 Palindrome - Max possible even sized palindrome (in integer) - PASS;

        IntegerPalindromeTools integerPalindromeTools = new IntegerPalindromeTools();
        int digitCount = integerPalindromeTools.findDigitCount(input);
        System.out.println("digitCount is : " + digitCount);

        int palindromeExists = integerPalindromeTools.isPalindrome(input);
        System.out.println("PalindromeExists : " + palindromeExists);

    }
}

class IntegerPalindromeTools {
    public int isPalindrome(int input){

        //handleBaseCases
        if(input < 0){
            return 0;
        }

        if(input < 10){
            return 1;
        }

        int start = findDigitCount(input);
        int end = 0;

       while(start >= end){
            int msb = getDigit(input, start);
            int lsb = getDigit(input, end);

            if(msb != lsb){
                return 0;
            }
            start--;
            end++;
        }

        return 1;
    }

    private int getDigit(int input, int index) {

        int digit = 0;

        if(index == 9){
            return input / (int) Math.pow(10, 9);
        }

        if(index == 0){
            return  input % 10;
        }

        digit = (input % (int) Math.pow(10, index + 1)) / (int) Math.pow(10, index);

        return digit;
    }

    public int findDigitCount(int input){

        int digitCount = 9;

        while(digitCount > 0){
            if(input / (int) Math.pow(10, digitCount) > 0){
                return digitCount;
            }
            digitCount--;
        }
        //System.out.println("Digit count is : " + digitCount);
        return 0;
    }
}

