package stack;

import java.util.Stack;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。*/
public class IsValidDemo1 {
    public boolean isValid(String s) {
        if(s.length()==1)
            return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else {
                //注意这里如果出现类似s ="){"这种情况，字符s前面为反括号则会导致栈空
                //所以需要if特判
                if(stack.isEmpty())
                    return false;
                char t=stack.peek();
                if(c==')'&&t=='('||c=='}'&&t=='{'||c==']'&&t=='[')
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else {
            return false;
        }
    }
}
