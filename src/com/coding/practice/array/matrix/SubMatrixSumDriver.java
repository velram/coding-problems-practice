package com.coding.practice.array.matrix;

import java.util.Arrays;

/**
 * @author : Velmurugan Moorthy
 * @date : 16/10/2021
 * Problem name : Sub-matrix Sum Queries
 *
 * Problem Description
 *
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum.
 *
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 *
 * NOTE:
 *
 *     Rows are numbered from top to bottom and columns are numbered from left to right.
 *     Sum may be large so return the answer mod 109 + 7.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 1000
 * -100000 <= A[i] <= 100000
 * 1 <= Q <= 100000
 * 1 <= B[i] <= D[i] <= N
 * 1 <= C[i] <= E[i] <= M
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * The second argument given is the integer array B.
 * The third argument given is the integer array C.
 * The fourth argument given is the integer array D.
 * The fifth argument given is the integer array E.
 * (B[i], C[i]) represents the top left corner of the i'th query.
 * (D[i], E[i]) represents the bottom right corner of the i'th query.
 *
 *
 * Output Format
 *
 * Return an integer array containing the submatrix sum for each query.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [   [1, 2, 3]
 *          [4, 5, 6]
 *          [7, 8, 9]   ]
 *  B = [1, 2]
 *  C = [1, 2]
 *  D = [2, 3]
 *  E = [2, 3]
 *
 * Input 2:
 *
 *  A = [   [5, 17, 100, 11]
 *          [0, 0,  2,   8]    ]
 *  B = [1, 1]
 *  C = [1, 4]
 *  D = [2, 2]
 *  E = [2, 4]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [12, 28]
 *
 * Output 2:
 *
 *  [22, 19]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
 *  For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
 *
 * Explanation 2:
 *
 *  For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
 *  For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
 *
 */
public class SubMatrixSumDriver {  public static void main(String[] args) {

    //Test case #1 - Happy flow - PASS
//    int[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    int[] topLeftRow = {1, 2};
//    int[] topLeftColumn = {1, 2};
//    int[] bottomRightRows = {2, 3};
//    int[] bottomRightColumn = {2, 3};

    //Test case #2 - single element matrix - PASS
//        int[][] inputMatrix = {{103}};
//        int[] topLeftRow = {1};
//        int[] topLeftColumn = {1};
//        int[] bottomRightRows = {1};
//        int[] bottomRightColumn = {1};


    //Test case #3 - PASS (column only sum)
        int[][] inputMatrix = {{5, 17, 100, 11}, {0, 0, 2, 8}};
        int[] topLeftRow = { 1, 1 };
        int[] topLeftColumn = { 1, 4};
        int[] bottomRightRows = { 2, 2};
        int[] bottomRightColumn = {2, 4};



        /* */

    //Test case #
//        int[][] inputMatrix = {{}};
//        int[] topLeftRow = {};
//        int[] topLeftColumn = {};
//        int[] bottomRightRows = {};
//        int[] bottomRightColumn = {};

    SubMatrixSumFinder subMatrixSumFinder = new SubMatrixSumFinder();
    int[] subMatrixRangeSum = subMatrixSumFinder.answerRangeSumQueries(inputMatrix, topLeftRow, topLeftColumn,
            bottomRightRows, bottomRightColumn);

    System.out.println("Range sum is : ");
    Arrays.stream(subMatrixRangeSum).forEach(rangeSum -> System.out.print(rangeSum + " "));

}
}


class SubMatrixSumFinder {

    private static final long MODULO_MAX = 1000000007;

    public int[] answerRangeSumQueries(int[][] inputMatrix, int[] topLeftRows, int[] topLeftColumns,
                                       int[] bottomRightRows, int[] bottomRightColumns) {

        int[] rangeSums = new int[topLeftRows.length];
        long[][] prefixSum2D = calculatePrefixSum2D(inputMatrix);

//        System.out.println("PrefixSum2D is given below ");
//        print2DMatrix(rowCount, columnCount, prefixSum2D);

        for(int loopIndex = 0; loopIndex < topLeftRows.length; loopIndex++){

            rangeSums[loopIndex] = handleOverflows(prefixSum2D[bottomRightRows[loopIndex] - 1][bottomRightColumns[loopIndex] - 1]);

            if(topLeftColumns[loopIndex] - 1 > 0){
                rangeSums[loopIndex] = handleOverflows(rangeSums[loopIndex] - prefixSum2D[bottomRightRows[loopIndex] - 1][topLeftColumns[loopIndex] - 1 -1]);
            }
            if(topLeftRows[loopIndex] - 1 > 0){
                rangeSums[loopIndex] = handleOverflows(rangeSums[loopIndex] - prefixSum2D[topLeftRows[loopIndex] - 1 - 1][bottomRightColumns[loopIndex]-1]);
            }
            if(topLeftRows[loopIndex] - 1 > 0 && topLeftColumns[loopIndex] - 1 > 0){
                rangeSums[loopIndex] = handleOverflows(rangeSums[loopIndex] + prefixSum2D[topLeftRows[loopIndex] - 1 - 1][topLeftColumns[loopIndex] - 1 - 1]);
            }

            //System.out.println("Range sum["+loopIndex+"] : " + rangeSums[loopIndex]);
        }

        return rangeSums;
    }

    private long[][] calculatePrefixSum2D(int[][] inputMatrix) {

        int rowCount = inputMatrix.length;
        int columnCount = inputMatrix[0].length;
        long[][] prefixSum2D = new long[inputMatrix.length][inputMatrix[0].length];

        prefixSum2D[0][0] = inputMatrix[0][0];

        for(int columnIndex = 1; columnIndex < columnCount; columnIndex++){
            prefixSum2D[0][columnIndex] =  handleOverflows( prefixSum2D[0][columnIndex] + prefixSum2D[0][columnIndex - 1]
                                                           + inputMatrix[0][columnIndex]);
        }

        for(int rowIndex = 1; rowIndex < rowCount; rowIndex++){
            prefixSum2D[rowIndex][0] = handleOverflows(prefixSum2D[rowIndex][0] + prefixSum2D[rowIndex - 1][0]
                                                       + inputMatrix[rowIndex][0]);
        }

        for(int rowIndex = 1; rowIndex < rowCount; rowIndex++){
            for(int columnIndex = 1; columnIndex < columnCount; columnIndex++){
                prefixSum2D[rowIndex][columnIndex] = handleOverflows(
                                                                 prefixSum2D[rowIndex][columnIndex - 1] +
                                                                        prefixSum2D[rowIndex - 1][columnIndex] -
                                                                        prefixSum2D[rowIndex - 1][columnIndex - 1] +
                                                                        inputMatrix[rowIndex][columnIndex]
                                                                 );
            }
        }

        return prefixSum2D;
    }

    private int handleOverflows(long input){
        return (int) ((input + MODULO_MAX) % MODULO_MAX);
    }

    private void print2DMatrix(int rowCount, int columnCount, long[][] prefixSum2D) {
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++){
            for(int columnIndex = 0; columnIndex < columnCount; columnIndex++){
                System.out.print(prefixSum2D[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }

}
