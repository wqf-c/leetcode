package Array;

/**
 * @author wqf
 * @date 2020/9/23 22:26
 * @Email:284660487@qq.com
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right){
            while (height[left] <= height[right] && left < right){
                max = Math.max(max,  height[left] * (right - left));
                left++;
            }
            while (height[right] <= height[left] && right > left){
                max = Math.max(max,  height[right] * (right - left));
                right--;
            }
        }

        return max;
    }

}
