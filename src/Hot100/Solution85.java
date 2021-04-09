package Hot100;

import java.util.Stack;

/**
 * @author wqf
 * @date 2021/3/29 22:43
 * @Email:284660487@qq.com
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            int temp = largestRectangleArea(height);
            if(temp > max) max = temp;
        }
        return max;
    }

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

}
