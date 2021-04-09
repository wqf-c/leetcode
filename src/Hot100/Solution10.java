package Hot100;

/**
 * @author wqf
 * @date 2021/2/23 0:22
 * @Email:284660487@qq.com
 */
public class Solution10 {

    public boolean isMatch(String s, String p){
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); ++i){
            if(p.charAt(i - 1) == '*' && i >= 2 && dp[0][i - 2]) dp[0][i] = true;
        }
        for(int i = 1; i <= s.length(); ++i){
            for(int j = 1; j <= p.length(); ++j){
                if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    if(j >= 2 && p.charAt(j - 2) != '.' && p.charAt(j - 2) != s.charAt(i - 1)){
                        dp[i][j] = dp[i][j - 2];
                        continue;
                    }else{
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
