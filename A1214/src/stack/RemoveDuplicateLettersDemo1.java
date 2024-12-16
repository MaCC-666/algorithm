package stack;
import java.util.Stack;
public class RemoveDuplicateLettersDemo1 {
    /*
    * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序
    最小（要求不能打乱其他字符的相对位置）。
    * 输入：s = "bcabc"
    输出："abc"
    示例 2：
    输入：s = "cbacdcbc"
    输出："acdb"
    * */
    public String removeDuplicateLetters(String s) {
        //1.去掉重复字母做准备，存储记录字符数量。
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        //StringBuilder ans=new StringBuilder(26);
        Stack<Character> ans = new Stack<>();//用队列也可
        boolean[] inAns = new boolean[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']--;
            if (ans.isEmpty() || arr[c - 'a'] == 0) {
                ans.push(c);
                inAns[c - 'a'] = true;
            }
            if (inAns[c - 'a']) {
                continue;
            }
            char ch = ans.peek();

            //注意这应该是while
           // 输入：s = "cbacdcbc"
            //输出："acdb"
            if (c < ch && arr[ch - 'a'] > 0) {
                inAns[ch - 'a'] = false;
                ans.pop();
            }
            ans.push(c);
            inAns[c - 'a'] = true;
        }
        StringBuilder str=new StringBuilder();
        while (!ans.isEmpty()){
            str.append(ans.pop());
        }
        return str.reverse().toString();
    }
}
