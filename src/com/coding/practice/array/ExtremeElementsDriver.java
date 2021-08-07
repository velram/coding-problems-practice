package com.coding.practice.array;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Velmurugan Moorthy
 * @date 05.08.2021
 *
 *
Smaller and Greater

You are given an Array A of size N.

Find for how many elements, there is a strictly smaller element and a strictly greater element.


Input Format

Given only argument A an Array of Integers.

Output Format

Return an Integer X, i.e number of elements.

Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e6

For Example

Example Input:
A = [1, 2, 3]

Example Output:
1

Explanation:
only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.

 */

public class ExtremeElementsDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 3}; //Test case #1 - Sample input from question - PASS
//        int[] input = {12, 1234, 45, 67, 1}; //Test case #2 smaller element @ end, larger element in middle - PASS
//        int[] input = {473, 940, 330, 410, 666, 709, 55, 933, 533, 447, 152, 35, 589, 111, 584, 159, 443, 271, 181, 632,
//                329, 390, 494, 862, 852, 516, 638, 401, 460, 791, 746, 885, 566, 635, 723, 755, 62, 780, 405, 922, 239,
//                862, 826, 635, 659, 765, 643, 442, 342, 87, 192, 662, 970, 644, 663, 771, 466, 947, 0, 130, 923, 244,
//                993, 484, 991, 633, 718, 780, 302, 483, 624, 252, 346, 232, 331}; //Test case #3 Trivial test case - PASS
//
//        int[] input = {947, 871, 859, 471, 763, 766, 379, 746, 485, 966, 10, 350, 341, 22, 706, 702, 717, 967, 641, 712,
//                10, 954, 751, 250, 777, 214, 820, 276, 708, 509, 123, 73, 593, 790, 797, 678, 320, 865, 392, 428, 611,
//                813, 655, 195, 102, 902, 919, 171, 706, 841, 873, 98, 128, 728, 878, 701, 874, 158, 548, 214, 414, 600,
//                869, 936, 841, 221, 87, 255, 233, 627, 487, 53, 270, 162, 517, 576, 240, 681, 172, 148, 86, 778, 205,
//                741, 483, 11, 795, 188, 450}; //Test case #4 - Trivial test case - PASS
        int[] input = {1, 1, 1, 1, 1}; //Test case # All elements same - PASS
        //int[] input = {}; //Test case #
        //int[] input = {}; //Test case #
        //int[] input = {}; //Test case #

        SmallerGreaterElementsTools smallerGreaterElementsTools = new SmallerGreaterElementsTools();
        int smallerGreaterElementsCount = smallerGreaterElementsTools.countSmallerGreaterElements(input);
        System.out.println("Element count : " + smallerGreaterElementsCount);

    }
}

class SmallerGreaterElementsTools {

    public int countSmallerGreaterElements(int[] input){

        int length = input.length;
        if(length <= 2){
            return 0;
        }

        int minimumElement = findMinimumElement(input);
        int maximumElement = findMaximumElement(input);
        Map<Integer, Integer> elementIndexMap = prepareElementIndexMap(input);
        int maxElementCount = findMaxElementCount(maximumElement, elementIndexMap);
        int minElementCount = findMinElementCount(minimumElement, elementIndexMap);

        if(minElementCount == 0 && maxElementCount == 0){
            return 0;
        }
        else if (minimumElement == maximumElement){
            return 0;
        }
        else {

            return length - (minElementCount + maxElementCount);
        }
    }

    private int findMinElementCount(int minimumElement, Map<Integer, Integer> elementIndexMap) {
        int minimumElementCount = 0;
        if(elementIndexMap.containsKey(minimumElement)){
            minimumElementCount = elementIndexMap.get(minimumElement);
        }
        return minimumElementCount;
    }

    private int findMaxElementCount(int maximumElement, Map<Integer, Integer> elementIndexMap) {
        int maximumElementCount = 0;
        if(elementIndexMap.containsKey(maximumElement)){
            maximumElementCount = elementIndexMap.get(maximumElement);
        }
        return maximumElementCount;
    }

    private Map<Integer, Integer> prepareElementIndexMap(int[] input) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            if(!elementIndexMap.containsKey(input[loopIndex])){
                elementIndexMap.put(input[loopIndex], 1);
            }
            else {
                int count = elementIndexMap.get(input[loopIndex]);
                elementIndexMap.put(input[loopIndex], count + 1);
            }
        }
        return elementIndexMap;
    }

    private int findMinimumElement(int[] input) {
        int minimumElement = Integer.MAX_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){

            if(minimumElement > input[loopIndex]){
                minimumElement = input[loopIndex];
            }
        }
        //System.out.println("Minimum element is : " + minimumElement);
        return minimumElement;
    }

    private int findMaximumElement(int[] input){
        int maximumElement = Integer.MIN_VALUE;

        for(int loopIndex = 0; loopIndex < input.length; loopIndex++){
            if(maximumElement < input[loopIndex]){
                maximumElement = input[loopIndex];
            }
        }
        //System.out.println("Maximum element is : " + maximumElement);
        return maximumElement;
    }
}
