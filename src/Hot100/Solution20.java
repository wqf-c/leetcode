package Hot100;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/3/5 15:57
 * @Email:284660487@qq.com
 */
public class Solution20 {

    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array){
            if(c == '[' || c =='(' || c =='{') stack.push(c);
            else{
                if(stack.empty()) return false;
                if(match(stack.peek(), c)) stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }

    boolean match(char c1, char c2){
        switch (c1){
            case '(':
                return c2 == ')';
            case '[':
                return c2 == ']';
            case '{':
                return c2 == '}';
            default:
                return false;
        }
    }

}
