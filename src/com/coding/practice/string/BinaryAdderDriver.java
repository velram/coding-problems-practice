package com.coding.practice.string;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * @date : 26.07.2021
 * Add Binary Strings
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * Example:
 *
 * a = "100"
 *
 * b = "11"
 *
 * Return a + b = "111".
 */
public class BinaryAdderDriver {
    public static void main(String[] args) {

        BinaryAdder binaryAdder = new BinaryAdder();
//        binaryAdder.addBinaryNumbers("01", "10");//Test case #1 - Simple flow - PASS
//        binaryAdder.addBinaryNumbers("00", "00");//Test case #2 - all zeros - PASS
//        binaryAdder.addBinaryNumbers("00", "0");//Test case #3 - one of operand size lesser than other one - PASS
//        binaryAdder.addBinaryNumbers("11", "11");//Test case #4 - all '1's  in both operand - PASS
//        binaryAdder.addBinaryNumbers("11111", "11111");//Test case #5 - all 1's in both operands - PASS
//          binaryAdder.addBinaryNumbers("1010110111001101101000", "1000011011000000111100110");//Test case #6 - operand2.size > operand1.size - PASS
//          binaryAdder.addBinaryNumbers("1000011011000000111100110", "1010110111001101101000");//Test case #7  operand1.size > operand2.size - PASS
//        binaryAdder.addBinaryNumbers("11111111111111111111111111111", "11111111111111111111111111111");//Test case #8 all 1's - larger size operands with all 1's
//        binaryAdder.addBinaryNumbers("1111", "");//Test case #9 - operand2 absent - PASS
//        binaryAdder.addBinaryNumbers("", "1111");//Test case #10 - operand1 absent - PASS
//        binaryAdder.addBinaryNumbers("0", "1111");//Test case #11 -  - PASS
        binaryAdder.addBinaryNumbers("1111", "0");//Test case #12 -  - PASS
    }
}

class BinaryAdder {
    public String addBinaryNumbers(String input1, String input2){

        if(input1.isEmpty() && input2.isEmpty()){
            return "0";
        }

        if(null == input1 && input1.isEmpty()){
            return input2;
        }
        if(null == input2 && input2.isEmpty()){
            return input1;
        }

        int maxDigits = 0;
        int carryBit = 0;
        int sumBit = 0;

        if(input1.length() > input2.length()){
            maxDigits = input1.length();

        }
        else {
            maxDigits = input2.length();
        }

        int[] operand1 = new int[maxDigits];
        int[] operand2 = new int[maxDigits];
        int[] result = new int[maxDigits];


        for(int loopIndex = maxDigits - 1; loopIndex > (maxDigits - input1.length()) - 1; loopIndex--){
            if(input1.length() < maxDigits){
                int difference = maxDigits - input1.length();
                operand1[loopIndex] = Character.getNumericValue(input1.charAt(loopIndex - difference));
            }
            else {
                operand1[loopIndex] = Character.getNumericValue(input1.charAt(loopIndex));
            }
        }

        for(int loopIndex = maxDigits - 1; loopIndex > (maxDigits - input2.length()) - 1; loopIndex--){
            if(input2.length() < maxDigits){
                int difference = maxDigits - input2.length();
                operand2[loopIndex] = Character.getNumericValue(input2.charAt(loopIndex - difference));
            }
            else {
                operand2[loopIndex] = Character.getNumericValue(input2.charAt(loopIndex));
            }
        }

//        System.out.println("Operand 1 : \n");
//
//        Arrays.stream(operand1).forEach(System.out::print);
//
//        System.out.println("\n Operand 2 : \n");
//
//        Arrays.stream(operand2).forEach(System.out::print);

        StringBuilder resultBuilder = new StringBuilder();

        for(int loopIndex = maxDigits - 1; loopIndex >= 0; loopIndex--){

            if(operand1[loopIndex] == 1 && operand2[loopIndex] == 1){ //Both operands are 1
                if(carryBit == 1){
                    sumBit = 1;
                }
                else {
                    sumBit = 0;
                }
                carryBit = 1;
            }
            else if (operand1[loopIndex] == 1 || operand2[loopIndex] == 1){ //one of the operand is 1
                if(carryBit == 1){
                    carryBit = 1;
                    sumBit = 0;
                }
                else {
                    carryBit = 0;
                    sumBit = 1;
                }
            }
            else { //Both operands are zero
                if(carryBit == 1){
                    sumBit = 1;
                }
                else if (carryBit == 0){
                    sumBit = 0;
                }
                carryBit = 0;
            }

            result[loopIndex] = sumBit;
        }

        if(carryBit == 1){
            resultBuilder.append(1);
        }

        Arrays.stream(result).forEach(entry -> {
            resultBuilder.append(entry);
        });

//        System.out.println("\n Sum of two binary numbers is : " + resultBuilder.toString());
        return resultBuilder.toString();
    }
}
