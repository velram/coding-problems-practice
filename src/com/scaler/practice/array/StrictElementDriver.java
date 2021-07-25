package com.scaler.practice.array;

/**
 *
 * @author Velmurugan Moorthy
 * @date : 25.07.2021
 *
 * You are given an Array A of size N.
 *
 * Find for how many elements, there is a strictly smaller element and a strictly greater element.
 *
 *
 * Input Format
 *
 * Given only argument A an Array of Integers.
 *
 * Output Format
 *
 * Return an Integer X, i.e number of elements.
 *
 * Constraints
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e6
 *
 * For Example
 *
 * Example Input:
 *     A = [1, 2, 3]
 *
 * Example Output:
 *     1
 *
 * Explanation:
 *     only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StrictElementDriver {
    public static void main(String[] args) {
        //int[] inputArray = {1, 2, 3}; //Test case #1 - Sample input from question - PASS
//        int[] inputArray = {3, 2, 1}; //Test case #2 worst case - descending order array  - PASS
//        int[] inputArray = {32, 12, 21, 6};//Test case #3 Mixed sorted elements - 6, 12, 21, 32 - PASS
//        int[] inputArray = {32, 12,12,21,6};//Test case #4 - Duplicate elements - PASS
//        int[] inputArray = {34,34,34,34,34,34,34};//Test case #5 same element in entire array - PASS
//        int[] inputArray = {0,0,0}; //Test case #6 - only zero as array elements - PASS
        //int[] inputArray = {1,2,4,6,8,16,32}; //Test case #7 - 2^n - PASS
        int[] inputArray = {241, 710, 751, 904, 264, 955, 413, 163, 914, 173, 940, 164, 494, 545, 750, 685, 665, 619,
                99, 953, 759, 783, 534, 706, 771, 570, 471, 543, 658, 674, 634, 766, 931, 40, 244, 209, 360, 517, 962,
                420, 155, 711, 845, 646, 117, 641, 458, 790, 620, 46, 837, 560, 374, 510, 133, 214, 322, 275, 342, 460,
                642, 153, 751, 317, 71, 8, 256, 195, 256, 469, 16, 986, 339, 753, 773, 921, 638, 529, 333, 73, 393, 985,
                846, 175, 548, 694, 560, 174, 710, 478, 316};
        StrictElementFinder strictElementFinder = new StrictElementFinder();
        int strictElementCount = strictElementFinder.findStrictElementCount(inputArray);
        System.out.println("strictElementCount : " + strictElementCount);
    }
}

class StrictElementFinder {
    public int findStrictElementCount(int[] inputs){

        int arraySize = inputs.length;

        if(arraySize < 3){
            return 0;
        }

        List<Integer> sortedList = Arrays.stream(inputs).boxed().sorted().collect(Collectors.toList());
        List<Integer> sortedFilteredInputs = Arrays.stream(inputs).boxed().sorted().distinct().collect(Collectors.toList());
        int strictElementCount = 0;

        sortedList.stream().forEach(System.out::println);
        System.out.println("======================");
        sortedFilteredInputs.stream().forEach(System.out::println);
        for(int loopIndex = 1; loopIndex < sortedFilteredInputs.size() - 1; loopIndex++) {
            boolean isSmaller = sortedFilteredInputs.get(loopIndex-1) < sortedFilteredInputs.get(loopIndex);
            boolean isGreater = sortedFilteredInputs.get(loopIndex) < sortedFilteredInputs.get(loopIndex + 1);
            //System.out.println("isSmaller :  " + isSmaller + " || isGreater : " + isGreater);
            if(isSmaller && isGreater){
                strictElementCount++;
            }
        }

        return strictElementCount;
    }
}

