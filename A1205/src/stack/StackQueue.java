package stack;

import java.util.Stack;

//由两个栈组成的队列
//        【题目】
//        编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
//        【难度】
//        尉 ★★☆☆
public class StackQueue<T> {
    Stack<T> headStack;
    Stack<T> tailStack;

    public StackQueue() {
        this.headStack=new Stack<>();
        this.tailStack=new Stack<>();
    }
    public void add(T t){
        tailStack.push(t);
    }
    public T poll(){
        swap();
        return headStack.pop();
    }
    public T peek(){
        swap();
        return headStack.peek();
    }
    private void swap(){
        if(headStack.isEmpty()&&tailStack.isEmpty())
            throw new RuntimeException("your stack is empty");
        else if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()){
                headStack.push(tailStack.pop());
            }
        }
    }
}
