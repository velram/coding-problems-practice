package com.scaler.practice.array;

/**
 * @author Velmurugan Moorthy
 * @date 06.08.2021
 * Odd Even Subsequences
 *
 * Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.
 *
 * A subsequence is said to odd-even in the following cases:
 *
 *     The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
 *
 *     The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
 *
 * Return the maximum possible length of odd-even subsequence.
 *
 * Note: An array B is a subsequence of an array A if B can be obtained from A by deletion of several (possibly, zero or all) elements.
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 * Output Format
 *
 * Return the maximum possible length of odd-even subsequence.
 *
 * Constraints
 *
 * 1 <= N <= 100000
 * 1 <= A[i] <= 10^9
 *
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 2, 5, 6]
 * Output 1:
 *     4
 *     Explanation 1:
 *         Maximum length odd even subsequence is [1, 2, 5, 6]
 *
 * Input 2:
 *     A = [2, 2, 2, 2, 2, 2]
 * Output 2:
 *     1
 *     Explanation 2:
 *         Maximum length odd even subsequence is [2]
 */
public class OddEvenSubsequenceDriver {
    public static void main(String[] args) {

        //int[] input = {1, 2, 2, 5, 6};//Test case #1 - sample input from question - PASS
        //int[] input = {2,2,2,2,2,2};//Test case #2 - Sample input form question - PASS
        //int[] input = {3};//Test case #Test case #3 - single element (only odd) - PASS
        //int[] input = {2};//Test case #4 - Single element - only even - PASS
        //int[] input = {3,3,3,3,3,3,3,3,3};//Test case #5 - all odd - PASS
        //int[] input = {2,2,2,2,2,2,2,2,2,3};//Test case #6 all even, single odd at last - PASS
        int[] input = {1,1,1,1,1,1,1,1,1,1,2};//Test case #7 All odd, single event at last - PASS
        //2, 2, 2, 2, 2, 2

        OddEvenSubsequenceFinder oddEvenSubsequenceDriver = new OddEvenSubsequenceFinder();
        int oddEvenSubsequenceCount = oddEvenSubsequenceDriver.findOddEvenSubsequence(input);
        System.out.println("Odd Even Subsequence count : " + oddEvenSubsequenceCount);
    }
}

class OddEvenSubsequenceFinder {
    public int findOddEvenSubsequence(int[] inputArray){

        if(inputArray.length == 1){
            return 1;
        }

        int oddEvenSubsequenceCount = 1;
        int firstElement = inputArray[0];
        boolean isFirstEven = isEven(firstElement);
        boolean isNextEven = !isFirstEven;



        for(int loopIndex = 1; loopIndex < inputArray.length ; loopIndex++){

           if(isNextEven && isEven(inputArray[loopIndex])){
             oddEvenSubsequenceCount++;
             isNextEven = !isNextEven;
           }
           else if(!isNextEven && !isEven(inputArray[loopIndex])){
               oddEvenSubsequenceCount++;
               isNextEven = !isNextEven;
           }
        }

        return oddEvenSubsequenceCount;
    }

    public boolean isEven(int input){
        return (input % 2 == 0);
    }
}