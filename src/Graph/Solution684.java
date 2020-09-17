package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/16 7:56
 * @Email:284660487@qq.com
 */
public class Solution684 {

    //并查集
    int[] parents = null;
    int[] rank = null;

    public void init(int size){
        parents = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; ++i){
            parents[i] = -1;
            rank[i] = 0;
        }
    }

    int find_root(int x){
        int x_root = x;
        while (parents[x_root] != -1){
            x_root = parents[x_root];
        }
        return x_root;
    }

    boolean union_vertices(int x, int y){
        int x_root = find_root(x);
        int y_root = find_root(y);
        if(x_root == y_root) return true;
        if(rank[x_root] < rank[y_root]){
            parents[x_root] = y_root;
        }else if(rank[y_root] > rank[x_root]){
            parents[y_root] = x_root;
        }else{
            parents[x_root] = y_root;
            rank[y_root] = rank[y_root] + 1;
        }
        return false;
    }


    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int size = edges.length;
        init(size);
        for(int[] edge : edges){
            if(union_vertices(edge[0] - 1, edge[1] - 1)){
                res[0] = edge[0];
                res[1] = edge[1];
                break;
            }
        }
        return res;
    }

    //dfs
    boolean[] visited = null;
    List<List<Integer>> graph;

    void init_dfs(int[][] edge){
        int size = edge.length;
        visited = new boolean[size];
        graph = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < size; ++i){
            visited[i] = false;
            int a = edge[i][0] - 1;
            int b = edge[i][1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    boolean dfs(boolean[] visited, int begin, int end, List<List<Integer>> graph){
        if(graph.get(begin).contains(end)) return true;
        if(visited[begin]) return false;
        visited[begin] = true;
        for(int i = 0; i < graph.get(begin).size(); ++i){
            boolean f = dfs(visited, graph.get(begin).get(i), end, graph);
            if(f) {
                visited[begin] = false;
                return true;
            }
        }
        visited[begin] = false;
        return false;
    }

    public int[] findRedundantConnection_dfs(int[][] edges){
        int[] res = new int[2];
        init_dfs(edges);
        for(int[] edge : edges){
            int a = edge[0] - 1;
            Integer b = edge[1] - 1;
            graph.get(a).remove(b);
            if(dfs(visited, a, b, graph)){
                res[0] = a + 1;
                res[1] = b + 1;
            }
            graph.get(a).add(b);
        }
        return res;
    }

    public static void main(String[] args){
        Solution684 s = new Solution684();
        int[][] edges = new int[5][2];
        edges[0][0] = 1;
        edges[0][1] = 2;
        edges[1][0] = 2;
        edges[1][1] = 3;
        edges[2][0] = 3;
        edges[2][1] = 4;
        edges[3][0] = 1;
        edges[3][1] = 4;
        edges[4][0] = 1;
        edges[4][1] = 5;
        s.findRedundantConnection_dfs(edges);
    }
}
