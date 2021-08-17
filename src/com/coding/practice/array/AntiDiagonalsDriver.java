package com.coding.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * @date 16.08.2021
 */
public class AntiDiagonalsDriver {
    public static void main(String[] args) {

       // int[][] input = {{1,2,3}, {4,5,6},{7,8,9}};
        int[][] input = {{1,2,3, 4}, {5,6, 7, 8},{9, 10, 11, 12}, {13, 14, 15, 16}};
        AntiDiagonalTools antiDiagonalTools = new AntiDiagonalTools();

        int[][] result = antiDiagonalTools.diagonal(input);


        for(int i = 0; i < result.length ; i++){
            for(int j = 0; j < result[0].length ; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class AntiDiagonalTools{
    public int[][] diagonal(int[][] input) {

        int inputRowSize = input.length;
        int inputColumnSize = input[0].length;

        int[][] result = new int[ 2 * inputRowSize - 1][inputColumnSize];
        int[][] result2 = new int[ 2 * inputRowSize - 1][inputColumnSize];
        List<List<Integer>> resultList = new ArrayList<>();
        int resultColumn = 0;
        for(int i = 0; i < inputRowSize ; i++){
            for(int j = 0; j < inputColumnSize ; j++){

                result[i+j][j] = (input[i][j]);

                //System.out.print(input[i][j] + " ");
               // System.out.println(" i + j " + (i + j));
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < result.length ; i++){
            for(int j = 0; j < result[i].length ; j++){
                result2[i][j] = (result[i][j]);

                //if(antiDiagonalIndex++ == i+j)
                //System.out.println(" i + j " + (i + j));
            }
        }


        return result2;
    }
}
