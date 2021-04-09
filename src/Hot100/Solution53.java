package Hot100;

/**
 * @author wqf
 * @date 2021/3/20 21:08
 * @Email:284660487@qq.com
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(pre > 0) pre = pre + nums[i];
            else pre = nums[i];
            if(pre > max) max = pre;
        }
        return max;
    }

}
