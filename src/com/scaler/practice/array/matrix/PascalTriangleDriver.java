package com.scaler.practice.array.matrix;

/**
 * @author Velmurugan Moorthy
 * @date 03.08.2021
 * Problem description :
 *
Pascal Triangle

Problem Description

Write a program to input an integer N from user and print pascal triangle up to N rows.

Problem Constraints

1 <= N <= 25



Input Format

First line is an integer N.



Output Format

N lines whose each row contains N+1 space separated integers.



Example Input

Input 1:

3

Input 2:

5



Example Output

Output 1:

1 0 0
1 1 0
1 2 1

Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1



Example Explanation

Explanation 1:

Row 1 = 1 0 0 0 0
Row 2 = 1C0 1C1 0 0 0= 1 1 0 0 0
Row 3 = 2C0 2C1 2C2 0 0= 1 2 1 0 0
Row 4 = 3C0 3C1 3C2 3C3 0= 1 3 3 1 0

 */
public class PascalTriangleDriver {
    public static void main(String[] args) {
        PascalTriangleBuilder pascalTriangleBuilder = new PascalTriangleBuilder();
//        int[][] pascalTriangle = pascalTriangleBuilder.buildPascalTriangle(3);//Test case #1 sample input-1
//        int[][] pascalTriangle = pascalTriangleBuilder.buildPascalTriangle(5);//Test case #2 Sample input-2
//        int[][] pascalTriangle = pascalTriangleBuilder.buildPascalTriangle(1);//Test case #3 Lower bound
        int[][] pascalTriangle = pascalTriangleBuilder.buildPascalTriangle(25);//Test case #4 Upper bound
        pascalTriangleBuilder.printArray(pascalTriangle);
    }
}

class PascalTriangleBuilder {
    public int[][] buildPascalTriangle(int input){

        if(input == 1){
            return new int[][]{{1}};
        }

        int row = 0;
        int column = 0;
        int[][] result = new int[input][input];

        while(row < input && column <= row){
            if(column == 0){
                result[row][column] = 1;
                if(row == 0){
                    row++;
                }
                else {
                    column++;
                }
            }
            else if(row == column) { //Diagonal of matrix & edge of pascal triangle
                result[row][column] = 1;
                row++;
                column = 0;
            }
            else {
                result[row][column] = result[row-1][column] + result[row - 1][column -1];
                column++;
            }
        }

        return result;
    }

    public void printArray(int[][] inputArray){
        for(int loopIndex = 0; loopIndex < inputArray.length; loopIndex++){
            for (int innerLoopIndex = 0; innerLoopIndex < inputArray[0].length; innerLoopIndex++){
                System.out.print(inputArray[loopIndex][innerLoopIndex] + " ");
            }
            System.out.println();
        }
    }
}
