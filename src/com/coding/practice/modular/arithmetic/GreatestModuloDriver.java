package com.coding.practice.modular.arithmetic;

/**
 * @author : Velmurugan Moorthy
 * @date : 22/09/2021
 * Problem name : Greatest Modulo
 *
 *
A, B and Modulo

Problem Description

Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.


Problem Constraints

1 <= A, B <= 109
A != B


Input Format

The first argument given is the integer, A.
The second argument given is the integer, B.


Output Format

Return an integer denoting greatest possible positive M.


Example Input

Input 1:

A = 1
B = 2

Input 2:

A = 5
B = 10



Example Output

Output 1:

1

Output 2:

5



Example Explanation

Explanation 1:

1 is the largest value of M such that A % M == B % M.

Explanation 2:

For M = 5, A % M = 0 and B % M = 0.

No value greater than M = 5, satisfies the condition.
 */
public class GreatestModuloDriver {
    public static void main(String[] args) {

        //Test case #1 - Happy flow - PASS
//        int firstInteger = 5;
//        int secondInteger = 10;

        //Test case #2
       // int firstInteger = 1;
        //int secondInteger = 2;

        int firstInteger = 8309642;
        int secondInteger = 5095206;

        GreatestModuloFinder greatestModuloFinder = new GreatestModuloFinder();
        int greatestFactor = greatestModuloFinder.solve(firstInteger, secondInteger);

        System.out.println("Greatest factor is : " + greatestFactor);

    }
}

class GreatestModuloFinder{
    public int solve(int firstInteger, int secondInteger) {

        int greatestModulo = Integer.MIN_VALUE;
        int difference = (firstInteger > secondInteger) ? (firstInteger - secondInteger) : secondInteger - firstInteger;

        return difference;

        /*
         This approach is time consuming

        if(difference == 1){
            return difference;
        }

        for(int loopIndex = 2; loopIndex <= difference; loopIndex++){
            if(difference % loopIndex == 0){
                int factor = (difference / loopIndex);
                int greaterFactor = Math.max(factor, loopIndex);
                greatestModulo = Math.max(greatestModulo, greaterFactor);
            }
        }
        //System.out.println("Greatest modulo : " + greatestModulo);
        return greatestModulo;
         */
    }
}
