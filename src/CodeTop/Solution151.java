package CodeTop;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/30 17:04
 * @Email:284660487@qq.com
 */
public class Solution151 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = s.length() - 1; i >= 0;){
            if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
                i--;
            }else{
                if(!stack.empty()) {
                    if(sb.length() > 0){
                        sb.append(' ');
                    }
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }

                }
                while (i >= 0){
                    if(s.charAt(i) == ' ') i--;
                    else break;
                }
            }
        }
        if(!stack.empty() && sb.length() > 0){
            sb.append(' ');
        }
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords("EPY2giL"));
    }

}
