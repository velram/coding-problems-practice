package com.coding.practice.searching;

/**
 * @author : Velmurugan Moorthy
 * @date : 17/10/2021
 * Problem name : Sorted Insert Position
 *
 * Problem Description
 *
 * Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 * Second argument is an integer B.
 *
 *
 * Output Format
 *
 * Return an integer denoting the index of target value.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 3, 5, 6]
 *  B = 5
 *
 * Input 2:
 *
 * A = [1]
 *  B = 1
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 2
 *
 * Output 2:
 *
 * 0
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The target value is present at index 2.
 *
 * Explanation 2:
 *
 * The target value is present at index 0.
 */
public class BinarySearchDriver {
    public static void main(String[] args) {

//        int[] array = {1, 3, 5, 6};//Test case #1 Happy flow - PASS
//        int targetValue = 5;
//
//        int[] array = {1};//Test case #2 - single element array - target exists in array - PASS
//        int targetValue = 1;
//
//        int[] array = {3};//Test case #3 - single element array - target absent in array - PASS
//        int targetValue = 87 ;
//
        //target element absent in array
//        int[] array = {3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993};//Test case #4
//        int targetValue = 902;


//        int[] array = {1, 3, 5, 6, 7};//Test case #5 element absent in the array
//        int targetValue = 4;


//        int[] array = {1, 3, 5, 6, 7};//Test case #5 element absent in the array - to be inserted near start of the array
//        int targetValue = 2;

        int[] array = {1, 3, 5, 6, 7};//Test case #6 target absent in array - to be inserted at end of array
        int targetValue = 8;

//        int[] array = {};//Test case #
//        int targetValue = ;

        BinarySearchTools binarySearchTools = new BinarySearchTools();
        int location = binarySearchTools.binarySearch(array, targetValue);
        System.out.println("location : " + location);
    }
}

class BinarySearchTools{
    public int binarySearch(int[] array, int targetValue) {

        int arraySize = array.length;

        if(arraySize == 1){
           return targetValue == array[0] ? 0 : 1;
        }

        int low = 0;
        int high = arraySize - 1;
        int mid = 0;

        while(low <= high){
            mid = (low + high) / 2;
            if(array[mid] == targetValue){
                return mid;
            }
            if(array[mid] < targetValue){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        //target not found in the array - corner case
        return low;
    }
}