package com.coding.practice.array;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Velmurugan Moorthy
 * @date 06.08.2021
 *
 * Problem name : Good Pair
 *
 * Problem Description
 *
 * Given an array A and a integer B. A pair(i,j) in the array is a good pair if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.
 *
 *
 * Problem Constraints
 *
 * 1 <= A.size() <= 104
 *
 * 1 <= A[i] <= 109
 *
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 *
 * Return 1 if good pair exist otherwise return 0.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1,2,3,4]
 * B = 7
 *
 * Input 2:
 *
 * A = [1,2,4]
 * B = 4
 *
 * Input 3:
 *
 * A = [1,2,2]
 * B = 4
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 1
 *
 * Output 2:
 *
 * 0
 *
 * Output 3:
 *
 * 1
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  (i,j) = (3,4)
 *
 * Explanation 2:
 *
 * No pair has sum equal to 4.
 *
 * Explanation 3:
 *
 *  (i,j) = (2,3)
 */
public class GoodPairDriver {
    public static void main(String[] args) {

//Test case #1 Sample input from question - PASS
//        int[] input = {1,2,3,4};
//        int target = 7;

//Test case #2 Sample input from question - PASS
//        int[] input = {1,2,4};
//        int target = 4;

//Test case #3 Sample input from question - PASS
//        int[] input = {1,2,2};
//        int target = 4;

//Test case #4 single element array & not matching target - PASS
//        int[] input = {1};
//        int target = 2;

//Test case #5 two element array - No pair - PASS
//        int[] input = {1, 2};
//        int target = 2;

//Test case #6 two element array - pair exists - PASS
//        int[] input = {1, 2};
//        int target = 3;

//Test case #7 No pair - i!=j test case - PASS
//        int[] input = {1,2,3};
//        int target = 6;

//Test case #8 No pair - i!=j test case - PASS
        int[] input = {1,0,3,1,0, 3};
        int target = 6;

//Test case #
//        int[] input = {};
//        int target = 0;


        GoodPairFinder goodPairFinder = new GoodPairFinder();
        int pairExists = goodPairFinder.findGoodPairs(input, target);

        System.out.println(" Pair exists : " + pairExists);
    }
}

class GoodPairFinder {
    public int findGoodPairs(int[] input, int target){

        //Edge case - Single element array
        if(input.length < 2){
            return 0;
        }

        if(input.length == 2){
            return (input[0] + input[1] == target) ? 1 : 0;
        }

        List<Integer> inputElement = new ArrayList<>();

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
          int difference = target - input[loopIndex];

          if(inputElement.contains(difference)){
              return 1;
          }
          else {
              inputElement.add(input[loopIndex]);
          }
        }
            return 0;
    }
}

