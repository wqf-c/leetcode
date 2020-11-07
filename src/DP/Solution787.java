package DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2020/10/29 22:55
 * @Email:284660487@qq.com
 */
public class Solution787 {

    //dfs
    int[][] graph;
    int[][] visited;
    int k;
    int min = -1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(src == dst) return 0;
        graph = new int[n][n];
        k = K;
        visited = new int[n][2];

        for(int[] flight : flights){
            graph[flight[0]][flight[1]] = flight[2];
        }
        for(int i = 0; i < graph[src].length; ++i){
            if(graph[src][i] > 0 ){
                dfs(i, dst, 1, graph[src][i]);
            }
        }
        return min;
    }

    public void dfs(int cur, int dst, int step, int curCost){
        int preStep = visited[cur][0];
        int preCost = visited[cur][1];
        if(visited[cur][0] == 0 || (visited[cur][0] != 0 && step < preStep && curCost < preCost)) {
            visited[cur][0] = step;
            visited[cur][1] = curCost;
        }
        if(step > k + 1) return;
        if(min != -1 && curCost > min) return;
        if(cur == dst){
            if(min == -1) min = curCost;
            if(curCost < min)  min = curCost;
            return;
        }
        for(int i = 0; i < graph[cur].length; ++i){
            if(graph[cur][i] > 0 && (preStep == 0 || step < preStep || curCost < preCost)){
                dfs(i, dst, step + 1, curCost + graph[cur][i]);
            }
        }
    }


    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K){
        int[][] dp = new int[n][K + 2];
        for(int i = 0; i < n; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i = 0; i < K + 2; ++i) dp[src][i] = 0;
        for(int i = 1; i < K + 2; ++i){
            for(int[] flight : flights){
                if(dp[flight[0]][i - 1] != Integer.MAX_VALUE){
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i - 1] + flight[2]);
                }
            }
        }
        return dp[dst][K + 1] != Integer.MAX_VALUE ? dp[dst][K + 1] : -1;
    }

    public static void main(String[] args){
        Solution787 solution787 = new Solution787();
        System.out.println(solution787.findCheapestPrice(3, new int[][]{{0,1,100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }
}
