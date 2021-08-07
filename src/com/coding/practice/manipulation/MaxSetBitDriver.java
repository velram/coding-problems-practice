package com.coding.practice.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 02.08.2021
 */
public class MaxSetBitDriver {
}

 class MaxSetBitCountingTools {
    public int countMaxSetBitRow(int[][] input) {

        int arraySize = input.length;

        if(arraySize == 1){
            return input[0][0];
        }

        int row = 0;
        int column = 0;

        while(row < arraySize && column < arraySize){
            if(input[row][column] == 1){
                return row;
            }
            row++;
            if(row == arraySize){
                row = 0;
                column++;
            }
        }
        return 0;
    }
}
