package com.scaler.practice.hashing;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Velmurugan Moorthy
 * @date 04.08.2021
 * Common Elements
 *
 * Problem Description
 *
 * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 *
 * Return an integer array denoting the common elements.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 2, 1]
 *  B = [2, 3, 1, 2]
 *
 * Input 2:
 *
 *  A = [2, 1, 4, 10]
 *  B = [3, 6, 2, 10, 10]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 2, 2]
 *
 * Output 2:
 *
 *  [2, 10]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 *
 * Explantion 2:
 *
 *  Elements (2, 10) appears in both the array.
 */
public class CommonElementDriver {
    public static void main(String[] args) {

        int[] inputArray1 = {1, 2, 2, 1};
        int[] inputArray2 = {2, 3, 1, 2};
        CommonElementFinder commonElementFinder = new CommonElementFinder();
        int[] result = commonElementFinder.findCommonElements(inputArray1, inputArray2);
        Arrays.stream(result).forEach(System.out::println);
    }
}

class CommonElementFinder{
    public int[] findCommonElements(int[] array1, int[] array2) {

       List<Integer> resultList = new ArrayList<>();

        Map<Integer,Integer> elementCountMap1 = prepareElementCountMap(array1);
        Map<Integer,Integer> elementCountMap2 = prepareElementCountMap(array2);

        for (Map.Entry<Integer, Integer> elementCountEntry :
                elementCountMap1.entrySet()) {

            int element = elementCountEntry.getKey().intValue();
            int elementCount = elementCountEntry.getValue().intValue();

            if(elementCountMap2.containsKey(element)){
                int count2 = elementCountMap2.get(element);
                for(int tempIndex = 0; tempIndex < (Math.min(elementCount, count2)); tempIndex++){
                    resultList.add(element);
                }
            }
        }
        int[] result = new int[resultList.size()];
        AtomicInteger loopIndex = new AtomicInteger(0);
        resultList.stream().forEach(resultElement -> {

            result[loopIndex.getAndIncrement()] = resultElement.intValue();
        });
        return result;
    }

    private Map<Integer, Integer> prepareElementCountMap(int[] array1) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for(int loopIndex = 0; loopIndex < array1.length; loopIndex++){
            if(!elementCountMap.containsKey(array1[loopIndex])){
                elementCountMap.put(array1[loopIndex], 1);
            }
            else {
                int tempCount = elementCountMap.get(array1[loopIndex]);
                elementCountMap.put(array1[loopIndex], tempCount + 1);
            }
        }
        return elementCountMap;
    }
}
