package linkedlists;

import static org.linkedlist.LinkedList.ListNode;

public class AddNumbers {
//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]
//    Explanation: 342 + 465 = 807.
    int power=-1;
    int sum =0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return l1;
    }



    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.populateLinkedList(l1);
        new AddNumbers().addTwoNumbers(l1.head,l1.head);
    }
}
