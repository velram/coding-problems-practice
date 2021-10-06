package com.coding.practice.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Velmurugan Moorthy
 * @date : 06/10/2021
 * Problem name :
 */
public class PermutationDriver {
    public static void main(String[] args) {

        int[] inputArray= {1, 2, 3};//Test case #1 - Happy flow
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #

        PermutationFinder permutationFinder = new PermutationFinder();
        permutationFinder.findPermutations(inputArray);

    }
}

class PermutationFinder{

    public void findPermutations(int[] inputArray) {
        int length = inputArray.length;
        int[][] result = new int[length][length];
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>(Collections.nCopies(length, -1));

        permute(inputArray, length, 0, resultList, tempList);

        resultList.forEach(list -> {
            list.forEach(innerListElement -> {
                System.out.print(innerListElement + " ");
            });
            System.out.println();
        });
    }

    public void permute(int[] inputArray, int length, int index, List<List<Integer>> resultList,
                        List<Integer> tempList){

        if(index == length){
            resultList.add(tempList);
            return;
        }

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            if(-1 == tempList.get(index)){
                tempList.add(inputArray[index]);
                permute(inputArray, length, index + 1, resultList, tempList);
                tempList.add(loopIndex, -1);
            }
        }

    }
}
