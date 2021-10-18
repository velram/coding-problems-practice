package com.coding.practice.search;

/**
 * @author : Velmurugan Moorthy
 * @date : 18/10/2021
 * Problem name :
 */
public class SingleElementDriver {
    public static void main(String[] args) {

//        int[] inputArray = {2, 2, 5, 5, 9,9, 16, 16, 18, 20, 20, 21, 21};//Test case #1- Happy flow - PASS
//        int[] inputArray = {87};//Test case #2 edge case - single element array - PASS
//        int[] inputArray = {87, 98,98, 103, 103, 108, 108, 110, 110};//Test case #3 - single element @ start of the array - PASS
//        int[] inputArray = {33, 33, 36, 36, 37, 37, 43, 43, 51, 51, 101};//Test case #4 answer at the end of array - PASS
        int[] inputArray = {1, 1, 2, 2, 3, 4, 4, 5, 5};//Test case #5 - answer @ the mid array - PASS
//        int[] inputArray = {};//Test case #
//        int[] inputArray = {};//Test case #

        SingleElementFinder singleElementFinder = new SingleElementFinder();
        int singleElement = singleElementFinder.solve(inputArray);

        System.out.println("Single element : " + singleElement);

    }
}

class SingleElementFinder {
    public int solve(int[] inputArray) {

        int singleElement = -1;

        singleElement = handleBaseCases(inputArray);
        if(singleElement != -1){
            return singleElement;
        }


        int arraySize = inputArray.length;
        int left = 0;
        int right = arraySize - 1;
        int mid = 0;

        while(left <= right){

            mid = (left + right ) / 2;

            if( inputArray[mid] != inputArray[mid - 1] && inputArray[mid] != inputArray[mid + 1]){
                return inputArray[mid];
            }

            if(inputArray[mid] == inputArray[mid - 1]){
                mid = mid - 1;
            }

            /*
             * This means we are in left side of the array
             * where first occurrences of every element's indices wud be even indices
             * for the single element hasn't appeared yet.
             */
            if(inputArray[mid] == inputArray[mid + 1] && mid % 2 == 0){
                left = mid + 2;
            }
            else {
                right = mid - 1;
                /* This means we're in the right side of the array
                 * i.e., single element has appeared and
                 * first occurrence of every element's indices now wud have changed to odd indices.
                 *
                 */
            }
        }

        return singleElement;
    }

    private int handleBaseCases(int[] inputArray) {

        int arraySize = inputArray.length;

        if(arraySize == 1){
            return inputArray[0];
        }

        //First element is the single element (i.e., answer)
        if(inputArray[0] != inputArray[1]){
            return inputArray[0];
        }

        //Last element is the single element (i.e., answer)
        if(inputArray[arraySize - 1] != inputArray[arraySize - 2]){
            return inputArray[inputArray.length - 1];
        }

        return -1;
    }
}