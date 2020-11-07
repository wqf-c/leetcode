package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/11/1 13:06
 * @Email:284660487@qq.com
 */
public class Solution5555 {

    //dp
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        for(int i = 0; i < 5; ++i){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; ++i){
            //dp[i][0] 是指长度为i,首字母为'a'
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][3] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][4];
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }

    //bfs
    public int countVowelStrings_bfs(int n){
        int count = 0;
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        for(char c : chars){
            count += bfs(c, n);
        }
        return count;
    }

    public int bfs(char c, int n){
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        Queue<Character> queue = new LinkedList<>();
        queue.offer(c);
        while (!queue.isEmpty() && n > 1){
            int len = queue.size();
            for(int i = 0; i < len; ++i){
                Character character = queue.poll();
                for(char cc : chars){
                    if(cc >= character){
                        queue.offer(cc);
                    }
                }
            }
            n--;
        }
        return queue.size();
    }

    public static void main(String[] args){
        Solution5555 solution5555 = new Solution5555();
        System.out.println(solution5555.countVowelStrings_bfs(33));
    }
}
