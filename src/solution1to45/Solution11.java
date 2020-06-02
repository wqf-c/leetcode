package solution1to45;

/**
 * Author: wqf
 * Date: 2020/2/6
 * Time: 20:04
 */
public class Solution11 {

  /*
  如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
  但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
  因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。

作者：LeetCode
链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  * */
  public static int maxArea(int[] height) {
    return getMax(height, 0, height.length-1);
  }

  public static int getMax(int[] arr, int low, int high){
    if(low == high - 1){
      return Math.min(arr[high], arr[low]);
    }else if(low == high) return 0;

    int nextHigh = high;
    int nextLow = low;
    while (nextHigh > low && arr[nextHigh] <= arr[high]){
      nextHigh --;
    }
    while (high > nextLow && arr[nextLow] <= arr[low]){
      nextLow ++;
    }
    int now = (high - low) * Math.min(arr[high], arr[low]);

    return Math.max(Math.max(now, getMax(arr, nextLow, high)), getMax(arr, low, nextHigh));

  }

  public static int maxArea1(int[] height) {
    int maxarea = 0;
    int l = 0;
    int r = height.length - 1;
    while (l < r){
      int now = Math.min(height[l], height[r])*(r - l);
      maxarea = Math.max(now, maxarea);
      if(height[l] < height[r]){
        l ++;
      }else r --;
    }
    return maxarea;
  }

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{2,3,10,5,7,8,9}));
  }
}
