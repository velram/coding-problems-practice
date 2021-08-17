package com.coding.practice.array;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date 16.08.2021
 */
public class AntiDiagonalsDriver {
    public static void main(String[] args) {

        int[][] input = {{1,2,3}, {4,5,6},{7,8,9}};

        AntiDiagonalTools antiDiagonalTools = new AntiDiagonalTools();

        int[][] result = antiDiagonalTools.diagonal(input);

        Arrays.stream(result).forEach(row -> {
            Arrays.stream(row).forEach(System.out::print);
        });

    }
}

class AntiDiagonalTools{
    public int[][] diagonal(int[][] input) {


        int inputRowSize = input.length;
        int inputColumnSize = input[0].length;
        int[][] result = new int[ 2 * inputColumnSize][inputRowSize];

        int diagonalSize = 2;
        int startRow = 0;
        int startColumn = 1;
        int rowIndex = startRow;
        int columnIndex = startColumn;

        result[0][0] = input[0][0];
        int resultRow = 1;
        int resultColumn = 0;

        while(rowIndex < inputRowSize && columnIndex < inputColumnSize){

            if(rowIndex < diagonalSize-1 && columnIndex >= 0){
                result[resultRow][resultColumn] = input[rowIndex][columnIndex];
                rowIndex++;
                columnIndex--;
                resultColumn++;
                continue;
            }

            else if(diagonalSize - 1 == inputRowSize - 1 && rowIndex == inputRowSize - 1
                    && columnIndex == 0){
                result[resultRow][resultColumn] = input[rowIndex][columnIndex];
                rowIndex = startRow++;
                columnIndex = startColumn;
                resultRow++;
                resultColumn = 0;
                diagonalSize--;
                continue;
            }

            else if(diagonalSize - 1 == rowIndex && rowIndex < inputRowSize && columnIndex < inputColumnSize &&
                    diagonalSize -1 < inputRowSize){
                result[resultRow][resultColumn] = input[rowIndex][columnIndex];
                diagonalSize++;
                rowIndex = 0;
                columnIndex = (startRow < 1) ? ++startColumn : startColumn;
                resultRow++;
                resultColumn=0;
                continue;
            }
        }
        return result;
    }
}
