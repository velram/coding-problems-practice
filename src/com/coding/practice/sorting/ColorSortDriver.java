package com.coding.practice.sorting;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 08.08.2021
 *
 * Problem name : Sort by Color
 */
public class ColorSortDriver {
    public static void main(String[] args) {


        int[] input = {0, 1 ,2, 0, 1,2};//Test case #1 Sample input from question - PASS
//        int[] input = {0};//Test case #2 single element array - PASS
//        int[] input = {2,2,2,2,2,2,2};//Test case #3 Only single color present - PASS
//        int[] input = {2,1,0,2,1,0,2,1,0};//Test case #4 all colors of equal size & input in descending order - PASS
//        int[] input = {2,2,2,1,1,0};//Test case #5 color1.size < color2.size < color1.size - PASS
//        int[] input = {0,0,0,1,1,2};//Test case5 #6 color1.size > color2.size > color1.size - PASS
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
        ColorSorter colorSorter = new ColorSorter();
        int[] result = colorSorter.sortColors(input);
        colorSorter.printArray(result);
    }
}

class ColorSorter{
    public int[] sortColors(int[] input){

        int length = input.length;

        if(length <= 1){
            return input;
        }

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            if(0 == input[loopIndex]){
                zeroCount++;
            }
            else if(1 == input[loopIndex]){
                oneCount++;
            }
            else if(2 == input[loopIndex]){
                twoCount++;
            }
        }

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

            if(loopIndex >= 0 && loopIndex < zeroCount){
                input[loopIndex] = 0;
            }
            else if(loopIndex >= zeroCount && loopIndex < (zeroCount + oneCount)){
                input[loopIndex] = 1;
            }
            else if(loopIndex >= (zeroCount + oneCount) && loopIndex < length){
                input[loopIndex] = 2;
            }

        }
        return input;
    }

    public void printArray(int[] input){

        Arrays.stream(input).forEach(System.out::println);
    }
}