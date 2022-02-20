package com.coding.practice.linkedlist;

public class LinkedList {

   LinkedListNode head;

   /**
    * Operation #1 - Print Linked list
    * Approach :
    * 1. Check for head is not null
    * 2. Check for next node is not empty
    * 3. Use temp variable for head access (don't access directly)
    * 4. Traverse till end of the list
    * 5. Print each node
    * @param head
    */
   public void printLinkedList(LinkedListNode head) {

      LinkedListNode temp = head;
      while(temp != null){
         System.out.print(temp.data + " -> ");
         temp = temp.next;
      }
   }

   /* Operation #2 - Insert @ start - LinkedList (Singly LinkedList)
      Approach :
       Make the current head point to the new node

       Test cases :
        1. Empty linked list
        2. Single node linked list
        3. Incoming node is empty / null
    */
   public LinkedListNode insertAtStart(LinkedListNode head, int data){
      LinkedListNode newNode = new LinkedListNode(data);
      LinkedListNode temp = head;
      newNode.next = temp;
      head = newNode;
      return head;
   }

   /** Operation #3 - Delete @ Start - LinkedList (Singly LinkedList)
    * Approach :
    *  - Create temp node & assign head to it.
    *  - Fetch head.next and store it in head.
    *  - Make head.next as head.
    *  - now Point the temp.next to null & Free-up the memory of temp
    *  - head.next as actual head
    *  - return head pointer
    *
    *  Edge cases -
    *   - Empty linked list
    *   - Single node in the list
    */
    public LinkedListNode deleteAtStart(LinkedListNode head){

       LinkedListNode temp = head;

       if(temp == null){
          System.out.println("Empty LinkedList can't be deleted");
          return null;
       }

       head = head.next; //Pointing new node as the head of the linkedList
       temp = null;
       System.gc();
       return head;
    }

   /**
    * Operation #4 - Insert @ end
    * Approach :
    *  - Traverse till the second last node of linkedList
    *  - Point the last node's next pointer to the new node
    *
    *  Edge cases :
    *   - Empty linked list
    *   - Single node in the linked list
     */

   public LinkedListNode insertAtEnd(LinkedListNode head, int data){

      if(head == null){
         new LinkedListNode(data);
      }

      LinkedListNode temp = head;

      //This loop will traverse till the last node
      while(temp.next != null){
         temp = temp.next;
      }

      //Now update the lastNode's next pointer to the new node.
      temp.next = new LinkedListNode(data);

      return head;
   }


    /**
     * Operation #5 - Delete from end - LinkedList
     *
     * Approach :
     * Iterate till the third last node
     * Change the
     * Remove the last node (make next pointer of 2nd last node as null)
     *
     */

    public LinkedListNode deleteFromEnd(LinkedListNode head){

        if(head == null){
            System.out.println("Empty linked list - Can not be deleted");
        }
        if(head.next == null){
            return null;
        }

        LinkedListNode temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.next = null;
        temp.next = null;
        //Free up the last node
        return head;
    }


    /**
     * Operation #6 - Insertion @ Kth Node
     *
     * Approach :
     *  - Navigate till N-1 th node.
     *  - Point the newNode to temp.next
     *  - Update the temp.next to newNode
     *
     * @param head
     * @param insertionIndex
     * @param newData
     * @return
     */
    public LinkedListNode insertAtKthPosition(LinkedListNode head, int insertionIndex, int newData) {

        if(head == null && insertionIndex > 1){
            System.out.println("Insertion index can not be greater than 1");
        }

        int loopIndex = 1;
        LinkedListNode temp = head;
        LinkedListNode newNode = new LinkedListNode(newData);
        if(insertionIndex == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }

        while(temp != null && loopIndex < insertionIndex - 1){
            temp = temp.next;
            loopIndex++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    /**
     * Operation #6 - Insert @ Kth position from end
     *
     * Approach :
     *  - Traverse the linkedList
     *  - Find the length of the linkedList
     *  - Subtract length of linkedList and insertionIndex
     */
     public LinkedListNode insertAtKthIndexFromLast(LinkedListNode head, int kthLastIndex, int newData) {
         System.out.println("Insert @ Kth Index from last : ");
         LinkedListNode temp = head;
         int length = findLength(temp);
         System.out.println("length : "+ length);
         int insertionIndex = (length - kthLastIndex) + 1;

         return insertAtKthPosition(head, insertionIndex, newData);
     }

    private int findLength(LinkedListNode temp) {
         int length = 0;
         if(temp == null) {
             return length;
         }

         while(temp != null) {
             length++;
             temp = temp.next;
         }

         return length;
    }


    /**
     * Operation #7 - Reverse a LinkedList
     *
     */
    public LinkedListNode reverseLinkedList(LinkedListNode head){

        LinkedListNode current = head;
        LinkedListNode next = null;
        LinkedListNode previous = null;

        if(head == null || head.next == null){
            return head;
        }

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }



}