package com.coding.practice.array.matrix;

/**
 * @author : Velmurugan Moorthy
 * @date : 02/10/2021
 * Problem name : Rotate matrix
 * LeetCode question URL : https://leetcode.com/problems/rotate-image/
 *
 * Description : You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class MatrixRotationDriverV2 {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2},{3, 4}};//Test case #1 - Happy flow - PASS
//        int[][] matrix = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
//                           {21, 22, 23, 24, 25}};//Test case #2 - Case - PASS
//        int[][] matrix = {};//Test case #
//        int[][] matrix = {};//Test case #
//        int[][] matrix = {};//Test case #

        MatrixRotateTools matrixRotateTools = new MatrixRotateTools();
        matrixRotateTools.rotateMatrix(matrix);
        print2DMatrix(matrix);
    }

    public static void print2DMatrix(int[][] matrix){
        int length = matrix.length;

        for(int row = 0; row < length; row++){
            for(int column = 0; column < length; column++){
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * Approach :
 *  1. Find transpose of matrix
 *  2. Reverse the columns of matrix
 */
class MatrixRotateTools{
    public void rotateMatrix(int[][] matrix) {

        findTranspose(matrix);
        reverseColumns(matrix);
    }

    public void findTranspose(int[][] matrix){
        int matrixSize = matrix.length;

        for(int row = 0; row < matrixSize; row++){
            for(int column = 0; column < row; column++){
                int swapVariable = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = swapVariable;
            }
        }
    }

    public void reverseColumns(int[][] matrix){

        int matrixSize = matrix.length;
        int row = 0;
        int startColumn = 0;
        int endColumn = matrixSize - 1;
        while(row < matrixSize){

            int swapVariable = matrix[row][startColumn];
            matrix[row][startColumn] = matrix[row][endColumn];
            matrix[row][endColumn] = swapVariable;

           if(startColumn < endColumn){
               startColumn++;
               endColumn--;
           }
           if(startColumn >= endColumn){
               row++;
               startColumn = 0;
               endColumn = matrixSize - 1;
           }
        }
    }
}