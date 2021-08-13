package com.coding.practice.recursion;

/**
 * @author Velmurugan Moorthy
 * @date 13.08.2021
 *
 * Problem name : Find Fibonacci
 *
 * Problem Description
 *
 * The Fibonacci numbers are the numbers in the following integer sequence.
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 *
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
 *
 * Fn = Fn-1 + Fn-2
 *
 * Given a number A, find and return the Ath Fibonacci Number.
 *
 * Given that F0 = 0 and F1 = 1.
 *
 *
 *
 * Problem Constraints
 *
 * 0 <= A <= 20
 *
 *
 * Input Format
 *
 * First and only argument is an integer A.
 *
 *
 * Output Format
 *
 * Return an integer denoting the Ath term of the sequence.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 2
 *
 * Input 2:
 *
 *  A = 9
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
 *  34
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  f(2) = f(1) + f(0) = 1
 *
 * Explanation 2:
 *
 *  f(9) = f(8) + f(7) = 21 + 13  = 34
 */
public class FibonacciDriver {
    public static void main(String[] args) {

//        int input = 1; //Test case #1 - base case - PASS
//        int input = 0; //Test case #2 - base case - PASS
//        int input = 2; //Test case #3 - even number - PASS
//        int input = 3; //Test case #4 - odd number - PASS
//        int input = 5; //Test case #5 - odd number - PASS
        int input = 9; //Test case #6 - sample input from question
        FibonacciFinder fibonacciFinder = new FibonacciFinder();
        int fibonacciNumber = fibonacciFinder.findFibonacci(input);
        System.out.println("Fibonacci number is : " + fibonacciNumber);

    }
}

class FibonacciFinder {

    public int findFibonacci(int input){

        if (input == 0){
            return 0;
        }
        if(input == 1){
            return 1;
        }

        return findFibonacci(input - 1) + findFibonacci( input - 2);
    }
}
