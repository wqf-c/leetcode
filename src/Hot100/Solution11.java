package Hot100;

/**
 * @author wqf
 * @date 2021/2/26 15:58
 * @Email:284660487@qq.com
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right){
            int cur = (right - left) * Math.min(height[left], height[right]);
            if(cur > max) max = cur;
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
