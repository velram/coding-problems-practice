package com.coding.practice.linkedlist;


public class LinkedListDriver {
    public static void main(String[] args) {

        LinkedListNode head = populateLinkedListHead();
        LinkedListNode firstNode = new LinkedListNode(0);

        //Operation #1 - Print - LinkedList
        //Exected output : 1 -> 2 -> 3 -> 4
        LinkedList linkedList = new LinkedList();
        linkedList.printLinkedList(head);

        //Operation #2 - Insert @ start - LinkedList
        //Exected output : 0 -> 1 -> 2 -> 3 -> 4
        // (Refer line #10 for prev state of LinkedList)
        LinkedListNode result = linkedList.insertAtStart(head, 0);
        System.out.println("\n LinkedList after insertion @ start");
        linkedList.printLinkedList(result);

        //Operation #3 - Delete @ start  - LinkedList
        result = linkedList.deleteAtStart(result);
        System.out.println("\n LinkedList after deletion @ start");
        linkedList.printLinkedList(result);

        //Operation #4 - Insert @ end - LinkedList
        result = linkedList.insertAtEnd(result, 5);
        System.out.println("\n LinkedList after insertion @ end");
        linkedList.printLinkedList(result);

        //Operation #5 - Delete from end - LinkedList
        result = linkedList.deleteFromEnd(result);
        System.out.println("\n LinkedList after deletion @ end");
        linkedList.printLinkedList(result);

        //Operation #6 - Insert @ kth position - LinkedList
        result = linkedList.insertAtKthPosition(result, 3, 33);
        System.out.println("\n LinkedList after insertion @ Kth index");
        linkedList.printLinkedList(result);

        result = linkedList.insertAtKthIndexFromLast(result, 3, 333);
        System.out.println("\n LinkedList after insertion @ Kth index from last");
        linkedList.printLinkedList(result);

    }

    private static LinkedListNode populateLinkedListHead() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        LinkedListNode third = new LinkedListNode(3);
        LinkedListNode fourth = new LinkedListNode(4);

        head.next = second;
        head.next.next = third;
        head.next.next.next = fourth;

        return head;
    }
}
