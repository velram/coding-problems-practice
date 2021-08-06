package com.scaler.practice.array;

/**
 *
 * @author Velmurugan
 * @date 05.08.2021
 *
 * Special Subsequences "AG"
 *
 * Problem Description
 *
 * You have given a string A having Uppercase English letters.
 *
 * You have to find that how many times subsequence "AG" is there in the given string.
 *
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length(A) <= 105
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the answer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "ABCGAG"
 *
 * Input 2:
 *
 *  A = "GAB"
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  3
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
 *  Subsequence "AG" is 3 times in given string
 *
 * Explanation 2:
 *
 *  There is no subsequence "AG" in the given string.
 *
 *
 */
public class SpecialSequenceDriver {
    public static void main(String[] args) {

//        String input = "ABCGAG";//Test case #1 - Sample input in question - PASS
//        String input = "A";//Test case #2- One char string- PASS
//        String input = "GAB";//Test case #3 - No subsequence found - PASS
        String input = "AGAGAGAGAGAG";//Test case #All elements are pairs - PASS
        //String input = "";//Test case #
        //String input = "";//Test case #
        //String input = "";//Test case #

        SubsequenceCounter subsequenceCounter = new SubsequenceCounter();
        int subSequenceCount = subsequenceCounter.countSubsequence(input);
        System.out.println("Subsequence count : " + subSequenceCount);

    }
}

class SubsequenceCounter {
    public int countSubsequence(String input) {

        if(input.length() < 2){
            return 0;
        }

        if(input.length() == 2 && input.charAt(0) != 'A') {
            return 0;
        }

        int subsequenceCount = 0;

        for(int loopIndex = 0; loopIndex < input.length(); loopIndex++){
            if(input.charAt(loopIndex) == 'A'){
                int secondCharIndex = loopIndex + 1;
                while(secondCharIndex < input.length()){
                    if(input.charAt(secondCharIndex) == 'G'){
                     subsequenceCount++;
                    }
                    secondCharIndex++;
                }
            }
        }

        return subsequenceCount;
    }
}
