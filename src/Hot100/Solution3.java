package Hot100;

/**
 * @author wqf
 * @date 2021/2/19 22:19
 * @Email:284660487@qq.com
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int[] chars = new int[256];
        for(int i = 0; i < chars.length; ++i){
            chars[i] = -1;
        }
        int max = 1;
        dp[0] = 1;
        chars[s.charAt(0)] = 0;
        char[] sChars = s.toCharArray();
        for(int i = 1; i < sChars.length; ++i){
            int len = i - chars[sChars[i] ];
            dp[i] = len <= dp[i - 1] ? len : dp[i - 1] + 1;
            chars[sChars[i]] = i;
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args){
        Solution3 solution3 = new Solution3();
        solution3.lengthOfLongestSubstring("au");
    }
}
