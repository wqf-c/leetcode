package Hot100;

/**
 * @author wqf
 * @date 2021/4/18 12:18
 * @Email:284660487@qq.com
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            int m = 0;
            for(int j = i - 1; j >= 0; --j){
                if(nums[j] < nums[i] && m < dp[j]){
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
        //数组 d[i]表示长度为 i 的最长上升子序列的末尾元素的最小值
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

}
