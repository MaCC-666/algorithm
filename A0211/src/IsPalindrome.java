import LinkedList.ListNode;

import java.util.List;

public class IsPalindrome {
//    public boolean isPalindrome(ListNode head) {
//        ListNode fast=head;
//        ListNode slow=head;
//        while (fast!=null&&fast.next!=null){
//            fast=fast.next.next;
//
//            ListNode swap=slow.next;
//            ListNode newHead=slow;
//            slow.next=swap.next;
//            swap.next=newHead;
//            newHead=swap;
//
//        }
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode tail=null;
        ListNode pre=null;
        while (slow!=null){
            ListNode next=slow.next;
            slow.next=tail;
            pre=slow;
            slow=next;
        }

        while (pre!=null){
            if(head.val!=pre.val)
                return false;
        }
        head=head.next;
        pre=pre.next;
        return true;
    }
}
