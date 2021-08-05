package com.scaler.practice.array.matrix;

/**
 * @author Velmurugan Moorthy
 * @date : 04.08.2021
 *
 * Spiral Order Matrix II
 *
 * Problem Description
 *
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 1000
 *
 *
 * Input Format
 *
 * First and only argument is integer A
 *
 *
 *
 * Output Format
 *
 * Return a 2-D matrix which consists of the elements in spiral order.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * 1
 *
 * Input 2:
 *
 * 2
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [1] ]
 *
 * Output 2:
 *
 * [ [1, 2], [4, 3] ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *
 * Only 1 is to be arranged.
 *
 * Explanation 2:
 *
 * 1 --> 2
 *       |
 *       |
 * 4<--- 3
 */
public class SpiralMatrixDriver {
    public static void main(String[] args) {
        SpiralMatrixBuilder spiralMatrixBuilder = new SpiralMatrixBuilder();
        //int[][] spiralMatrix = spiralMatrixBuilder.generateMatrix(1);
        int[][] spiralMatrix = spiralMatrixBuilder.generateMatrix(2);
        //int[][] spiralMatrix = spiralMatrixBuilder.generateMatrix(3);
        //int[][] spiralMatrix = spiralMatrixBuilder.generateMatrix(5);
        spiralMatrixBuilder.printArray(spiralMatrix);
    }
}

class SpiralMatrixBuilder {
    public int[][] generateMatrix(int input) {


        if(input == 1){
            return new int[][]{{1}};
        }

        int[][] result = new int[input][input];
        int row = 0;
        int column = 0;
        int right = input - 1;
        int left = 0;
        int top = 0;
        int bottom = input - 1;
        int count = 1;
        String direction = "right";

        while (count <= (input * input)){

            result[row][column] = count++;

            switch (direction){
                case "right":
                    if(column == right){
                        right--;
                        row++;
                        top++;
                        direction = "down";
                    }
                    else {
                        column++;
                    }
                    break;

                case "left":
                    if(column == left){
                        row--;
                        //bottom--;
                        direction = "up";
                    }
                    else {
                        column--;
                    }
                    break;

                case "up":
                    if(row == top){
                        direction = "right";
                        column++;
                        left++;
                    }
                    else{
                        row--;
                    }
                    break;

                case "down":
                    if(row == bottom){
                        column--;
                        bottom--;
                        direction = "left";
                    }
                    else {
                        row++;
                    }
                    break;
            }
        }
        return result;
    }

    public void printArray(int[][] patternArray) {
        int maxSize = patternArray.length;
        for(int row = 0; row < maxSize; row++){
            for(int column = 0; column < maxSize; column++){
                System.out.print((patternArray[row][column]) + " ");
            }
            System.out.println();
        }

    }
}
