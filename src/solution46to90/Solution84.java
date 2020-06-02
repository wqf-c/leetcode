package solution46to90;

import java.util.Stack;

/**
 * Author: wqf
 * Date: 2020/4/20
 * Time: 20:59
 */
public class Solution84 {

  //单调栈
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> sta = new Stack<>();
    int maxArea = 0;
    for(int i = 0; i <= heights.length; ++i){
      int temp = 0;
      if(i == heights.length) temp = 0;
      else temp = heights[i];
      while (!sta.empty() && temp < heights[sta.peek()]){
        int top = sta.pop();
        maxArea = Math.max(maxArea, heights[top] * (sta.empty() ? i : (i - sta.peek() - 1)));
      }
      sta.push(i);
    }
    return maxArea;
  }

  //分治算法
  public int calculateArea(int[] heights, int start, int end) {
    if (start > end)
      return 0;
    int minindex = start;
    for (int i = start; i <= end; i++)
      if (heights[minindex] > heights[i])
        minindex = i;
    return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
  }
  public int largestRectangleArea1(int[] heights) {
    return calculateArea(heights, 0, heights.length - 1);
  }


}
