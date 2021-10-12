package com.coding.practice.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Velmurugan Moorthy
 * @date : 10/10/2021
 * Problem name :
 */
public class ParanthesisDriver {
    public static void main(String[] args) {

        ParanthesisBuilder paranthesisBuilder = new ParanthesisBuilder();
//        String[] result = paranthesisBuilder.buildParanthesis(1);//Test case #1 - Happy flow - PASS
        //String[] result = paranthesisBuilder.buildParanthesis(3);//Test case#2 - average test case - PASS
//        String[] result = paranthesisBuilder.buildParanthesis(2);//Test case#3 - size-2 - PASS
        String[] result = paranthesisBuilder.buildParanthesis(5);//Test case#4 size-5 - PASS
//        String[] result = paranthesisBuilder.buildParanthesis(1);//Test case#

        Arrays.stream(result).forEach(braceCombo -> System.out.println(braceCombo));

    }
}

class ParanthesisBuilder {
    public String[] buildParanthesis(int size){

        List<String> paranthesisCombos = new ArrayList<>();
        createParanthesis(0, 0,0,size, new StringBuilder(), paranthesisCombos);
        String[] result = paranthesisCombos.stream().toArray(String[]::new);
        return result;
    }


    public void createParanthesis(int index, int openBraces, int closedBraces, int size, StringBuilder paranthesisCombo,
        List<String> paranthesisCombos) {

        if( (index) == 2 * size){
            paranthesisCombos.add(paranthesisCombo.toString());
            return;
        }
        if(closedBraces == size){
            return;
        }

        if(openBraces < size) {
            paranthesisCombo.append('(');
            createParanthesis(index+1, openBraces + 1, closedBraces, size, paranthesisCombo, paranthesisCombos);
            paranthesisCombo.deleteCharAt(index);
        }

        if(openBraces > closedBraces) {
            paranthesisCombo.append(')');
            createParanthesis(index+1, openBraces, closedBraces+1, size, paranthesisCombo, paranthesisCombos);
            paranthesisCombo.deleteCharAt(index);
        }

    }
}
