package com.coding.practice.search;

/**
 * @author : Velmurugan Moorthy
 * @date : 18/10/2021
 * Problem name : Find a peak element

Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.


Output Format

Return the peak element.


Example Input

Input 1:

A = [1, 2, 3, 4, 5]

Input 2:

A = [5, 17, 100, 11]



Example Output

Output 1:

5

Output 2:

100

 */
public class PeakElementDriver {
    public static void main(String[] args) {

//        int[] inputArray = {1, 2, 3, 4, 5};//Test case #1 - happy flow -  PASS
//        int[] inputArray = {5, 17, 100, 11};//Test case #2 unsorted array - PASS
//        int[] inputArray = {100, 2, 3, 4, 1};//Test case #3 peak element @ array start - & multiple peaks - PASS
//        int[] inputArray = {100, 4, 3, 2, 1};//Test case #4 peak element @ array start - PASS
        int[] inputArray = {100, 4, 1 , 2, 3};//Test case #
//        int[] inputArray = {};//Test case #

        PeakElementFinder peakElementFinder = new PeakElementFinder();
        int peakElement = peakElementFinder.findPeakElement(inputArray);

        System.out.println("Peak element is : " + peakElement);
    }
}

class PeakElementFinder {
    public int findPeakElement(int[] inputArray) {

        int arraySize = inputArray.length;
        int left = 0;
        int right = arraySize - 1;
        int mid = 0;

        while(left < right){

            mid = (left + right) / 2;

            if(inputArray[mid] > inputArray[mid + 1]){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return inputArray[left];
    }
}
