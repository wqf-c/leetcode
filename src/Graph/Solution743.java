package Graph;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author wqf
 * @date 2020/9/18 8:15
 * @Email:284660487@qq.com
 */
public class Solution743 {

    //深度优先遍历
    boolean[] visited = null;
    int[][] graph = null;
    boolean[] find = null;
    public void init(int size, int[][] times){
        visited = new boolean[size];
        find = new boolean[size];
        graph = new int[size][size];
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                graph[i][j] = -1;
            }
        }
        for(int[] time : times){
            int start = time[0];
            int end = time[1];
            int cost = time[2];
            graph[start][end] = cost;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        init(N + 1, times);
        int result = dfs(graph, visited, K);
        for(int i = 1; i <= N; ++i){
            if(!find[i]) return -1;
        }
        return result;
    }

    public int dfs(int[][] graph, boolean[] visited, int cur){
        visited[cur] = true;
        find[cur] = true;
        int max = 0;
        for(int i = 1; i < graph.length; ++i){
            if(graph[cur][i] >= 0 && !visited[i]){
                int temp = dfs(graph, visited, i) + graph[cur][i];
                if(temp > max) max = temp;
            }
        }
        visited[cur] = false;
        return max;
    }

    public static void main(String[] args){
        Solution743 s = new Solution743();
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        s.networkDelayTime(times, 3, 1);
    }
}
