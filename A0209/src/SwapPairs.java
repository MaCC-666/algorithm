import LinkedList.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //1、递归
        if(head==null||head.next==null)
            return head;
        ListNode swap=head.next;
        //ListNode newHead=swap.next;
        head.next=swapPairs(swap.next);
        swap.next=head;
        return swap;
    }
}
