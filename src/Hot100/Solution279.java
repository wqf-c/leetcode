package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/4/17 11:17
 * @Email:284660487@qq.com
 */
public class Solution279 {

    int rst = -1;

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = n; i >= 1; --i){
            int temp = (int) Math.sqrt(i);
            if(temp * temp == i){
                list.add(i);
            }
        }
        dfs(list, 0, n, 0);
        return rst;
    }

    void dfs(List<Integer> list, int listIndex, int target, int size){
        if(target == 0) {
            if(rst == -1 || size < rst) rst = size;
        }
        if(listIndex == list.size()) {
            return;
        }
        int curNum = list.get(listIndex);
        int time = target / curNum;
        for(int i = time; i >= 0; --i){
            dfs(list, listIndex + 1, target - i * curNum, size + i);
        }
    }

    public int numSquares1(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            int temp = (int) Math.sqrt(i);
            if(temp * temp == i){
                list.add(i);
            }
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            int min = 0;
            for(int j = 0; j < list.size(); ++j){
                if(list.get(j) > i){
                    break;
                }
                if(min == 0) min = dp[i - list.get(j)] + 1;
                else min = Math.min(min, 1 + dp[i - list.get(j)]);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(solution279.numSquares1(12));
    }

}
