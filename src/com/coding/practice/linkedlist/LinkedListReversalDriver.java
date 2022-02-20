package com.coding.practice.linkedlist;

/**
 * @author Velmurugan
 * @date 16.02.2022
 */
public class LinkedListReversalDriver {
    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next =  new LinkedListNode(3);
        head.next.next.next =  new LinkedListNode(4);
        head.next.next.next.next =  new LinkedListNode(5);

        LinkedList linkedList = new LinkedList();
        LinkedListNode result = linkedList.reverseLinkedList(head);
        linkedList.printLinkedList(result);
    }
}


