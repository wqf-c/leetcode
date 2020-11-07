package DP;

import solution1to45.Solution30;

/**
 * @author wqf
 * @date 2020/10/25 19:42
 * @Email:284660487@qq.com
 */
public class Solution300 {
//[1,3,6,7,9,4,10,5,6]
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            int cur = nums[i];
            int m = 0;
            for(int j = i - 1; j >= 0; --j){
                if(nums[j] < cur && dp[j] > m){
                    m = dp[j];
                }
            }
            dp[i] = m + 1;
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    //贪心 + dp O(nlogn)
    public int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args){
        Solution300 solution300 = new Solution300();
        solution300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
