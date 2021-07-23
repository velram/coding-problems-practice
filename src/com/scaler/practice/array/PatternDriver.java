package com.scaler.practice.array;

/**
 * @author Velmurugan Moorthy
 * @date 21.07.2021
 */
public class PatternDriver {
    public static void main(String[] args) {
        PatternBuilder patternBuilder = new PatternBuilder();
        int[][] patternArray = patternBuilder.solve(4);
        displayPattern(patternArray);
    }

    private static void displayPattern(int[][] patternArray) {
       int maxSize = patternArray.length;
        for(int row = 0; row < maxSize; row++){
            for(int column = 0; column < maxSize; column++){
                System.out.print((patternArray[row][column]) + " ");
            }
            System.out.println();
        }

    }
}

class PatternBuilder {
    public int[][] solve(int maxSize){
        int[][] patternArray = new int[maxSize][maxSize];

        for(int row = 0; row < maxSize; row++){
            for(int column = 0; column <= row; column++){
                patternArray[row][column] = column + 1;
                //System.out.println("Row : " + row + " | Column : " + column);
                //System.out.print((patternArray[row][column]));
            }
            //System.out.println();
        }
        return patternArray;
    }
}
