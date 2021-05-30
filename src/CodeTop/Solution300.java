package CodeTop;

/**
 * @author wqf
 * @date 2021/5/22 15:52
 * @Email:284660487@qq.com
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > dp[len]){
                dp[++len] = nums[i];
            }else{
                int left = 1, right = len, pos = 0;
                while (left <= right){
                    int mid = (left + right) / 2;
                    if(dp[mid] < nums[i]){
                        pos = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
