package String;

/**
 * @author wqf
 * @date 2020/10/12 15:47
 * @Email:284660487@qq.com
 */
public class Solution32 {

    public int longestValidParentheses(String s) {
        int max = 0;
        if(s == null || s.length() == 1 || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length; ++i){
            if(chars[i] == ')'){
                if(chars[i - 1] == '(') dp[i] = 2 + (i > 1 ? dp[i - 2] : 0);
                else {
                    if(i - dp[i - 1] - 1 >= 0){
                        dp[i] = (chars[i - dp[i - 1] - 1] == '(' ? dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) : 0) ;
                    }else{
                        dp[i] = 0;
                    }

                }
            }else{
                dp[i] = 0;
            }
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args){
        Solution32 s = new Solution32();
        s.longestValidParentheses("()()))))()()(");
    }
}
