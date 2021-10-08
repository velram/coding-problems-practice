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

//        int[] inputArray= {1, 2, 3};//Test case #1 - Happy flow - PASS
//        int[] inputArray= {1};//Test case #2 - trivial case - PASS
//        int[] inputArray= {1,2};//Test case #3 - Lesser inputs - PASS
        int[] inputArray= {1,2,3,4};//Test case #4 - Four integers
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #
//        int[] inputArray= {};//Test case #

        PermutationFinder permutationFinder = new PermutationFinder();
        int[][] permutations = permutationFinder.findPermutations(inputArray);

        for(int rowIndex = 0; rowIndex < permutations.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < inputArray.length; columnIndex++){
                System.out.print(permutations[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }

    }
}

class PermutationFinder{

    public int[][] findPermutations(int[] inputArray) {

        int inputLength = inputArray.length;

        if(inputLength == 1){
            int[][] result = new int[1][1];
            result[0] = inputArray;
            return result;
        }


        List<List<Integer>> permutationList = new ArrayList<>();
        List<Integer> permutationRow = new ArrayList<>(Collections.nCopies(inputLength, -1));

        permute(inputArray, inputLength, 0, permutationList, permutationRow);
        int[][] permutations = new int[ permutationList.size()][inputLength];

        for(int loopIndex = 0; loopIndex < permutationList.size(); loopIndex++){
            permutations[loopIndex] = permutationList.get(loopIndex).stream().mapToInt(listElement->listElement).toArray();
        }

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
