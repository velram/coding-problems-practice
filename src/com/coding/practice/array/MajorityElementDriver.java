package com.coding.practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author Velmurugan Moorthy
 *  @date : 23.08.2021
 *
 *  Problem name : Majority Element
 *
 *  Problem Description
 * Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example :
 *
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 *
 */
public class MajorityElementDriver {
    public static void main(String[] args) {

//        int[] input = {2, 1, 2};//Test case#1 Happy flow
//        int[] input = {16, 1, 16, 2 , 16, 3, 16, 16};//Test case#2 majority element at alternate indices
//        int[] input = {21,21,21,21,100, 31, 1};//Test case#3 - Maj. element @ start
//        int[] input = {1, 3, 4, 91, 91, 91, 91, 91, 91};//Test case#4 Maj element @ end
        int[] input = {1, 2};//Test case#5 two element in the array
//        int[] input = {12345};//Test case#6 single element array
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#
//        int[] input = {};//Test case#          
        MajorityElementFinder majorityElementFinder = new MajorityElementFinder();
        int majorityElementCount = majorityElementFinder.findMajorityElement(input);
        System.out.println("Majority element count : " + majorityElementCount);
    }
}

/*
 * Approach :
 * Read each & every element
 * Create Map & count occurrences & value
 * Iterate thru map & fetch the count
 * return the count if it's greater than majority count
 *
 */
class MajorityElementFinder {
    public int findMajorityElement(final int[] input) {

        int length = input.length;

        if(length == 1){
            return input[0];
        }

        if(length == 2){
            return input[1];
        }

        int majorityCount = (int) Math.floor(length / 2);
        System.out.println("Majority count : " + majorityCount);
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        Integer majorityElement = findMajorityElementFromMap(input, length, majorityCount, elementCountMap);
        if (majorityElement != null) {
            return majorityElement;
        }

        return 0;
    }

    private Integer findMajorityElementFromMap(int[] input, int length, int majorityCount, Map<Integer, Integer> elementCountMap) {

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
                if(!elementCountMap.containsKey(input[loopIndex])){
                    elementCountMap.put(input[loopIndex], 1);
                }
                else {
                    int elementCount = elementCountMap.get(input[loopIndex]);
                    elementCount++;
                    //System.out.println("element : " + input[loopIndex] + " count : " + elementCountMap.get(input[loopIndex]));
                    if(elementCount > majorityCount){
                        return input[loopIndex];
                    }
                    else {
                        elementCountMap.put(input[loopIndex], elementCount);
                    }
            }

        }
        return null;
    }
}
