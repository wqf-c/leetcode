package solution1to45;

import java.util.Stack;

/**
 * Author: wqf
 * Date: 2020/2/14
 * Time: 21:41
 */
public class solution20 {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); ++i){
      char ch = s.charAt(i);
      if(ch == '(' || ch == '[' || ch == '{'){
        stack.push(ch);
      }else{
        if(stack.empty()) return false;
        char c = stack.pop();
        if(!((c == '(' && ch == ')') || (c == '{' && ch == '}') || (c == '[' && ch == ']'))){
          return false;
        }
      }
    }
    return stack.empty();
  }
}
