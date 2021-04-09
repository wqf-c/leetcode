package Hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/3/6 18:52
 * @Email:284660487@qq.com
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<>();
        if(n == 0) return rst;
        char[] chars = new char[2 * n];
        chars[0] = '(';
        func(n - 1, n, chars, 1, rst);
        return rst;
    }

    public void func(int left, int right, char[] chars, int charIndex, List<String> rst){
        if(left == 0 && right == 0){
            rst.add(new String(chars));
            return;
        }
        if(left == 0){
            chars[charIndex] = ')';
            func(left , right - 1, chars, charIndex + 1, rst);
        }else{
            if(left < right){
                chars[charIndex] = ')';
                func(left , right - 1, chars, charIndex + 1, rst);
            }
            chars[charIndex] = '(';
            func(left - 1, right, chars, charIndex + 1, rst);
        }
    }
}
