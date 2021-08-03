package com.scaler.practice.array.matrix;

public class SpiralMatrixDriver {
    public static void main(String[] args) {
        SpiralMatrixBuilder spiralMatrixBuilder = new SpiralMatrixBuilder();
        int[][] spiralMatrix = spiralMatrixBuilder.generateMatrix(3);
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
                        bottom--;
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
