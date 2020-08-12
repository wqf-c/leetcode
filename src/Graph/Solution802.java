package Graph;

import java.util.*;

/**
 * @author wqf
 * @date 2020/8/5 22:57
 * @Email:284660487@qq.com
 */
public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        int len = graph.length;
        int[] color = new int[len];
        for(int i = 0; i < len; ++i){
            if(dfs(color, i, graph)){
                list.add(i);
            }
        }
        return list;
    }

    boolean dfs(int[] color, int node, int[][] graph){
        if(color[node] > 0){
            return color[node] == 2;
        }
        color[node] = 1;
        for(int nei : graph[node]){
            if(color[nei] == 2) continue;
            if(color[nei] == 1 || !dfs(color, nei, graph)) return false;
        }
        color[node] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes1(int[][] G) {
        int N = G.length;
        boolean[] safe = new boolean[N];

        List<Set<Integer>> graph = new ArrayList();
        List<Set<Integer>> rgraph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            graph.add(new HashSet());
            rgraph.add(new HashSet());
        }

        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < N; ++i) {
            if (G[i].length == 0)
                queue.offer(i);
            for (int j: G[i]) {
                graph.get(i).add(j);
                rgraph.get(j).add(i);
            }
        }

        while (!queue.isEmpty()) {
            int j = queue.poll();
            safe[j] = true;
            for (int i: rgraph.get(j)) {
                graph.get(i).remove(j);
                if (graph.get(i).isEmpty())
                    queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList();
        for (int i = 0; i < N; ++i) if (safe[i])
            ans.add(i);

        return ans;
    }


    public static void main(String[] args){
        Solution802 s = new Solution802();
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        s.eventualSafeNodes(graph);
    }
}
