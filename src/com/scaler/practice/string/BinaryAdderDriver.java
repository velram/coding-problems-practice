package com.scaler.practice.string;

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
//        binaryAdder.addBinaryNumbers("11", "11");//Test case #4 - all '1's  in both operand
//        binaryAdder.addBinaryNumbers("11111", "11111");//Test case #5 - all 1's in both operands
          binaryAdder.addBinaryNumbers("1010110111001101101000", "1000011011000000111100110");
    }
}

class BinaryAdder {
    public String addBinaryNumbers(String input1, String input2){

        if(null == input1 && input1.isEmpty()){
            return input2;
        }
        if(null == input2 && input2.isEmpty()){
            return input1;
        }

        int maxDigits = 0;
        String largerNumber = "";
        String smallerNumber = "";

        if(input1.length() > input2.length()){
            maxDigits = input1.length();
            largerNumber = input1;
            smallerNumber = input2;
        }
        else {
            maxDigits = input2.length();
            largerNumber = input2;
            smallerNumber = input1;
        }

        int[] result = new int[maxDigits];
        int carryBit = 0;
        int resultBit = 0;
        int operand1 = 0;
        int operand2 = 0;
        int smallerNumberIndex = maxDigits;
        for(int loopIndex = maxDigits-1; loopIndex >= 0 ; loopIndex--){

            if(loopIndex >= maxDigits - (maxDigits - smallerNumber.length()) - 1){
                operand2 = 0;
            }
            else{
                operand2 = Character.getNumericValue(smallerNumber.charAt(loopIndex - (maxDigits - smallerNumber.length())));
            }
            operand1 = Character.getNumericValue(largerNumber.charAt(loopIndex));

            if(operand1 == 1 && operand2 == 1){
                if(carryBit == 1){
                    resultBit = 1;
                }
                else {
                    resultBit = 0;
                }
                carryBit = 1;
            }
            else {
                    resultBit = operand1 | operand2;
                    carryBit = 0;
            }
            result[loopIndex] = resultBit;
        }
        StringBuilder resultBuilder = new StringBuilder();
        if(carryBit == 1){
            resultBuilder.append(carryBit);
        }

        //resultBuilder.append(result);
        Arrays.stream(result).forEach(entry -> {
            resultBuilder.append(entry);
        });
        System.out.println("Sum of two binary numbers is : " + resultBuilder.toString());
        return resultBuilder.toString();
    }
}
