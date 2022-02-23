package com.coding.practice.linkedlist;

/**
 * Problem Description
 *
 * Given a singly linked list A
 *
 *  A: A0 → A1 → … → An-1 → An
 *
 * reorder it to:
 *
 *  A0 → An → A1 → An-1 → A2 → An-2 → …
 *
 * You must do this in-place without altering the nodes' values.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 106
 *
 *
 * Input Format
 *
 * The first and the only argument of input contains a pointer to the head of the linked list A.
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
 *  A = [1, 2, 3, 4, 5]
 *
 * Input 2:
 *
 *  A = [1, 2, 3, 4]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 5, 2, 4, 3]
 *
 * Output 2:
 *
 *  [1, 4, 2, 3]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 *
 * Explanation 2:
 *
 *  The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class ReorderListDriver {
    public static void main(String[] args) {

        LinkedListReorderTools linkedListReorderTools = new LinkedListReorderTools();

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next =  new LinkedListNode(3);
        head.next.next.next =  new LinkedListNode(4);
        head.next.next.next.next =  new LinkedListNode(5);
        head.next.next.next.next.next =  new LinkedListNode(6);
        head.next.next.next.next.next.next =  new LinkedListNode(7);
        //head.next.next.next.next.next.next.next =  new LinkedListNode(8);

        LinkedList linkedList = new LinkedList();
        System.out.println("LinkedList before reordering : ");
        linkedList.printLinkedList(head);

        linkedListReorderTools.deleteAtEnd(head);
        System.out.println("LinkedList after deleting : ");
        linkedList.printLinkedList(head);

    }
}


class LinkedListReorderTools {
    public LinkedListNode reorderList(LinkedListNode head){

        LinkedListNode reorderedListHead = null;

        LinkedListNode[] result = deleteAtEnd(head);
        

        return reorderedListHead;
    }

    public LinkedListNode[] deleteAtEnd(LinkedListNode head){

        LinkedListNode current = head;
        LinkedListNode deletedNode = null;
        LinkedListNode[] result = new LinkedListNode[2];

        if(head.next == null){
            result[0] = null;
            result[1] = head;
            return result;
        }

        while(current.next.next != null){
         current = current.next;
        }
        result[1] = current.next.next;
        current.next = null;
        result[0] = head;

        return result;
    }
}
