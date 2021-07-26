package com.scaler.practice.bit.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 23.07.2021
 * Finding a single number in a collection of duplicate (2 times)
 * Sample input : {1, 2, 2, 3, 1};
 * Sample output : 3
 */
public class SingleNumberDriver {
    public static void main(String[] args) {
        SingleNumberFinder singleNumberFinder = new SingleNumberFinder();
        int[] inputs = {1, 2, 2, 3, 1};
        int result = singleNumberFinder.findSingleNumber(inputs);
        System.out.println("Result is : " + result);
    }
}

class SingleNumberFinder {
    public int findSingleNumber(int[] inputs){
        int arrayLength = inputs.length;
        int result = inputs[0];

        for(int index = 1; index < arrayLength; index++) {
            result = result ^ inputs[index];
        }

        return result;
    }
}
