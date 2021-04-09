package Hot100;

/**
 * @author wqf
 * @date 2021/3/20 21:12
 * @Email:284660487@qq.com
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        int left = 0, right = 0;
        while (left <= right){
            if(left + nums[left] > right){
                right = left + nums[left];
            }
            left++;
            if(right >= nums.length - 1) return true;
        }
        return false;
    }

}
