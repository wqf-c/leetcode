package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/4/24 14:00
 * @Email:284660487@qq.com
 */
public class Solution494 {


    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> lastMap = new HashMap<>();
        if(nums[nums.length - 1] == 0){
            lastMap.put(0, 2);
        }else{
            lastMap.put(nums[nums.length - 1], 1);
            lastMap.put(-1 * nums[nums.length - 1], 1);
        }
        for(int i = nums.length - 2; i >= 0; --i){
            Map<Integer, Integer> map = new HashMap<>();
            final int iFinal = i;
            lastMap.entrySet().forEach(integerIntegerEntry -> {
                int key = integerIntegerEntry.getKey();
                int val = integerIntegerEntry.getValue();
                int key1 = key + nums[iFinal];
                int key2 = key - nums[iFinal];
                map.put(key1, map.getOrDefault(key1, 0) + val);
                map.put(key2, map.getOrDefault(key2, 0) + val);
            });
            lastMap = map;
        }
        return lastMap.getOrDefault(target, 0);
    }

    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
        }
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][nums[0] + sum] ++;
        dp[0][-1 * nums[0] + sum]++;
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < sum * 2 + 1; ++j){
                if(dp[i - 1][j] != 0){
                    dp[i][j - nums[i]] += dp[i - 1][j];
                    dp[i][j + nums[i]] += dp[i - 1][j];
                }
            }
        }
        if(target + sum < sum * 2 + 1){
            return dp[nums.length - 1][target + sum];
        }else{
            return 0;
        }

    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        solution494.findTargetSumWays1(new int[]{1, 1, 1, 1, 1}, 3);
    }


}
