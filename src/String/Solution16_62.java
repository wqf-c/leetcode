package String;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/10/8 1:01
 * @Email:284660487@qq.com
 */
public class Solution16_62 {
//
//    1. 如果碰到数字， 则把数字入栈
//2. 如果碰到空格， 则继续下一步
//3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
//    A.如果是'+', 下一个数字num直接入栈
//    B.如果是'-'，-num入栈
//    C.如果是'*', num = stack.pop() * num, 入栈
//    D.如果是'/', num = stack.pop() / num, 入栈
//4. 最后，把栈里的数相加就是结果
//
//    作者：acw_weian
//    链接：https://leetcode-cn.com/problems/calculator-lcci/solution/java-si-lu-qing-xi-jian-ji-dai-ma-by-acw_weian/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

   // 由于题中明确没有（），所以不用判断符号的优先级。。。
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ' ') continue;
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                int numStart = i;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') ++i;
                int num = Integer.parseUnsignedInt(s.substring(numStart, i));
                i--;
                nums.push(num);
            }else{
                if(ops.isEmpty()) ops.push(c);
                else{
                    while (!ops.empty() && compare(ops.peek(), c)){
                        char op = ops.pop();
                        int num1 = nums.pop();
                        int num2 = nums.pop();
                        nums.push(operation(op, num2, num1));
                    }
                    ops.push(c);
                }
            }
        }
        while (!ops.empty()){
            char op = ops.pop();
            int num1 = nums.pop();
            int num2 = nums.pop();
            nums.push(operation(op, num2, num1));
        }
        return nums.peek();
    }

    public boolean compare(char c1, char c2){
        int value1 = (c1 == '+' || c1 == '-') ? 1 : 2;
        int value2 = (c2 == '*' || c2 == '/') ? 2 : 1;
        return value1 >= value2;
    }

    public int operation(char op, int num1, int num2){
        switch (op){
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }

    public static void main(String[] args){
        Solution16_62 s = new Solution16_62();
        s.calculate("1-1+1");
    }
}
