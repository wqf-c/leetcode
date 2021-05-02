package Hot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wqf
 * @date 2021/5/2 18:30
 * @Email:284660487@qq.com
 */
public class Solution739 {

    public int[] dailyTemperatures(int[] T) {
        int[] temp = new int[101];
        Arrays.fill(temp, -1);
        int[] rst = new int[T.length];
        if(T.length == 0) return rst;
        rst[T.length - 1] = 0;
        temp[T[T.length - 1]] = T.length - 1;

        for(int i = T.length - 2; i >= 0; --i){
            int t = T[i];
            int min = 40000;
            for(int j = t + 1; j < temp.length; ++j){
                if(temp[j] != -1 && temp[j] < min){
                    min = temp[j];
                }
            }
            if(min != 40000){
                rst[i] = min - i;
            }else{
                rst[i] = 0;
            }
            temp[T[i]] = i;
        }
        return rst;
    }

    //单调栈  判别是否需要使用单调栈，如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈
    public int[] dailyTemperatures1(int[] T) {

        int[] rst = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        //stack.push(Integer.MAX_VALUE);
        //单调递减
        for(int i = 0; i < T.length; ++i){
            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.push(i);
            }else{
                while (!stack.empty() && T[stack.peek()] < T[i]){
                    int top = stack.pop();
                    rst[top] = i - top ;
                }
                stack.push(i);
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        for(int i : solution739.dailyTemperatures1(new int[]{73,74,75,71,69,72,76,73})){
            System.out.println(i);
        }
    }

}
