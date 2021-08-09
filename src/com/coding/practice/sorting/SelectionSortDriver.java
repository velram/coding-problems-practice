package com.coding.practice.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSortDriver {

    public static void main(String[] args) {

        int[] input = {6, 4, 3, 7, 2, 8};
        SelectionSortTools selectionSortTools = new SelectionSortTools();
        int[] result = selectionSortTools.doSelectionSort(input);

        Arrays.stream(result).forEach(System.out::println);
    }
}

class SelectionSortTools {

    public int[] doSelectionSort(int[] input){


        int length = input.length;

        //Find minimum element

        int minimumIndex = 0;
        int[] result = new int[length - 1];
        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        for(int loopIndex = 0; loopIndex < length - 1; loopIndex++) {
            int minimumElement = findMinimumElement(input,loopIndex);
            int oldIndex = inputList.indexOf(minimumElement);

            if(input[loopIndex] == minimumElement){
                result[loopIndex] = loopIndex;
                continue;
            }

            int temp = input[loopIndex];
            input[loopIndex] = minimumElement;
            input[oldIndex] = temp;
            result[loopIndex] = oldIndex;
            inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        }
        return result;
    }

    private int findMinimumElement(int[] input, int minimumIndex) {
        int minimumElement = Integer.MAX_VALUE;
        for(int loopIndex = minimumIndex; loopIndex < input.length; loopIndex++){
            if(minimumElement > input[loopIndex]){
                minimumElement = input[loopIndex];
            }
        }
        return minimumElement;
    }
}
