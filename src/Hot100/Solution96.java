package Hot100;

/**
 * @author wqf
 * @date 2021/4/2 0:27
 * @Email:284660487@qq.com
 */
public class Solution96 {

    public int numTrees1(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int numTrees(int n) {
        return func(0, n - 1);
    }

    public int func(int left, int right){
        if(left >= right) return 1;
        int sum = 0;
        for(int i = left; i <= right; ++i){
            int leftV = func(left, i - 1);
            int rightV = func(i + 1, right);
            sum += (leftV * rightV);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees1(2));
    }

}
