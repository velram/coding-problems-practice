package com.scaler.practice.array;

/**
 * Problem statement :
 * You are given an array of integers A of size N.
 * Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
 *
 * Sample input :
 * Input :   A = [0, 2, 9] || Output : -7
 * Input :  A = [5, 17, 100, 1] || Output : 99
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Maximum of all even numbers = 2
 * Minimum of all odd numbers = 9
 * ans = 2 - 9 = -7
 *
 * Explanation 2:
 *
 * Maximum of all even numbers = 100
 * Minimum of all odd numbers = 1
 * ans = 100 - 1 = 99
 *
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DifferenceCalculatorDriver {
    public static void main(String[] args) {

        int[] inputs = {5, 17, 100, 1}; //Test#1  Sample input from question - PASS
        //int[] inputs = {0, 2, 9}; //Test#2  Sample input from question - PASS
        //int[] inputs = {1, 2}; //Test#3  only 2 inputs (odd & even - one input respectively) - PASS
        //int[] inputs = {1, 2}; //Test#4  only 2 inputs (odd & even - one input respectively) -
        //int[] inputs = {2, 3}; //Test#5  even less than odd i.e., difference is negative - PASS
        //int[] inputs = {-2, -3}; //Test#6  Inputs -> Negative integers only - PASS
        DifferenceCalculator differenceCalculator = new DifferenceCalculator();
        differenceCalculator.findDifference(inputs);
    }
}

class DifferenceCalculator {
    public int findDifference(int[] inputs){

        int difference = 0;
        int inputSize = inputs.length;
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for(int loopIndex = 0; loopIndex < inputSize; loopIndex++) {
            if(inputs[loopIndex] % 2 == 0){
                evenNumbers.add(inputs[loopIndex]);
            }
            else {
                oddNumbers.add(inputs[loopIndex]);
            }
        }

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);

//        System.out.println("Max even number : " + evenNumbers.get(evenNumbers.size() - 1));
//        System.out.println("Min odd number : " + oddNumbers.get(0));
        difference = evenNumbers.get(evenNumbers.size() - 1) - oddNumbers.get(0);
//        System.out.println("Difference : " + difference);
        return difference;
    }
}
