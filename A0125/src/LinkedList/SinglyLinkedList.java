package LinkedList;

import java.util.function.Consumer;

//单向链表
public class SinglyLinkedList {
    private Node head=new Node(666,null);//头指针-->哨兵节点
    private Node tail;//尾指针;

    private static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addLast(int value){
        Node newNode = new Node(value, null);
        if (tail == null) { // 如果链表为空，head 和 tail 都指向新节点
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // 将当前尾节点的 next 指向新节点
            tail = newNode; // 更新 tail 指向新节点
        }
    }
    public void addFirst(int value) {
//        //1.链表为空
//        head=new Node(value,null);
        //2.链表非空
        head=new Node(value,head);
        if (tail == null) { // 如果链表为空，tail 也需要指向新节点
            tail = head;
        }
    }
   private Node findNode(int index){
        int i=0;
        for (Node p=head;p!=null;p=p.next,i++){
            if (i==index){
                return p;
            }
        }
    return null;
}
    public int get(int index){
        Node p=findNode(index);
        if (p==null){
            throw new RuntimeException("index out of bound");
        }
        return p.value;
    }


    public void loop1(Consumer<Integer> consumer){
        Node p=head;
        while (p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for(Node p=head;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    private void recursion(Node p){
        if (p==null){
            return;
        }
        System.out.println(p.value);
        recursion(p.next);
    }
    public void loop3(){
        recursion(head.next);
    }

}
