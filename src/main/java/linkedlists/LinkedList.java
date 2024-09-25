package linkedlists;

public class LinkedList {

    ListNode head;

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int val){
            this.value = val;
            next = null;
        }
    }

    public void reverseLinkedList(ListNode listNode, ListNode old_head){
        if(listNode.next==null){
            this.head = listNode;
            return;
        }
        reverseLinkedList(listNode.next,old_head);
        listNode.next.next = listNode;
        if(listNode.equals(old_head))
            listNode.next = null;
    }

    public void printList(ListNode listNode){
        if(listNode.next == null){
            System.out.println(listNode.value);
            return;
        }
        System.out.print(listNode.value +",");
        printList(listNode.next);
    }

    public void populateLinkedList(LinkedList linkedList){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        linkedList.head = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.populateLinkedList(linkedList);
    }



}
