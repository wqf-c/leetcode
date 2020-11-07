package DP;

/**
 * @author wqf
 * @date 2020/11/4 17:39
 * @Email:284660487@qq.com
 */
public class Solution487 {

    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0) return 0;
        int rst = 1;
        int[] dp = new int[p.length()];
        dp[0] = 1;
        char[] chars = p.toCharArray();
        int[] save = new int[26];
        save[chars[0] - 'a'] = 1;
        for(int i = 1; i < p.length(); ++i){
            if(chars[i] == chars[i - 1] + 1 || (chars[i] == 'a' && chars[i - 1] == 'z')){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 1;
            }
            if(dp[i] > save[chars[i] - 'a']){
                rst += dp[i] - save[chars[i] - 'a'];
                save[chars[i] - 'a'] = dp[i];
            }

        }
        return rst;
    }

    public static void main(String[] args){
        Solution487 solution487 = new Solution487();
        System.out.println(solution487.findSubstringInWraproundString("zab"));
    }

}
