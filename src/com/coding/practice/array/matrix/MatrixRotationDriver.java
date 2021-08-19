package com.coding.practice.array.matrix;

import java.util.Arrays;

/**
 * @author Velmurugan
 * @date - 19.08.2021
 * Problem Description
 *
 * You are given a n x n 2D matrix A representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note: If you end up using an additional array, you will only receive partial score.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= n <= 1000
 *
 *
 * Input Format
 *
 * First argument is a 2D matrix A of integers
 *
 *
 * Output Format
 *
 * Return the 2D rotated matrix.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  [
 *     [1, 2],
 *     [3, 4]
 *  ]
 *
 * Input 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [
 *     [3, 1],
 *     [4, 2]
 *  ]
 *
 * Output 2:
 *
 *  [
 *     [1]
 *  ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  After rotating the matrix by 90 degree:
 *  1 goes to 2, 2 goes to 4
 *  4 goes to 3, 3 goes to 1
 *
 * Explanation 2:
 *
 *  2D array remains the same as there is only element.
 */
public class MatrixRotationDriver {
    public static void main(String[] args) {

//        int[][] input = {{1,2,3}, {4,5,6},{7,8,9}};; //Test case #1 Happy flow odd sized array - PASS
//        int[][] input = {{1,2,3, 4}, {5,6,7,8},{9, 10, 11, 12}, {13, 14, 15, 16}}; //Test case #2 Even sized array - PASS
        int[][] input = {{1,2}, {5,6}}; //Test case #3 Lower bound test - Smaller input matrix - PASS
//        int[][] input = null; //Test case #
//        int[][] input = null; //Test case #
//        int[][] input = null; //Test case #
//        int[][] input = null; //Test case #

        MatrixRotator matrixRotator = new MatrixRotator();
        int[][] result = matrixRotator.rotateMatrix(input);

        System.out.println("Rotated matrix is : ");

        for(int row = 0; row < result.length ; row++){
            for(int column = 0; column < result[0].length ; column++){
                System.out.print(result[row][column] + " ");
            }
            System.out.println();
        }
    }
}

class MatrixRotator {
    public int[][] rotateMatrix(int[][] input){

        int rowSize = input.length;

        if(rowSize == 1){
            return input;
        }

        //Transpose matrix

        for(int row = 0; row < rowSize; row++){
            for(int column = 0; column < row; column++){
                int temp = input[row][column];
                input[row][column] =  input[column][row];
                input[column][row] = temp;
            }
        }

        //Reverse the Transpose matrix using 2 pointer approach

        int startColumn = 0;
        int endColumn = rowSize - 1;
        int row = 0;
        while(startColumn < endColumn){
            int temp = input[row][startColumn];
            input[row][startColumn] = input[row][endColumn];
            input[row][endColumn] = temp;

            if(row < rowSize - 1){
                row++;
            }
            else if(row == rowSize - 1){
                startColumn++;
                endColumn--;
                row = 0;
            }
        }

        return input;
    }
}
