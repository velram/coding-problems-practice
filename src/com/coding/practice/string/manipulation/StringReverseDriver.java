package com.coding.practice.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * @date 12.08.2021
 *
 *
 */
public class StringReverseDriver {
    public static void main(String[] args) {

        String input = "the sky is blue";//Test case #1 Sample input from question - PASS
//        String input = "ib is this";//Test case #2 Sample input from question - PASS
//        String input = "string with more        spaces";//Test case #3 More spaces - PASS
//        String input = "MoreTrailingSpaces             ";//Test case #4 - Trailing spaces more - PASS
//        String input = "           MoreLeadingSpaces";//Test case #4 - Leading spaces more - PASS
//        String input = "MoreLeadingSpaces a";//sing char as last word
//        String input = "           MoreLeadingNTrailingSpaces             ";
//        String input = "j";
//        String input = "world";
//        String input = "fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq";
        StringReverseTools stringReverseTools = new StringReverseTools();
        String result = stringReverseTools.reverse(input);
        System.out.println("Reversed String  : " + result);
    }
}

/**
 * Approach :
 *
 * 1. Read the input (char by char)
 * 2. If space is found store in the list variable with space
 * 3. If next char is space ignore till valid char comes in.
 * 4. Reverse iterate list & store in builder
 */
class StringReverseTools{
    public String reverse(String input){

        if(input.length() ==1){
            return input;
        }

        List<String> inputStrings = new ArrayList<>();
        StringBuilder inputStringBuilder = new StringBuilder();
        StringBuilder resultStringBuilder = new StringBuilder();



        for(int loopIndex = 0; loopIndex < input.length(); loopIndex++) {
            if(input.charAt(loopIndex) != ' '){
                inputStringBuilder.append(input.charAt(loopIndex));
                if(loopIndex == input.length() - 1){
                    inputStrings.add(inputStringBuilder.toString());
                }
            }
            else if(input.charAt(loopIndex) == ' ') {
                    if(inputStrings.size() == 0 && !inputStringBuilder.toString().isEmpty()) { //first word
                        inputStrings.add(inputStringBuilder.toString());
                    }

                    else{
                        if(loopIndex == input.length() -1 || input.charAt(loopIndex + 1) == ' '){
                            inputStringBuilder = new StringBuilder();
                            continue;
                        }
                        if(!inputStringBuilder.toString().isEmpty()){
                            inputStrings.add(inputStringBuilder.toString());
                        }
                    }
                    inputStringBuilder = new StringBuilder();
            }
        }

        if(!inputStrings.get(inputStrings.size() -1 ).equals(inputStringBuilder.toString()) &&
                !inputStringBuilder.toString().isEmpty()){
            inputStrings.add(inputStringBuilder.toString());
            inputStringBuilder = new StringBuilder();
        }

        for(int loopIndex = inputStrings.size() - 1; loopIndex >= 0; loopIndex--) {
            if(loopIndex != 0){
                resultStringBuilder.append(inputStrings.get(loopIndex) + " ");
            }
            else {
                resultStringBuilder.append(inputStrings.get(loopIndex));
            }
        }

        //System.out.println("Result string : " + resultStringBuilder.toString());
        return resultStringBuilder.toString();
    }
}