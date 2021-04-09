package Hot100;

/**
 * @author wqf
 * @date 2021/3/15 10:23
 * @Email:284660487@qq.com
 */
public class Solution32 {

    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        int max = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for(int i = 1; i < s.length(); ++i){
            if(chars[i] == ')'){
                if(chars[i - 1] == '('){
                    if(i >= 2) dp[i] = dp[i - 2] + 2;
                    else dp[i] = 2;
                }else{
                    if(i - 1 - dp[i - 1] >= 0 && chars[i - 1 - dp[i - 1]] == '('){
                        dp[i] = dp[i - 1] + 2;
                        if(i - 2 - dp[i - 1] >= 0) dp[i] = dp[i] + dp[i - 2 - dp[i - 1]];
                    }
                }
                if(dp[i] > max) max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        Solution32 solution32 = new Solution32();
        solution32.longestValidParentheses("(()())");
    }

}
