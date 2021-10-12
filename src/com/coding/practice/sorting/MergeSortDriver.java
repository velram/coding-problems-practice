package com.coding.practice.sorting;

/**
 * @author : Velmurugan Moorthy
 * @date : 12/10/2021
 * Problem name : Merge Two Sorted Arrays
 *
 * Problem Description
 *
 * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
 *
 *
 * Problem Constraints
 *
 * -1010 <= A[i],B[i] <= 1010
 *
 */
public class MergeSortDriver {
    public static void main(String[] args) {

        //Test case #1- PASS
//        int[] firstArray = {4, 7, 9};
//        int[] secondArray = {2 ,11, 19};

        //Test case #2 - single element array
        int[] firstArray = {1};
        int[] secondArray = {2};

        //Test case #
//        int[] firstArray = {};
//        int[] secondArray = {};

        MergeSortTools mergeSortTools = new MergeSortTools();
        int[] result = mergeSortTools.mergeSort(firstArray, secondArray);

        for(int index = 0; index < result.length; index++){
            System.out.print(result[index] + " ");
        }
    }
}

class MergeSortTools{

    public int[] mergeSort(final int[] firstArray, final int[] secondArray) {

        int firstArraySize = firstArray.length;
        int secondArraySize = secondArray.length;
        int resultArraySize = firstArraySize + secondArraySize;

        int[] resultArray = new int[resultArraySize];
        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        int resultPointer = 0;

        while(firstArrayPointer < firstArraySize && secondArrayPointer < secondArraySize){

            if(firstArray[firstArrayPointer] < secondArray[secondArrayPointer]){
                resultArray[resultPointer] = firstArray[firstArrayPointer];
                firstArrayPointer++;
                resultPointer++;
            }
            else {
                resultArray[resultPointer] = secondArray[secondArrayPointer];
                secondArrayPointer++;
                resultPointer++;
            }
        }

        while(firstArrayPointer < firstArraySize){
            resultArray[resultPointer] = firstArray[firstArrayPointer];
            firstArrayPointer++;
            resultPointer++;
        }

        while(secondArrayPointer < secondArraySize){
          resultArray[resultPointer] = secondArray[secondArrayPointer];
          secondArrayPointer++;
          resultPointer++;
        }

        return resultArray;
    }
}
