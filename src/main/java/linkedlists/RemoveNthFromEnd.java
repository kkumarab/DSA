package linkedlists;

public class RemoveNthFromEnd {
    int count =0;
    LinkedList.ListNode lastListNode = null;

    public LinkedList.ListNode removeNthFromEnd(LinkedList.ListNode head, int n) {
        LinkedList.ListNode fast = head;
        LinkedList.ListNode slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null)
            return head.next;
        while(fast.next!=null){
            slow = slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args){
        LinkedList obj = new LinkedList();
        LinkedList.ListNode one = new LinkedList.ListNode(1);
        obj.head = one;
        //obj.populateLinkedList(obj);
        obj.head = new RemoveNthFromEnd().removeNthFromEnd(obj.head,1);
        obj.printList(obj.head);
    }
}
