package stack;
import java.util.Stack;
//设计一个有getMin功能的栈
//        【题目】
//        实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
//        【要求】
//        1.pop、push、getMin操作的时间复杂度都是O（1）。
//        2.设计的栈类型可以使用现成的栈结构。
//        【难度】
//        士 ★☆☆☆
public class GetMinStack {//不能类定义时使用Java已经预定好的包装类Integer,,,
    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public GetMinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public int pop(){//如何处理stack为空的情况
        if (stack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        else {
            int count =stack.pop();
            if(count==minStack.peek()){
                minStack.pop();
            }
            return count;
        }
    }
    public void push(int num){
        stack.push(num);
        if(stack.isEmpty()){
            minStack.push((num));
        }
        else {
            if(num<=minStack.peek())
                minStack.push(num);
        }
    }
    public int getMin(){
        if(stack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        else
            return minStack.peek();
    }
}
