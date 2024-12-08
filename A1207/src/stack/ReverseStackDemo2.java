package stack;

import java.util.Stack;



    public class ReverseStackDemo2 {

        public static void main(String[] args) {
            Stack<String> stack = new Stack<>();
            stack.push("a");
            stack.push("b");
            stack.push("c");

            reverse(stack);
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        // 修正后的removeLast方法，添加泛型类型参数的传入，使其明确类型
        public static <E> E removeLast(Stack<E> stack) {
            E element = stack.pop();
            if (stack.isEmpty()) {
                return element;
            }
            E lastElement = removeLast(stack);
            stack.push(element);
            return lastElement;
        }

        // 修正后的reverse方法，添加终止条件判断，避免无限递归
        public static <E> void reverse(Stack<E> stack) {
            if (stack.isEmpty()) {
                return;
            }
            E lastElement = removeLast(stack);
            reverse(stack);
            stack.push(lastElement);
        }
    }

