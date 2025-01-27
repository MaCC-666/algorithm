package LinkedList;
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode cur = this;
        while (cur != null){
            builder.append(cur.val);
            if (cur.next != null){
                builder.append(",");
            }
            cur = cur.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
