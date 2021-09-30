package com.coding.practice.maths;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 28/09/2021
 * Problem name : Count of divisors
 *
 * Problem Description
 *
 * Given an array of integers A, find and return the count of divisors of each element of the array.
 *
 * NOTE: Order of the resultant array should be same as the input array.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 106
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 *
 * Output Format
 *
 * Return the count of divisors of each element of the array in the form of an array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [2, 3, 4, 5]
 *
 * Input 2:
 *
 *  A = [8, 9, 10]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [2, 2, 3, 2]
 *
 * Output 1:
 *
 *  [4, 3, 4]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 *  So the count will be [2, 2, 3, 2].
 *
 * Explanation 2:
 *
 *  The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 *  So the count will be [4, 3, 4].
 */
public class FactorCountDriver {
    public static void main(String[] args) {

//        int[] inputArray = {2, 3, 4, 5};//Test case #1 - pass
        int[] inputArray = {8, 9, 10};//Test case #2 - pass
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #

        FactorCountTool factorCountTool = new FactorCountTool();
        int[] factorCounts = factorCountTool.findFactorialCount(inputArray);

        Arrays.stream(factorCounts).forEach(factorCount -> System.out.print(factorCount + " "));

    }
}

/**
 * Approach :
 *  1. Run the loop from i to Root(n)
 *  2. count the divisor & return count
 *  3. Repeat the same for the entire array
 */
class FactorCountTool{

    public int[] findFactorialCount(int[] inputArray) {
        int length = inputArray.length;
        int[] factorialCounts = new int[length];

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            factorialCounts[loopIndex] = findFactorCount(inputArray[loopIndex]);
        }

        return factorialCounts;
    }

  public int findFactorCount(int inputNumber){

      if(inputNumber == 1){
          return inputNumber;
      }

      int factorCount = 0;
      //Max possible factor is Sqrt(N). Instead of finding Sqrt(n),
      // we take root on both sides which is now
      // i^2 = sqrt(n)^ i.e., i^2 = N. So, we run loop till "N" and use i^2 for comparison.
      for(int loopIndex = 1; (loopIndex * loopIndex) <= inputNumber; loopIndex++){
        if(inputNumber % loopIndex == 0){
            factorCount++;
            if(loopIndex != (inputNumber / loopIndex)){
                factorCount++;
            }
        }
      }

      return factorCount;
  }
}
