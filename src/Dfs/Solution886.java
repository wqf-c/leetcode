package Dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/12/1 23:35
 * @Email:284660487@qq.com
 */
public class Solution886 {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] dislike : dislikes){
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for(int i = 1; i < N; ++i){
            if(colors[i] == 0){
                if(!dfs(graph, 1, colors, i)) return false;
            }
        }
        return true;
    }

    boolean dfs(List<Integer>[] graph, int color, int[] colors, int curr){
        if(colors[curr] != 0){
            return colors[curr] == color;
        }
        colors[curr] = color;
        for(int next : graph[curr]){
            if(!dfs(graph, color * -1, colors, next)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution886 solution886 = new Solution886();
        System.out.println(solution886.possibleBipartition(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}));
    }
}
