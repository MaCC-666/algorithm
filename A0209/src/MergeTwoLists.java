import LinkedList.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        while (list1!=null&&list2!=null){
            //cur.next=list1.val<= list2.val?list1:list2;
            if(list1.val<= list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        cur.next=list1==null?list2:list1;
        return pre.next;
    }
}
