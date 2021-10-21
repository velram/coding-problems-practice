package com.coding.practice.twopointers;

/**
 * @author : Velmurugan Moorthy
 * @date : 22/10/2021
 * Problem name : Pairs with given sum II
 *
 * Problem Description
 *
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 *
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 1, 1]
 * B = 2
 *
 * Input 2:
 *
 *
 * A = [1, 1]
 * B = 2
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
 *  1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Any two pairs sum up to 2.
 *
 * Explanation 2:
 *
 *  only pair (1, 2) sums up to 2.
 */
public class PairSumDriver {
    public static void main(String[] args) {


        //Test case #1 - No pairs found - PASS
//        int[] inputArray  = {2, 3, 5, 6, 10};
//        int requiredSum = 6;

//        //Test case #2 - Happy flow
        int[] inputArray  = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int requiredSum = 7;
//
//        //Test case #
//        int[] inputArray  = {};
//        int requiredSum = 0;
//
//        //Test case #
//        int[] inputArray  = {};
//        int requiredSum = 0;
//
//        //Test case #
//        int[] inputArray  = {};
//        int requiredSum = 0;

        //TODO - fix time limit exceeded error
        /*
        A : [ 2, 2, 3, 4, 4, 5, 6, 7, 10 ]
        B : 8
         */

        PairSumFinder pairSumFinder = new PairSumFinder();
        int pairCount = pairSumFinder.countPairs(inputArray, requiredSum);
        System.out.println("pair count : " + pairCount);

    }
}

/**
 * Approach :
 * 1. Use 2 pointers
 * 2. check sum of elements at two pointers.
 * 3. If the sum is greater than expected sum move right pointer (decrement it)
 * 4. If sum is lesser than expected sum move left pointer (increment)
 * 5. If the answer is found, increment pair count.
 *
 */
class PairSumFinder {
    public int countPairs(int[] inputArray, int requiredSum){

        int inputSize = inputArray.length;

        //TODO handle single element array

        if(inputSize == 1){
            return 0;
        }

        if(inputSize == 2){
            if(inputArray[0] + inputArray[1] == requiredSum){
                return 1;
            }
            return 0;
        }

        long pairCount = 0;

        int left = 0;
        int right = inputSize - 1;

        while(left < right){
            long elementSum = inputArray[left] + inputArray[right];

            if(elementSum < requiredSum){
                left++;
            }
            else if (elementSum > requiredSum){
                right--;
            }
            else {
                if(inputArray[left] != inputArray[right]){

                    long leftElementCount = 0;
                    int tempLeft = left;

                    while(inputArray[left] == inputArray[tempLeft]){
                        leftElementCount++;
                        left++;
                    }

                    long rightElementCount = 0;
                    int tempRight = right;
                    while(inputArray[right] == inputArray[tempRight]){
                        rightElementCount++;
                        right--;
                    }

                    pairCount += (leftElementCount * rightElementCount);
                }
               else if(inputArray[left] == inputArray[right]){
                    long duplicateCount = (right - left + 1);
                    pairCount = pairCount + (( duplicateCount * (duplicateCount - 1 )) /  2);//Formula for Nc2;
                }
                else {
                    pairCount++;
                    left++;
                    right--;
                }
            }
        }

        return (int) (pairCount % 1000000007);
    }
}