package CodeTop;

/**
 * @author wqf
 * @date 2021/6/13 0:19
 * @Email:284660487@qq.com
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text2.length(); ++i){
            if(text1.charAt(0) == text2.charAt(i)){
                dp[0][i] = 1;
            }else{
                dp[0][i] = i > 0 ? dp[0][i - 1] : 0;
            }
        }
        for (int i = 0; i < text1.length(); ++i){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = i > 0 ? dp[i - 1][0] : 0;
            }
        }
        for(int i = 1; i < text1.length(); ++i){
            for(int j = 1; j < text2.length(); ++j){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1] + 1);
                }else{
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]),dp[i - 1][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence("abcde", "ace"));
    }

}
