package com.coding.practice.maths;

/**
 * @author Velmurugan Moorthy
 * @date 15.08.2021
 *
 * Problem name : Excel Column Number
 *
 * Problem Description
 *
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the column title <= 5
 *
 *
 * Input Format
 *
 * Input a string which represents the column title in excel sheet.
 *
 *
 * Output Format
 *
 * Return a single integer which represents the corresponding column number.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  AB
 *
 * Input 2:
 *
 *  ABCD
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  28
 *
 * Output 2:
 *
 *  19010
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 */
public class ExcelColumnsDriver {
    public static void main(String[] args) {

//        String input = "ABCD";//Test case #1 Sample input from question - PASS
//        String input = "AB";//Test case #2 Sample input from question - PASS
//        String input = "A";//Test case #3 Single char - PASS
        String input = "ZZZZZ";//Test case #4 Upper limit test - PASS
//        String input = "";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #
//        String input = "";//Test case #

        ExcelColumnNumberFinder excelColumnNumberFinder = new ExcelColumnNumberFinder();
        int excelColumnNumber = excelColumnNumberFinder.findExcelColumnNumber(input);

        System.out.println("excelColumnNumber : " + excelColumnNumber);

    }
}

class ExcelColumnNumberFinder {
    public int findExcelColumnNumber(String input){

        if(input.length() < 1){
            return 0;
        }

        int excelColumnNumber = 0;
        int inputLength = input.length() - 1;
        for(int loopIndex = 0; loopIndex < input.length(); loopIndex++){

            int alphabetIndex = (input.charAt(loopIndex) % 65 ) + 1;
            excelColumnNumber += (alphabetIndex) * (int) (Math.pow(26, inputLength - loopIndex)); //Similar to converting binary to decimal

        }

        //System.out.println("excelColumnNumber : " + excelColumnNumber);

        return excelColumnNumber;
    }
}
