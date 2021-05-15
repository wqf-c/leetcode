package CodeTop;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/12 21:31
 * @Email:284660487@qq.com
 */
public class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }
                char peek = stack.peek();
                if((c == ')' && peek == '(') || (c == ']' && peek == '[') || (c == '}' && peek == '{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
