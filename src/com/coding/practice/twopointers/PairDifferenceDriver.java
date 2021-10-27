package com.coding.practice.twopointers;

import java.util.*;

/**
 * @author : Velmurugan Moorthy
 * @date : 22/10/2021
 * Problem name :
 */
public class PairDifferenceDriver {
    public static void main(String[] args) {

        //Test case #1 - Happy flow - PASS
//        int[] inputArray = {1, 5, 3, 4, 2};
//        int requiredDifference = 3;

        //Test case #2 - PASS
//        int[] inputArray = {8, 12, 16, 4, 0, 20};
//        int requiredDifference = 4;

        //Test case #3 - duplicate elements - PASS
//        int[] inputArray = {1, 1, 1, 2, 2};
//        int requiredDifference = 0;

        //Test case #4
        int[] inputArray = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5,
                            3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int requiredDifference = 3;

        //Test case #
//        int[] inputArray = {};
//        int requiredDifference = 0;

        //Test case #
//        int[] inputArray = {};
//        int requiredDifference = 0;

        //Test case #
//        int[] inputArray = {};
//        int requiredDifference = 0;

        PairDifferenceFinder pairDifferenceFinder = new PairDifferenceFinder();
        int pairCount = pairDifferenceFinder.solve(inputArray, requiredDifference);

        System.out.println("Pair count : " + pairCount);


    }
}


/**
 * Approach :
 * 1. Sort the array
 * 2. Use two pointers
 *     - how to initialize - left = 0; right =
 *     - when to stop
 */
class PairDifferenceFinder {
    public int solve(int[] inputArray, int requiredDifference) {

        int pairCount = 0;
        int arraySize = inputArray.length;
        int left = 0;
        int right = arraySize - 1;

        Arrays.sort(inputArray);
        Map<Integer, Set<Integer>> differencePairMap = new HashMap<>();

        while (left < right && right < inputArray.length){

          int difference = inputArray[right] - inputArray[left];

          if(difference == requiredDifference){
              //Handle duplicates :
              /**
               * Approach : If a pair is found, add it to the HashMap with HashSet
               */

              if(differencePairMap.get(requiredDifference) == null){
                  Set<Integer> pairs = new HashSet<>();
                  pairs.add(inputArray[left]);
                  pairs.add(inputArray[right]);
                  differencePairMap.put(requiredDifference, pairs);
              }
              else {
                  if(!differencePairMap.get(requiredDifference).contains(inputArray[left]) ||
                     !differencePairMap.get(requiredDifference).contains(inputArray[right])){

                      Set<Integer> pairs = differencePairMap.get(requiredDifference);
                      pairs.add(inputArray[left]);
                      pairs.add(inputArray[right]);
                  }
              }
              left++;
              right--;
          }
          else if(difference < requiredDifference) {
              right--;
          }
          else if(difference > requiredDifference){
              left++;
              right--;
          }
        }

        pairCount = differencePairMap.get(requiredDifference) != null ?
                    differencePairMap.get(requiredDifference).size() :
                    0;

        return pairCount;
    }
}
