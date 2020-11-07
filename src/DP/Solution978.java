package DP;

/**
 * @author wqf
 * @date 2020/10/26 22:24
 * @Email:284660487@qq.com
 */
public class Solution978 {

    public int maxTurbulenceSize(int[] A) {
        if(A.length == 0 || A == null) return 0;
        int[] dp = new int[A.length];
        dp[0] = 1;
        int max = 1;
        boolean flag = false;
        for(int i = 1; i < A.length; ++i){
            if(A[i] == A[i - 1]) {
                dp[i] = 1;
                continue;
            }
            boolean tempFlag = A[i] > A[i - 1];
            if(flag == !tempFlag) dp[i] = dp[i - 1] + 1;
            else dp[i] = 2;
            flag = tempFlag;
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args){
        Solution978 solution978 = new Solution978();
        solution978.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
    }
}
