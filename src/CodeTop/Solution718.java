package CodeTop;

/**
 * @author wqf
 * @date 2021/6/3 0:08
 * @Email:284660487@qq.com
 */
public class Solution718 {

    public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length][nums2.length];
        int max = 0;
        for(int i = 0; i < nums2.length; ++i){
            if(nums1[0] == nums2[i]){
                dp[0][i] = 1;
                max = 1;
            }
        }
        for(int i = 0; i < nums1.length; ++i){
            if(nums2[0] == nums1[i]){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < nums1.length; ++i){
            for(int j = 1; j < nums2.length; ++j){
                if(nums1[i] != nums2[j]){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max;
    }

    //滑动窗口

}
