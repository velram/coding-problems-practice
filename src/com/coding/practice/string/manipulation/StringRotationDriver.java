package com.coding.practice.string.manipulation;

/**
 * @author Velmurugan Moorthy
 * @date 14.08.2021
 *
 * Problem Name : Rotate string
 *
 * Problem Description
 *
 * Given a string A, rotate the string B times in clockwise direction and return the string.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * 1 <= B <= 109
 *
 * String A consist only of lowercase characters.
 *
 *
 *
 * Input Format
 *
 * First and only argument is a string A.
 *
 *
 * Output Format
 *
 * Return a string denoting the rotated string.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = "scaler"
 *  B = 2
 *
 * Input 2:
 *
 *  A = "academy"
 *  B = 7
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  "erscal"
 *
 * Output 2:
 *
 *  "academy"
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Rotate the given string twice so the string becomes "erscal".
 */
public class StringRotationDriver {
    public static void main(String[] args) {

//        String input = "abcdef"; //Test case #1 Event rotation - PASS
//        int rotationCount = 2;

//        String input = "abcdefg"; //Test case #2 Odd rotation - PASS
//        int rotationCount = 3;

//        String input = "abcdefghij"; //Test case #3 rotation = length - PASS
//        int rotationCount = 10;

//        String input = "abcdefghijklmnopqrstuvwxyz"; //Test case #4 rotations > length - PASS
//        int rotationCount = 30;

//        String input = "a"; //Test case #5 Single character string - PASS
//        int rotationCount = 100;

        String input = "abcdefg"; //Test case #6 length = multiple of rotationCount - PASS
        int rotationCount = 28;

        StringRotationTools stringRotationTools = new StringRotationTools();
        String result = stringRotationTools.rotateString(input, rotationCount);
        System.out.println(" Rotated string : " + result);
    }
}

class StringRotationTools{
    public String rotateString(String input, int rotationCount) {

//        System.out.println(" Input string : " + input + " rotationCount : "+ rotationCount);
        int length = input.length();

        boolean rotationNotRequired = isRotationNotRequired(input, rotationCount);

        if(rotationNotRequired){
            return input;
        }

        if(rotationCount > length){
            rotationCount = rotationCount % length;
        }

        StringBuilder resultBuilder = new StringBuilder();
        int partitioningPoint = length - rotationCount;

        //System.out.println("partitioningPoint : " + partitioningPoint);

        for(int loopIndex = partitioningPoint; loopIndex < length; loopIndex++){
            resultBuilder.append(input.charAt(loopIndex));
        }

        for(int loopIndex = 0 ; loopIndex < partitioningPoint; loopIndex++){
            resultBuilder.append(input.charAt(loopIndex));
        }

        //System.out.println("Rotated string : " + partitioningPoint);
        return resultBuilder.toString();
    }

    private boolean isRotationNotRequired(String input, int rotationCount) {
        boolean isMinimalLength = (1 >= input.length());
        boolean isRotationEqualsLength = (rotationCount == input.length() || (rotationCount % input.length() == 0));

//        System.out.println(" isMinimalLength : " + isMinimalLength
//                         + " isRotationEqualsLength : " + isRotationEqualsLength);

        return isMinimalLength || isRotationEqualsLength;
    }
}