package com.coding.practice.sorting;

import java.util.*;

/**
 * @author Velmurugan Moorthy
 * @date 10.08.2021
 *
 * Problem statement : Kth Smallest Element
 *
 * Problem Description
 *
 * Find the Bth smallest element in given array A .
 *
 * NOTE: Users should try to solve it in <= B swaps.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 *
 * 1 <= B <= min(|A|, 500)
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is vector A.
 *
 * Second argument is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the Bth smallest element in given array.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [2, 1, 4, 3, 2]
 * B = 3
 *
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  2
 *
 * Output 2:
 *
 *  2
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  3rd element after sorting is 2.
 *
 * Explanation 2:
 *
 *  2nd element after sorting is 2.
 */
public class KSmallestElementDriver {
    public static void main(String[] args) {

//        int[] input = {2, 1, 4, 3, 2};//Test case #1 = sample input from question - PASS
//        int k = 3;

        int[] input = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91,
                36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
                //Test case #2 = Trivial test case from question
        int k = 9;
        KSmallestElementTools kSmallestElementTools = new KSmallestElementTools();
        int kthSmallest = kSmallestElementTools.findKthSmallest(input, k);
        System.out.println("Kth smallest element : " +  kthSmallest + " || K = " + k );
    }
}

class KSmallestElementTools{
    public int findKthSmallest(final int[] input, int k){


        int length = input.length;
        if(length <= 1){
            return input[0];
        }

        int kthSmallestElement = -1;

        for(int loopIndex = 0; loopIndex < k; loopIndex++){

            List<Integer> smallestElementMap = findSmallestElement(input, loopIndex);
            kthSmallestElement = smallestElementMap.get(0);
            int oldIndex = smallestElementMap.get(1);
            int temp = input[loopIndex];
            input[loopIndex] = kthSmallestElement;
            input[oldIndex] = temp;

            if(loopIndex == k - 1){
                return kthSmallestElement;
            }
        }

        return kthSmallestElement;
    }

    private List<Integer> findSmallestElement(int[] input, int startIndex){

        int smallestElement = Integer.MAX_VALUE;
        int smallElementIndex = -1;
        List<Integer> smallestElementMap = new ArrayList<>();
        for(int loopIndex = startIndex; loopIndex < input.length; loopIndex++){
            if(smallestElement > input[loopIndex]){
                smallestElement = input[loopIndex];
                smallElementIndex = loopIndex;
            }
        }
        smallestElementMap.add(smallestElement);
        smallestElementMap.add(smallElementIndex);
        return smallestElementMap;
    }
}
