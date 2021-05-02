package Hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wqf
 * @date 2021/4/22 18:48
 * @Email:284660487@qq.com
 */
public class Solution416 {

    public boolean canPartition(int[] nums) {
        return dfs(nums, 0, 0);
    }

    boolean dfs(int[] nums, int index, int target){
        if(target == 0 && index == nums.length){
            return true;
        }
        if(index == nums.length){
            return false;
        }
        if(dfs(nums, index + 1, target + nums[index])) return true;
        if(dfs(nums, index + 1, target - nums[index])) return true;
        return false;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        Arrays.sort(nums);
        return dfs1(nums, nums.length - 1, sum / 2);
    }

    boolean dfs1(int[] nums, int index, int target){
        if(target == 0){
            return true;
        }
        if(index == -1){
            return false;
        }
        if(dfs(nums, index - 1, target - nums[index])) return true;
        if(dfs(nums, index - 1, target)) return true;

        return false;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int[][] dp = new int[nums.length + 1][sum / 2 + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= nums.length; ++i){
            for(int j = 1; j <= sum/2; ++j){
                if(j - nums[i - 1] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length][sum / 2] == sum / 2;
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for(int i = 0; i < nums.length; ++i){
            dp[i][0] = true;
        }
        if(sum / 2 > nums[0]){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < nums.length; ++i){
            for(int j = 1; j <= sum/2; ++j){
                if(j - nums[i] >= 0){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length - 1][sum / 2];
    }

    public boolean canPartition4(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 1;  i < nums.length; ++i){
            for(int j = target; j >= nums[i]; --j){
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
