import LinkedList.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null || curB != null) {
            if (curA == curB)
                return curB;
            curA = curA == null ? curA = headB : curA.next;
            curB = curB == null ? curB = headA : curB.next;
        }
        return null;
    }
}
