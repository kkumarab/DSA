package linkedlists;

import java.util.Stack;

public class ReorderList {
//    You are given the head of a singly linked-list. The list can be represented as:
//
//    L0 → L1 → … → Ln - 1 → Ln
//    Reorder the list to be on the following form:
//
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    LinkedList.ListNode tempHead;

    public void reOrder(LinkedList.ListNode listNode, LinkedList.ListNode head){
        Stack<LinkedList.ListNode> listNodeStack = new Stack<>();
        while(listNode !=null){
            listNodeStack.push(listNode);
            listNode = listNode.next;
        }
        for(int i = 0; i< listNodeStack.size(); i++){
            if(head == listNodeStack.peek()){
                head.next = null;
                break;
            }
            if(head.next == listNodeStack.peek()){
                head.next = listNodeStack.pop();
                head.next.next = null;
                break;
            }
            LinkedList.ListNode listNodeToAdd = listNodeStack.pop();
            LinkedList.ListNode nextListNode = head.next;
            head.next = listNodeToAdd;
            listNodeToAdd.next = nextListNode;
            head = head.next.next;
        }

    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.populateLinkedList(linkedList);
        ReorderList obj = new ReorderList();
        obj.tempHead = linkedList.head;
        obj.reOrder(linkedList.head, linkedList.head);
        System.out.println("Done");
    }
}
