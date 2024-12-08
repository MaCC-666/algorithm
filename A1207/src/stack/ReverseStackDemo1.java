package stack;

import java.util.Stack;
//如何仅用递归函数和栈操作逆序一个栈
//        【题目】
//        一个栈依次压入1、2、3、4、5，
//        那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，
//        从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
//        【难度】
//        尉 ★★☆☆
public class ReverseStackDemo1{
    //先确定递归函数作用反转栈元素顺序
    //拆分成子问题---->取出最后一个元素，再将其上面元素逆序，再push最后一个元素。
    //递归临界条件

    //需要回顾的知识点；
    //静态方法以及成员方法调用关系
    //泛型
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    //为什么 public static  T removeLast(Stack<T> stack) 会报错
    public static <T> T removeLast(Stack<T> stack){
        T element=stack.pop();
        if(stack.isEmpty()){
            return element;
        }
        T lastElement =removeLast(stack);
        stack.push(element);
        return lastElement;
    }
    public static <T> void reverse(Stack<T> stack){
        T lastElement=removeLast(stack);
        reverse(stack);
        stack.push(lastElement);
    }
}
