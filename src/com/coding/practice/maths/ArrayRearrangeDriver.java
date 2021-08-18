package com.coding.practice.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * @date 18.08.2021
 * Problem name :  Rearrange Array
 *
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 *
 *     Lets say N = size of the array. Then, following holds true :
 *
 *         All elements in the array are in the range [0, N-1]
 *         N * N does not overflow for a signed integer
 */
public class ArrayRearrangeDriver {
    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(3);
        input.add(1);
        input.add(0);
        input.add(2);

        ArrayRearrangeTools arrayRearrangeTools = new ArrayRearrangeTools();
        arrayRearrangeTools.arrange(input);

        input.forEach(element -> System.out.print(element+ " "));

    }
}

class ArrayRearrangeTools{
    public void arrange(ArrayList<Integer> input) {

        int length = input.size();

        if(length <= 1){
            return;
        }

        for(int index = 0; index < length; index++){
            input.set(index, input.get(index) * length);
        }

        for(int loopIndex = 0; loopIndex < length; loopIndex++){

           int oldValueAtCurrentIndex = input.get(loopIndex) / length;
           int targetIndex = input.get(oldValueAtCurrentIndex) / length;
            input.set(loopIndex, input.get(loopIndex)+targetIndex);
        }

        for(int index = 0; index < length; index++){
            input.set(index, input.get(index) % length);
        }

    }
}
