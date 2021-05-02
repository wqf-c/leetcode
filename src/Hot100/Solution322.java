package Hot100;

import java.util.Arrays;

/**
 * @author wqf
 * @date 2021/4/21 0:57
 * @Email:284660487@qq.com
 */
public class Solution322 {
    int rst = -1;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; ++j){
                int cur = 0;
                if(i - coins[j] == 0){
                    cur = 1;
                }else if(i - coins[j] > 0 && dp[i - coins[j]] > 0){
                    cur = dp[i - coins[j]] + 1;
                }else{
                    cur = 0;
                }
                if(cur != 0 && cur < min){
                    min = cur;
                }
            }
            dp[i] = min != Integer.MAX_VALUE ? min : -1;
        }
        return dp[amount];
    }

    int[] memo;
    public int coinChange1(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }


    public boolean dfs(int[] coins, int coinsIndex, int coinNum, int rest){
        if(rest == 0){
            rst = coinNum;
            return true;
        }
        if(coinsIndex == -1){
            return false;
        }
        int max = rest / coins[coinsIndex];
        for(int i = max; i >= 0; --i){
            if(dfs(coins, coinsIndex - 1, coinNum + i, rest - i * coins[coinsIndex])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(new int[]{186,419,83,408}, 6249));
    }

}
