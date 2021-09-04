package com.coding.practice.bit.manipulation;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 04/09/2021
 */
public class XorQueryDriver {
    public static void main(String[] args){

        //Test case #1 - Happy flow - PASS
//        int[] input = {1,0,0,0,1};
//        int[][] queries = {{2,4}, {1,5}, {3,5}};

        //Test case #2 single element - PASS
//        int[] input = {1};
//        int[][] queries = {{1,1}, {1,1}, {1,1}};

        //Test case #3 left & right at mid of array
        int[] input = {1, 0,1, 0,1, 0,1, 0,1, 0,1, 0,};
        int[][] queries = {{4, 4}, {5,5}, {6,6}};

        //Test case #
//        int[] input = {};
//        int[][] queries = {{}, {}, {}};

        //Test case #
//        int[] input = {};
//        int[][] queries = {{}, {}, {}};


        //Test case #
//        int[] input = {};
//        int[][] queries = {{}, {}, {}};


        XorQueryTools xorQueryTools = new XorQueryTools();

        int[] prefixSum = xorQueryTools.findPrefixSum(input);
        Arrays.stream(prefixSum).forEach(element -> System.out.print(element + " "));

        System.out.println();

        int[] prefixXor = xorQueryTools.findPrefixXor(input);
        Arrays.stream(prefixXor).forEach(element -> System.out.print(element + " "));

        int[][] xorQueryResults = xorQueryTools.answerXorQueries(input, queries);

        System.out.println("\nXOR query results : ");
        Arrays.stream(xorQueryResults).forEach(row -> {
            Arrays.stream(row).forEach(column -> System.out.print(column + " "));
            System.out.println();
        });
    }
}

class XorQueryTools{

    //Time Limit exceeded - Need to optimize
    public int[][] answerXorQueries(int[] input, int[][] queries){


        int queryLength = queries.length;
        int[][] result = new int[queryLength][2];


        int[] prefixXor = findPrefixXor(input);
        int[] prefixSum = findPrefixSum(input);

        for(int loopIndex = 0; loopIndex < queryLength; loopIndex++){
            int left = queries[loopIndex][0] - 1;
            int right = queries[loopIndex][1] - 1;

            result[loopIndex][0] = findSubArrayXor(left, right, prefixXor);
            result[loopIndex][1] = findSubArrayZeroCount(left, right, prefixSum);
        }

        return result;
    }

    private int findSubArrayZeroCount(int left, int right, int[] prefixSum) {

        int setBitCount = findSubArraySum(left, right, prefixSum);
        int subArraySize = (right - left) + 1;

        System.out.println(" unsetBitCount : " + (subArraySize - setBitCount));
        return subArraySize - setBitCount;

    }

    private int findSubArraySum(int left, int right, int[] prefixSum) {
        if(left == 0){
            return prefixSum[right];
        }
        else {
            return prefixSum[right] - prefixSum[left - 1];
        }
    }

    private int findSubArrayXor(int left, int right, int[] prefixXor) {
        if(left == 0){
            return prefixXor[right];
        }
        else {
            return prefixXor[left - 1] ^ prefixXor[right];
        }
    }

    public int[] findPrefixSum(int[] input){

        int length = input.length;
        int[] prefixSum = new int[length];

        prefixSum[0] = input[0];

        for(int loopIndex = 1; loopIndex < length; loopIndex++){
            prefixSum[loopIndex] = prefixSum[loopIndex - 1] + input[loopIndex];
        }

        return prefixSum;
    }

    public int[] findPrefixXor(int[] input) {

        int length = input.length;
        int[] prefixXor = new int[length];

        prefixXor[0] = input[0];
        for(int loopIndex = 1; loopIndex < length; loopIndex++){
            prefixXor[loopIndex] = prefixXor[loopIndex - 1] ^ input[loopIndex];
        }

        return prefixXor;
    }
}
