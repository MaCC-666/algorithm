import LinkedList.ListNode;
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
        //if(fast==slow)//不可直接判断，因为极端条件只有一个节点的时候无法判断

            return true;
    }
}
