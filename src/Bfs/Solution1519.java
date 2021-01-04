package Bfs;

import java.util.*;

/**
 * @author wqf
 * @date 2020/12/7 14:12
 * @Email:284660487@qq.com
 */
public class Solution1519 {

    int[] rst = null;
    // map 写出int[] 节省时间
    int[] map;
    char[] labels = null;
    List<Integer>[] graph = null;
    boolean[] visited = null;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        rst = new int[n];
        map = new int[26];
        this.labels = labels.toCharArray();
        graph = new List[n];

        for(int i = 0; i < n; ++i){
            graph[i] = new ArrayList<>();

        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited = new boolean[n];

        for(char c : this.labels){
            map[c - 'a'] = 0;
        }
        bfs(0);
        return rst;
    }

    public void bfs(int current){
        int before = map[labels[current] - 'a'];
        visited[current] = true;
        for(Integer next : graph[current]){
            if(!visited[next]) bfs(next);
        }
        int after = map[labels[current] - 'a'];
        rst[current] = after - before + 1;
        map[labels[current] - 'a'] = map[labels[current] - 'a'] + 1;
    }

}
