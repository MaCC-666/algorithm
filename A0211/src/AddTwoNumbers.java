import LinkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        int add=0;
        while (l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+add;
            add=sum/10;
            sum=sum%10;
            cur.next=new ListNode(sum);
            cur=cur.next;
        }
        if(add==1){
            cur.next=new ListNode(1);
        }
        return dummy.next;
    }
}
