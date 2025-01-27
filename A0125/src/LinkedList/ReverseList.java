package LinkedList;
public class ReverseList {
    //1.递归解决
    public ListNode reverseList1(ListNode head) {
        //
        if(head==null||head.next==null)
            return head;
       ListNode last=reverseList1(head.next);
       head.next.next=head;
       head.next=null;
       return last;
    }
    //思路二：标记头节点，将头结点后的下一个节点逐个当头按照即可，注意边界
    //1.循环条件没问题，边界没问题，实现逻辑思路：先存新头，再存新头后面的链尾，再更新上述操作
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
       ListNode o1=head;
       ListNode n1=head;
       while (o1.next!=null){
           head=o1.next;
           ListNode temp=o1.next.next;
           o1.next.next=n1;
           o1.next=temp;
           n1=head;
       }
       return head;
    }
}
