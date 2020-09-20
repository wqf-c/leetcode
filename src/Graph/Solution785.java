package Graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/9/20 14:52
 * @Email:284660487@qq.com
 */
public class Solution785 {

    boolean[] visited = null;

    public boolean isBipartite_bfs(int[][] graph) {
        visited = new boolean[graph.length];
        while (true) {
            int bfsIndex = -1;
            for(int i = 0; i < graph.length; ++i){
                if(!visited[i]){
                    bfsIndex = i;
                    break;
                }
            }
            if(bfsIndex == -1) break;
            else{
                boolean res = bfs(graph, bfsIndex);
                if(!res) return false;
            }
        }
        return true;
    }

    boolean bfs(int[][] graph, int startIndex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);
        boolean[] colors = new boolean[graph.length];
        colors[startIndex] = true;
        while (!queue.isEmpty()){
            int curIndex = queue.poll();
            boolean curColor = colors[curIndex];
            visited[curIndex] = true;
            for(int nei : graph[curIndex]){
                if(!visited[nei]){
                    queue.offer(nei);
                    colors[nei] = !curColor;
                }
                else{
                    if(colors[nei] == curColor) return false;
                }
            }
        }
        return true;
    }

    boolean[] colors = null;

    public boolean isBipartite_dfs(int[][] graph){
        visited = new boolean[graph.length];
        colors = new boolean[graph.length];
        while (true) {
            int dfsIndex = -1;
            for(int i = 0; i < graph.length; ++i){
                if(!visited[i]){
                    dfsIndex = i;
                    break;
                }
            }
            if(dfsIndex == -1) break;
            else{
                colors[dfsIndex] = false;
                visited[dfsIndex] = true;
                boolean res = dfs(graph, dfsIndex);
                if(!res) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int dfsIndex){
        for(int nei : graph[dfsIndex]){
            if(!visited[nei]){
                visited[nei] = true;
                colors[nei] = ! colors[dfsIndex];
                boolean flag = dfs(graph, nei);
                if(!flag) return false;
            }else{
                if(colors[nei] == colors[dfsIndex]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] graph = {{4},{},{4},{4},{0,2,3}};
        Solution785 s = new Solution785();
        s.isBipartite_bfs(graph);
    }
}
