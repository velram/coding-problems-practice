package com.coding.practice.array.matrix;

/**
 * @author : Velmurugan Moorthy
 * @date : 11/09/2021
 * Problem name : Square granites
 *
 * Problem Description
 *
 * A city is of rectangular shape with the size A * B meters. On the occasion of the city's anniversary, a decision was
 * taken to pave the city with square granite flagstones. Each flagstone is of the size C * C.
 * What is the least number of flagstones needed to pave the city?
 *
 * NOTE: It's allowed to cover the surface larger than the city, but the city has to be covered.
 * It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the city.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= A <= 109
 *
 * 1 <= B <= 109
 *
 * 1 <= C <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer A as per the question.
 *
 * Second argument is an integer B as per the question.
 *
 * Third argument is an integer C as per the question.
 *
 *
 *
 * Output Format
 *
 * Return an integer showing least number of flagstones needed.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A=6, B=6, C=4
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 4
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * If we use 4 flagstones(2 rows and 2 columns) then it will cover the whole city.
 */
public class TilesDriver {
    public static void main(String[] args) {

        int[] input = {};//Test case #1 Happy flow
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #
//        int[] input = {};//Test case #

        TilesCountTools tilesCountTools = new TilesCountTools();
        //Test case #1 - Happy flow - PASS
//        int result = tilesCountTools.countTilesRequired(6,6,4);
        //Test case #2 - odd numbers only - PASS
//        int result = tilesCountTools.countTilesRequired(13,7,4);
        //Test case #single row & column - PASS
        int result = tilesCountTools.countTilesRequired(1,1,4);
        //Test case #
//        int result = tilesCountTools.countTilesRequired(6,6,4);
        //Test case #
//        int result = tilesCountTools.countTilesRequired(6,6,4);
        System.out.println("Result : " + result);

    }
}


class TilesCountTools{

    public int countTilesRequired(int rowSize, int columnSize, int tileSize){

        int resultRow = (int) Math.ceil((double)rowSize/(double)tileSize);
        int resultColumn = (int)Math.ceil((double)columnSize/(double)tileSize);

        //System.out.println("  Double.valueOf(Math.ceil(columnSize/tileSize)) : " +  (double)(resultRow*resultColumn));
        return resultRow * resultColumn;
    }
}