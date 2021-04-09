package Hot100;

/**
 * @author wqf
 * @date 2021/2/21 20:43
 * @Email:284660487@qq.com
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        int sLen = s.length();
        if(sLen == 0) return "";
        if(sLen == 1) return s;
        char[] chars = s.toCharArray();
        String rst = s.charAt(0) + "";
        int maxLen = 1;
        boolean[][] dp = new boolean[sLen][sLen];
        for(int i = 0; i < sLen - 1; ++i){
            dp[i][i] = true;
            dp[i][i + 1] = (chars[i] == chars[i + 1]);
            if(dp[i][i + 1] && maxLen == 1){
                maxLen = 2;
                rst = s.substring(i, i + 2);
            }
        }
        dp[s.length() - 1][s.length() - 1] = true;
        for(int i = 2; i < sLen; ++i){
            for(int j = 0; j < sLen - i; ++j){
                int x = j, y = i + j;
                if(chars[x] == chars[y] && dp[x + 1][y - 1]){
                    dp[x][y] = true;
                    int len = y - x + 1;
                    if(len > maxLen){
                        maxLen = len;
                        rst = s.substring(x, y + 1);
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args){
        System.out.println(new Solution5().longestPalindrome("aaaaa"));
    }

}
