package linkedlists;

import static org.linkedlist.LinkedList.*;
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyListNode = new ListNode(-1);
        ListNode temp = dummyListNode;

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyListNode.next;
    }

    public static void main(String[] args){
        LinkedList list_one = new LinkedList();
        LinkedList list_two = new LinkedList();
        ListNode l1_n1 = new ListNode(1);
        ListNode l1_n2 = new ListNode(2);
        l1_n1.next = l1_n2;
        ListNode l1_n3 = new ListNode(4);
        l1_n2.next = l1_n3;
        list_one.head = l1_n1;
        ListNode l2_n1 = new ListNode(1);
        ListNode l2_n2 = new ListNode(3);
        l2_n1.next = l2_n2;
        ListNode l2_n3 = new ListNode(4);
        l2_n2.next = l2_n3;
        list_two.head = l2_n1;

        ListNode result = new MergeTwoLists().mergeTwoLists(list_one.head,list_two.head);
        System.out.println("DOne");
    }
}
