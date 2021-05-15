package CodeTop;

import java.util.Map;

/**
 * @author wqf
 * @date 2021/5/3 20:58
 * @Email:284660487@qq.com
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0], prevMax = nums[0];
        for(int i = 1; i < nums.length; ++i){
            prevMax = Math.max(prevMax + nums[i], nums[i]);
            if(prevMax > max) max = prevMax;
        }
        return max;
    }

}
