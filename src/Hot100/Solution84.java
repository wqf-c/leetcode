package Hot100;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/3/29 16:22
 * @Email:284660487@qq.com
 */
public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= heights.length; ++i){
            int temp = i < heights.length ? heights[i] : 0;
            while (!stack.empty() && heights[stack.peek()] > temp){
                int top = stack.pop();
                max = Math.max(max, heights[top] * (stack.empty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args){
        Solution84 solution84 = new Solution84();
        System.out.println(solution84.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4}));
    }
}
