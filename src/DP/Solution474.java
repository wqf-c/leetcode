package DP;

/**
 * @author wqf
 * @date 2020/10/25 10:12
 * @Email:284660487@qq.com
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] strsMap = new int[strs.length][2];
        for(int i = 0; i < strs.length; ++i){
            String str = strs[i];
            int one = 0;
            int zero = 0;
            for(char c : str.toCharArray()){
                if(c == '1') one++;
                else zero++;
            }
            strsMap[i][0] = zero;
            strsMap[i][1] = one;
        }
        for(int i = 0; i < strs.length; ++i){
            int zero = strsMap[i][0];
            int one = strsMap[i][1];
            //必须从后往前遍历，否者数据会被这一次循环的数据影响
            for(int j = m; j >= zero; --j){
                for(int k = n; k >= one; --k){

                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        Solution474 solution474 = new Solution474();
        String[] strs = new String[5];
        strs[0] = "10";
        strs[1] = "0001";
        strs[2] = "111001";
        strs[3] = "1";
        strs[4] = "0";
        System.out.println(solution474.findMaxForm(strs, 5, 3));
    }

}
