package ReCall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/5 21:21
 * @Email:284660487@qq.com
 */
public class Solution131 {

    List<List<String>> rst = null;

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
            if(i < len - 1 && chs[i] == chs[i + 1]){
                dp[i][i + 1] = true;
            }
        }
        for(int length = 3; length <= len; ++length){
            for(int i = 0; i <= len - length; ++i){
                int j = i + length - 1;
                if(chs[i] == chs[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        rst = new ArrayList<>();
        dfs(new ArrayList<>(), chs, 0, dp);
        return rst;
    }

    public void dfs(List<String> list, char[] chs, int curIndex, boolean[][] dp){
        if(curIndex == chs.length){
            rst.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < dp.length; ++i){
            if(dp[curIndex][i]){
                list.add(new String(chs, curIndex, i - curIndex + 1));
                dfs(list, chs, i + 1, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        Solution131 solution131 = new Solution131();
        solution131.partition("efe");
    }
}
