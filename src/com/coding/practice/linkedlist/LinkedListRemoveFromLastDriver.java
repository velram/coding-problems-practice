package com.coding.practice.linkedlist;

/**
 * @author Velmurugan
 * @date 18.02.2022
 * Problem description :
 *
 * Given a linked list A, remove the B-th node from the end of list and return its head.
 *
 * For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * NOTE: If B is greater than the size of the list, remove the first node of the list.
 *
 * NOTE: Try doing it using constant additional space.
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
 * The first argument of input contains a pointer to the head of the linked list.
 *
 * The second argument of input contains the integer B.
 *
 *
 *
 * Output Format
 *
 * Return the head of the linked list after deleting the B-th element from the end.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 2
 *
 * Input 2:
 *
 * A = [1]
 * B = 1
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [1, 2, 3, 5]
 *
 * Output 2:
 *
 *  []
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * In the first example, 4 is the second last element.
 *
 * Explanation 2:
 *
 * In the second example, 1 is the first and the last element.
 *
 */
public class LinkedListRemoveFromLastDriver {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        LinkedListNode head = populateLinkedList();

        System.out.println("LinkedList before removing Kth Last node");
        linkedList.printLinkedList(head);

        LinkedListLastNodeRemovalDriver listLastNodeRemovalDriver = new LinkedListLastNodeRemovalDriver();
        LinkedListNode result = null;
        //Test case #1 - Happy flow - PASS
        //result = listLastNodeRemovalDriver.removeKthLastNode(head, 2);

        //Test case #2 - KthLastIndex > listSize - PASS
         //result = listLastNodeRemovalDriver.removeKthLastNode(head, 8);

        //Test case #3 - Single node list & k = 1  - PASS
        //result = listLastNodeRemovalDriver.removeKthLastNode(new LinkedListNode(1), 1);

        //Test case #4 - Delete first element in the list - PASS
        //result = listLastNodeRemovalDriver.removeKthLastNode(head, 7);


        //Test case #5 - Delete middle element in the list - PASS
        result = listLastNodeRemovalDriver.removeKthLastNode(head, 4);

        System.out.println("\n LinkedList after removing Kth Last node");
        linkedList.printLinkedList(result);
    }

    private static LinkedListNode populateLinkedList() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head.next.next.next.next.next.next = new LinkedListNode(7);
        return head;
    }
}

class LinkedListLastNodeRemovalDriver {

    /**
     * Approach :
     *  - Traverse thru the entire list
     *  - count the list length
     *  - Subtract length of list & Kth last index
     *  Then traverse till the K-1 index.
     *  Copy the second next of the k-1 node
     *  Point the k-1 node.next to second next node (from k-1)
     *  Now, Point kth node.next to null
     *
     *  Edge cases :
     *   - (k-1) > length of the list
     *   - Single node linked list
     *   - Empty linked list
     *
     * @param head
     * @param kthLastIndex
     * @return
     */
    public LinkedListNode removeKthLastNode(LinkedListNode head, int kthLastIndex){

        int listSize = findListSize(head);

        if(kthLastIndex >= listSize) { //This handles single list too
            return removeFirstNode(head);
        }

        int requiredIndex = (listSize - kthLastIndex);
        int currentIndex = 1;
        LinkedListNode currentNode = head;


        while(currentIndex < requiredIndex){
            currentIndex++;
            currentNode = currentNode.next;
        }
        LinkedListNode oldNext = currentNode.next;
        LinkedListNode newNext = null;
        if(currentNode.next != null){
            newNext = currentNode.next.next;
        }
        currentNode.next = newNext;
        oldNext = null;

        return head;
    }

    private LinkedListNode removeFirstNode(LinkedListNode head) {
        LinkedListNode oldHead = head;
        LinkedListNode newHead = head.next;
        head = head.next;
        oldHead = null;
        return head;
    }

    private int findListSize(LinkedListNode head) {
        if(head == null)
            return 0;
        LinkedListNode currentNode = head;
        int listSize = 0;
        while(currentNode != null){
            listSize++;
            currentNode = currentNode.next;
        }
        return listSize;
    }
}
