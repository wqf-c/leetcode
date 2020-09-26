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
        while (left < right){

        }

        return Math.max(height[left], height[right]) * (right - left);
    }

}
