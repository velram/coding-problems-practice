package com.coding.practice.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public int[][] findPermutations(int[] inputArray) {
        int inputLength = inputArray.length;
        int[][] permutations = new int[ 2 * inputLength][inputLength];
        List<List<Integer>> permutationList = new ArrayList<>();
        List<Integer> permutationRow = new ArrayList<>(Collections.nCopies(inputLength, -1));

        permute(inputArray, inputLength, 0, permutationList, permutationRow);

        for(int loopIndex = 0; loopIndex < 2 * inputLength; loopIndex++){
            permutations[loopIndex] = permutationList.get(loopIndex).stream().mapToInt(listElement->listElement).toArray();
        }

//        Arrays.stream(permutations).forEach(innerArray -> {
//            Arrays.stream(innerArray).forEach(innerArrayElement -> {
//                System.out.print(innerArrayElement + " ");
//            });
//            System.out.println();
//        });

        return permutations;
    }

    public void permute(int[] inputArray, int length, int index, List<List<Integer>> resultList,
                        List<Integer> tempList){

        if(index == length){
            resultList.add(tempList.stream().collect(Collectors.toList()));
            return;
        }

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            if(-1 == tempList.get(loopIndex)){
                tempList.set(loopIndex, inputArray[index]);
                permute(inputArray, length, index + 1, resultList, tempList);
                tempList.set(loopIndex, -1);
            }
        }

    }
}
