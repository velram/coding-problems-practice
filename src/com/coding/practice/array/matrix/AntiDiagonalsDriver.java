package com.coding.practice.array.matrix;

/**
 * @author Velmurugan Moorthy
 * @date 16.08.2021
 */
public class AntiDiagonalsDriver {
    public static void main(String[] args) {

        //int[][] input = {{1,2}, {3, 4}};
       int[][] input = {{1,2,3}, {4,5,6},{7,8,9}};
        //int[][] input = {{1,2,3, 4}, {5,6, 7, 8},{9, 10, 11, 12}, {13, 14, 15, 16}};
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

        if(inputRowSize == 1){
            return  input;
        }

        int[][] result = new int[ 2 * inputRowSize - 1][inputColumnSize];
        for(int rowIndex = 0; rowIndex < inputRowSize ; rowIndex++){
            for(int columnIndex = 0; columnIndex < inputColumnSize ; columnIndex++){

                if(rowIndex + columnIndex < inputRowSize){
                    result[rowIndex+columnIndex][columnIndex] = (input[columnIndex][rowIndex]);
                }
                else {
                    result[rowIndex+columnIndex][inputColumnSize - 1 - columnIndex] = (input[rowIndex][columnIndex]);
                }

                //System.out.print(input[i][j] + " ");
               // System.out.println(" i + j " + (i + j));
            }
            //System.out.println();
        }

        //System.out.println();

//        for(int i = 0; i < result.length ; i++){
//            for(int j = 0; j < result[i].length ; j++){
//                result2[i][j] = (result[i][j]);
//
//                //if(antiDiagonalIndex++ == i+j)
//                //System.out.println(" i + j " + (i + j));
//            }
//        }


        return result;
    }
}
