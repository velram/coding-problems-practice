package com.coding.practice.array;

/**
 * @author Velmurugan Moorthy
 * @date 01.08.2021
 *
 * Problem description :
 * Print a Pattern According to The Given Value of A.
 *
 * Example: For A = 3 pattern looks like:
 *
 *     1
 *   2 1
 * 3 2 1
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 *
 *
 * Input Format
 *
 * First and only argument is an integer denoting A.
 *
 *
 * Output Format
 *
 * Return a two-dimensional array where each row in the returned array represents a row in the pattern.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = 3
 *
 * Input 2:
 *
 *  A = 4
 *
 *
 *
 * Example Output
 *
 * Output :1
 *
 *  [
 *    [0, 0, 1]
 *    [0, 2, 1]
 *    [3, 2, 1]
 *  ]
 *
 * Output 2:
 *
 *  [
 *    [0, 0, 0, 1]
 *    [0, 0, 2, 1]
 *    [0, 3, 2, 1]
 *    [4, 3, 2, 1]
 *  ]
 */
public class ReversePatternDriver {
    public static void main(String[] args) {

        ReversePatternBuilder reversePatternBuilder = new ReversePatternBuilder();
        reversePatternBuilder.buildReversePattern(3);
    }

}

class ReversePatternBuilder {
    public int[][] buildReversePattern(int input) {

        int arrayMaxIndex = input - 1;
        int[][] result = new int[input][input];

        if(input == 1){
            result[0][0] = 1;
            return result;
        }

        int value = 1;
        int row = 0;
        int column = arrayMaxIndex;

        while(row <= arrayMaxIndex && column >= 0){
            result[row++][column] = value;

            if(row == arrayMaxIndex + 1){ // Crossed last row - needs reset
                value++;
                row = value - 1;
                column--;
            }
        }

        return result;
    }
}
