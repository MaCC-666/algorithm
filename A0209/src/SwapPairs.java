import LinkedList.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode newHead=dummy;
        while (head!=null&&head.next!=null){
            ListNode swap=head.next;
            head.next=swap.next;
            newHead.next=swap;
            swap.next=head;
            newHead=head;
            head=head.next;
        }
        return dummy.next;
    }
    //1、递归
//        if(head==null||head.next==null)
//            return head;
//        ListNode swap=head.next;
//        head.next=swapPairs(swap.next);
//        swap.next=head;
//        return swap;
}
