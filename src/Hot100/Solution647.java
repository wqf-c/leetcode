package Hot100;

/**
 * @author wqf
 * @date 2021/5/2 17:57
 * @Email:284660487@qq.com
 */
public class Solution647 {

    public int countSubstrings(String s) {
        int rst = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i){
            dp[i][i] = true;
        }
        for(int i = s.length() - 1; i >= 0; --i){
            for(int j = i + 1; j < s.length(); ++j){
                if(j == i + 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if(dp[i][j]) rst++;
                    continue;
                }
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j]) rst ++;
            }
        }
        return rst;
    }

    //中心扩展
    public int countSubstrings1(String s) {
        int rst = 0;
        for(int i = 0; i < s.length(); ++i){
            for(int j = 0; j <= 1; ++j){
                int left = i, right = i + j;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    rst++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        System.out.println(solution647.countSubstrings("aaa"));
    }

}
