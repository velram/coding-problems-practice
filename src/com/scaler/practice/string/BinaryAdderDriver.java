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
        binaryAdder.addBinaryNumbers("01", "10");
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
        char[] number1;
        char[] number2;

        if(input1.length() > input2.length()){
            maxDigits = input1.length();
//            number1 = input1.toCharArray();
//            number2 = input2.toCharArray();
        }
        else {
            maxDigits = input2.length();
//            number1 = input2.toCharArray();
//            number2 = input1.toCharArray();
        }

        int[] result = new int[maxDigits];
        int carryBit = 0;
        int resultBit = 0;

        for(int loopIndex = maxDigits-1; loopIndex >= 0; loopIndex--){
            if(input1.charAt(loopIndex) == '1' && input1.charAt(loopIndex) == '1'){
                if(carryBit == 1){
                    resultBit = 1;
                }
                else {
                    resultBit = 0;
                }
                carryBit = 1;
            }
            else {
                resultBit = Character.getNumericValue(input1.charAt(loopIndex)) |
                            Character.getNumericValue(input2.charAt(loopIndex));
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
