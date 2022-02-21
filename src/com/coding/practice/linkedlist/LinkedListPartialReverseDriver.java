package com.coding.practice.linkedlist;

/**
 * @author Velmurugan
 * @date 21.02.2022
 *
 * Problem Description :
 *
 * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return modified linked list.
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 103
 *
 * B always divides A
 *
 *
 *
 * Input Format
 *
 * The first argument of input contains a pointer to the head of the linked list.
 *
 * The second arugment of input contains the integer, B.
 *
 *
 *
 * Output Format
 *
 * Return a pointer to the head of the modified linked list.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5, 6]
 *  B = 2
 *
 * Input 2:
 *
 *  A = [1, 2, 3, 4, 5, 6]
 *  B = 3
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [2, 1, 4, 3, 6, 5]
 *
 * Output 2:
 *
 *  [3, 2, 1, 6, 5, 4]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  For the first example, the list can be reversed in groups of 2.
 *     [[1, 2], [3, 4], [5, 6]]
 *  After reversing the K-linked list
 *     [[2, 1], [4, 3], [6, 5]]
 *
 * Explanation 2:
 *
 *  For the second example, the list can be reversed in groups of 3.
 *     [[1, 2, 3], [4, 5, 6]]
 *  After reversing the K-linked list
 *     [[3, 2, 1], [6, 5, 4]]
 */
public class LinkedListPartialReverseDriver {
    public static void main(String[] args) {

    }
}

class LinkedListPartialReverseTool {
    /*
     * Approach :
     *  1. Invoke reversal operation only till size k.
     *
     * Test cases :
     *  If k = list size - reverse entire list - Edge case
     *  If k = 1 - return as is (no change) - Edge case
     *  If single node list - Edge case
     */
    public LinkedListNode reverseListInGroups(LinkedListNode head, int reversalSize){

        if(reversalSize == 1 || head == null || head.next == null){
            return head;
        }



        return null;
    }

    private LinkedListNode reverseList(LinkedListNode head, int reversalSize){



        return null;
    }
}