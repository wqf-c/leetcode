package Hot100;

/**
 * @author wqf
 * @date 2021/4/11 22:13
 * @Email:284660487@qq.com
 */
public class Solution198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(null == nums || nums.length == 0){
            return 0;
        }
        dp[0] = nums[0];
        if(nums.length > 1){
            dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        }
        for(int i = 2; i < nums.length; ++i){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

}
