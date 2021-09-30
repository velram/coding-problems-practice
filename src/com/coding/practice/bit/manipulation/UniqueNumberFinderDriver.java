package com.coding.practice.bit.manipulation;

/**
 * @author : Velmurugan Moorthy
 * @date : 30/09/2021
 * Problem name :
 */
public class UniqueNumberFinderDriver {
    public static void main(String[] args) {

//        int[] input = {1, 2, 2, 3, 1};//Test case #1  - Happy flow - PASS
//        int[] input = {87};//Test case #2 single element array - PASS
//        int[] input = {2,2};//Test case #3 two elements - all duplicates - PASS
        int[] input = {87, 87, 87, 87, 87};//Test case #4 more than 2 elements, all duplicates - PASS

        UniqueNumberFinder uniqueNumberFinder = new UniqueNumberFinder();
        int uniqueNumber = uniqueNumberFinder.findUniqueNumber(input);
        System.out.println("Unique number is : " + uniqueNumber);
    }
}

class UniqueNumberFinder{
    public int findUniqueNumber(int[] input){
        int length = input.length;
        int uniqueNumber = 0;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            uniqueNumber = uniqueNumber ^ input[loopIndex];
        }

        return uniqueNumber;
    }
}
