package solution46to90;


import java.util.Stack;

public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxRectangle = 0;
        int[] heights = new int[n + 1];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if (matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            if(i == 2){
                maxRectangle = Math.max(maxRectangle, largestRectangleArea(heights));
            }else{
                maxRectangle = Math.max(maxRectangle, largestRectangleArea(heights));
            }

        }
        return maxRectangle;
    }

    public int largestRectangleArea(int[] height){
        Stack<Integer> sta = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < height.length; ++i){
            int temp = height[i];
            while (!sta.empty() && height[sta.peek()] >= temp){
                int top = sta.pop();
                maxArea = Math.max(maxArea, height[top] * (sta.empty() ? i : (i - sta.peek() - 1)));
            }
            sta.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution85 s = new Solution85();
        char[][] ma = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(s.maximalRectangle(ma));
    }

}
