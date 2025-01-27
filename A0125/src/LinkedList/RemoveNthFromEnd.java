package LinkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //删除节点-->先创建虚拟头节点
        ListNode dmy=new ListNode(666,head);
        ListNode pre=dmy;
        ListNode p=dmy;
        //简单试测时，要注意挑的例子有没有代表性，正常情况下这样是否依然得到同样结果
        //数字不敏感--(试一法，最简单化,但考虑清楚前提条件，正一和倒一均一样的话，就无意义，例如1个节点，删除倒数第1，试用无意义)
        //删除节点：直接找到删除节点的前一个位置即可解决问题
        while (n!=0){
            p=p.next;
            n--;
        }
        while (p.next!=null){//注意是p.next，也就是最后一个节点
            p=p.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return dmy.next;
    }
}
