package CodeTop;

import java.util.Arrays;

/**
 * @author wqf
 * @date 2021/5/2 20:58
 * @Email:284660487@qq.com
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int[] position = new int[256];
        Arrays.fill(position, -1);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        position[chars[0]] = 0;
        int max = 1;
        for(int i = 1; i < s.length(); ++i){
            int pos = position[chars[i]];
            if(pos == -1){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = Math.min(dp[i - 1] + 1, i - pos);
            }
            if(dp[i] > max) max = dp[i];
            position[chars[i]] = i;
        }
        return max;
    }

}
