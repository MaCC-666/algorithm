package stack;

public class demo1 {
    public static void main(String[] args) {
        StackQueue<Integer> sq=new StackQueue<>();
        sq.add(3);
        sq.add(8);
        sq.add(2);
        sq.add(1);
        for (int i = 0; i < 4; i++) {
            System.out.println(sq.poll());
        }
    }
}
