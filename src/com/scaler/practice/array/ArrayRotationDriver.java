package com.scaler.practice.array;

import java.util.Arrays;
import java.util.Scanner;

/*
Failed test case
10
4 1 2 3 4
2
3 1 2 4
1
3 1 2 2
3
50 583681 974670 319007 112618 13420 445299 591949 541941 842935 542883 744147 932291 306516 635879 640786 402645 564355 971802 792148 450108 163501 516677 718277 700797 538180 316064 172800 81060 608196 55496 791524 191876 30165 626882 820846 559937 72181 412794 618229 915115 472029 362375 847406 778544 514605 4543 697540 595312 976344 489687
419
50 656196 522715 280047 356992 60895 596110 529791 141954 720657 101638 449830 428885 648155 76711 249730 724443 148891 178875 342671 580358 650903 221398 944115 945799 252354 948657 643338 847665 441352 649377 409435 97547 172091 689482 454538 232985 801943 500681 891291 522600 602318 857472 951484 250472 934182 717565 974914 599425 896439 833937
134
50 547342 571686 640248 493140 824039 105256 652829 188056 546607 302205 597490 160505 474296 803323 615042 223632 605266 632074 631274 644217 750744 488745 112052 1215 422927 345968 492481 538703 242406 842769 234836 306099 414454 391435 315590 238492 130
 */

public class ArrayRotationDriver {
    public static void main(String[] args) {


        ArrayRotater arrayRotater = new ArrayRotater();
        Scanner reader = new Scanner(System.in);

        //System.out.println("Before reading input");

        int testCaseCount = 0;
        if(reader.hasNext()){
            testCaseCount = Integer.parseInt(reader.next());
            System.out.println("Test case count : " + testCaseCount);
        }
        for(int loopIndex = 0; loopIndex < testCaseCount; loopIndex++){
            int elementCount = 0;
            if(reader.hasNext()){
                elementCount = Integer.parseInt(reader.next());

                System.out.println("\nelementCount : " + elementCount);
            }
            int[] inputArray = new int[elementCount];
            for(int innerLoopIndex = 0; innerLoopIndex < elementCount; innerLoopIndex++){
                if(reader.hasNext()){
                    inputArray[innerLoopIndex] = Integer.parseInt(reader.next());
                    System.out.println("InputArray[" + innerLoopIndex + "] : " + inputArray[innerLoopIndex]);
                }
            }

            //System.out.println("Inner loop after reading element : ");
            int rotationCount = 0;
            if(reader.hasNext()){
                rotationCount = Integer.parseInt(reader.next());
                System.out.println("rotationCount : " + rotationCount);
            }
            //System.out.println("Inner loop after reading rotation count : " + rotationCount);
            arrayRotater.rotateArray(inputArray, rotationCount);

        }


        //Test case #1 - Happy flow from sample input - PASS
//        int[] input = {1, 2, 3, 4};
//        int rotations = 2;

        //Test case #2 -  arraySize = no.of.rotations (odd) - PASS
//        int[] input = {1,2};
//        int rotations = 2;


        //Test case #3 - arraySize = no.of.rotations (even number) - PASS
//        int[] input = {1, 2, 2};
//        int rotations = 3;

        //Test case #4 - Single element array - multiple rotations - PASS
//        int[] input = {1};
//        int rotations = 3;

        //Test case #5 - arraySize > rotations (arraysize even, rotation odd)
//        int[] input = {1, 2, 3, 4};
//        int rotations = 5;

        //Test case #6 - arraySize > rotations (arraysize odd, rotation even)
        //int[] input = {1, 2, 3, 4, 5, 7, 8, 9};
//        int rotations = 12;

//        int[] input = {1, 2, 4};
//        int rotations = 1;
//        ArrayRotater arrayRotater = new ArrayRotater();
//        arrayRotater.rotateArray(input, rotations);

    }
}

class ArrayRotater {
    public void rotateArray(int[] input, int rotations){

        int length = input.length;

        if(length <= 1 ){
            System.out.println(input[0]);
            return;
        }

        if(rotations % (length) == 0){
            printArray(input);
            return;
        }

        if(rotations >= length){
            rotations = rotations % length;
        }

        int[] result = new int[input.length];
        int oldArrayIndex = length - rotations;
        //int newArrayIndex = 0;

        for(int loopIndex = 0; loopIndex < length; loopIndex++){
            if(oldArrayIndex > rotations - 1 && oldArrayIndex < length){
                result[loopIndex] = input[oldArrayIndex++];
                if(oldArrayIndex == length){
                    oldArrayIndex = 0;
                }
            }
            else if (oldArrayIndex >= 0 && oldArrayIndex < rotations){
                result[loopIndex] = input[oldArrayIndex++];
            }
        }
        printArray(result);
    }

    private void printArray(int[] result) {
        //System.out.println("Rotated array is :  ");
        Arrays.stream(result).forEach(element -> {
            System.out.print(element+ " ");
        });
        System.out.println();
    }
}
