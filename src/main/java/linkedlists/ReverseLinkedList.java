package linkedlists;
import static linkedlists.LinkedList.*;

public class ReverseLinkedList {

    public void reverseLinkedList(ListNode node,ListNode oldHead, LinkedList lst){
        if(node.next == null){
            lst.head = node;
            return;
        }
        reverseLinkedList(node.next,oldHead,lst);
        node.next.next = node;
        if(node == oldHead)
            node.next = null;
    }
}
