import LinkedList.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //1、找到中间节点
        //2、反转后面链表
        //3、开始比较
        if(head.next==null)
            return true;

        ListNode o1=head;
        ListNode o2=head;
        while(o2!=null&&o2.next!=null){
            o1=o1.next;
            o2=o2.next.next;
        }
        ListNode mid=o1.next;
        ListNode newHead=o1.next;
        ListNode o4=newHead;
        while (newHead.next!=null){
            ListNode o3=newHead.next;
            newHead.next=o3.next;
            o3.next=o4;
            o4=o3;
        }
        while (mid!=null){
            if(mid.val!=head.val)
                break;
            mid=mid.next;
            head=head.next;
        }
        if(mid==null)
            return true;
        else
            return false;
    }
}
