package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/21
 * Time: 21:49
 */
public class Solution42 {

  public static void main(String[] args) {
    System.out.println(trap(new int[]{9,6,8,8,5,6,3}));
  }
  public static int trap(int[] height) {
    if(height.length <= 1) return 0;
    int left = 0;
    int right = height.length - 1;
    int result = 0;
    while (left < height.length - 1 && height[left + 1] >= height[left]) left ++;
    while (right > 0 && height[right - 1] >= height[right]) right --;
    System.out.println(left + "  " + right);
    while (left < right){
      int pointer = left + 1;
      int count = 0;
      while (height[pointer] < height[left] && pointer < right){
        count += height[left] - height[pointer];
        pointer ++;
      }
      System.out.println(pointer);
      if(pointer < right || (pointer == right && height[right] >= height[left])){
        result += count;
        if(pointer == right) return result;
        left = pointer;
      }else{
        break;
      }
    }
    while (right > left){
      int pointer = right - 1;
      int count = 0;
      while (height[pointer] < height[right] && pointer > left){
        count += height[right] - height[pointer];
        pointer --;
      }
      result += count;
      right = pointer;
    }
    return result;
  }

  //c++双指针  理解见官方·解答第二条评论
//  int trap(vector<int>& height)
//  {
//    int left = 0, right = height.size() - 1;
//    int ans = 0;
//    int left_max = 0, right_max = 0;
//    while (left < right) {
//      if (height[left] < height[right]) {
//        height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
//        ++left;
//      }
//      else {
//        height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
//        --right;
//      }
//    }
//    return ans;
//  }
//
//  作者：LeetCode
//  链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  //动态规划
//  public int trap(int[] height) {
//    int sum = 0;
//    int[] max_left = new int[height.length];
//    int[] max_right = new int[height.length];
//
//    for (int i = 1; i < height.length - 1; i++) {
//      max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//    }
//    for (int i = height.length - 2; i >= 0; i--) {
//      max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//    }
//    for (int i = 1; i < height.length - 1; i++) {
//      int min = Math.min(max_left[i], max_right[i]);
//      if (min > height[i]) {
//        sum = sum + (min - height[i]);
//      }
//    }
//    return sum;
//  }
//
//  作者：windliang
//  链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
