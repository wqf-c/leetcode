package Hot100;

/**
 * @author wqf
 * @date 2021/3/25 21:17
 * @Email:284660487@qq.com
 */
public class Solution72 {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for(int i = 1; i < word2.length() + 1; ++i){
            dp[0][i] = i;
        }
        for(int i = 1; i < word1.length() + 1; ++i){
            dp[i][0] = i;
        }
        for(int i = 1; i < word1.length() + 1; ++i){
            for(int j = 1; j < word2.length() + 1; ++j){
                dp[i][j] = Math.min(dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1),
                        Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[word1.length()][word2.length()];
    }
//"sea"
//        "eat"
}
