package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 24.08.2021
 */
public class PuzzleDifferenceDriver {
    public static void main(String[] args) {

        //Test case #1 - Happy flow - PASS
//        int[] allPuzzleInfo = {10, 12, 10, 7, 5, 22};
//        int requiredPuzzleCount = 4;

        //Test case #2 - total puzzle count = required puzzle count
//        int[] allPuzzleInfo = {4};
//        int requiredPuzzleCount = 1;

//Test case #2 - total puzzle count = required puzzle count
//        int[] allPuzzleInfo = {};
//        int requiredPuzzleCount = 4;

        int[] allPuzzleInfo = {759, 106, 827, 279, 722, 954, 80, 577, 273, 538, 963, 296, 693, 694, 684, 406, 603, 192, 166, 233, 310, 969, 980, 36, 322, 409, 392, 824, 422, 729, 76, 532, 186, 902, 811, 907, 855};
        int requiredPuzzleCount = 16;

        PuzzleDifferenceFinder puzzleDifferenceFinder = new PuzzleDifferenceFinder();
        int puzzleDifference = puzzleDifferenceFinder.findPuzzleDifference(allPuzzleInfo, requiredPuzzleCount);
        System.out.println(" Minimum puzzle difference is : " + puzzleDifference);

    }
}

class PuzzleDifferenceFinder {
    public int findPuzzleDifference(int[] allPuzzlesInfo, int requiredPuzzleCount){


        int totalPuzzleCount = allPuzzlesInfo.length;

        if(requiredPuzzleCount < 2){
            return 0;
        }
        if(totalPuzzleCount < requiredPuzzleCount){
            return Integer.MAX_VALUE;
        }


        Arrays.sort(allPuzzlesInfo);

        int difference = Integer.MAX_VALUE;
        for(int loopIndex = 0; loopIndex <= (totalPuzzleCount - requiredPuzzleCount); loopIndex++){


            int tempDifference = allPuzzlesInfo[loopIndex + requiredPuzzleCount - 1] - allPuzzlesInfo[loopIndex];

//            System.out.println("\nloopIndex : " + loopIndex);
//            System.out.println( "allPuzzlesInfo[loopIndex + requiredPuzzleCount - 1] " + allPuzzlesInfo[loopIndex + requiredPuzzleCount - 1] );
//            System.out.println( "allPuzzlesInfo[loopIndex] " + allPuzzlesInfo[loopIndex]);
//            System.out.println("Difference : " + tempDifference);
            difference = Math.min(tempDifference, difference);


        }

        return difference;
    }
}
