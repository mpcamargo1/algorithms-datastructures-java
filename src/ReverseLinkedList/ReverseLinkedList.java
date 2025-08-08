package ReverseLinkedList;

import java.util.Map;

public class ReverseLinkedList {

    private ListNode head;

    private ListNode headInverted;

    public ReverseLinkedList(ListNode head) {
        this.head = head;
        this.headInverted = null;
    }


    public ListNode reverseList() {
        return reverseListRecursive(null, head);
    }

    private ListNode reverseListRecursive(ListNode previous, ListNode current) {
       if (current == null) {
            headInverted = new ListNode(previous.getVal());
            return headInverted;
       }

       ListNode nodeReversed = reverseListRecursive(current, current.getNext());

       if (previous == null) {
           return headInverted;
       }

       nodeReversed.setNext(new ListNode(previous.getVal()));
       return nodeReversed.getNext();
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(5 , new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode reversed = new ReverseLinkedList(list).reverseList();
    }
}
