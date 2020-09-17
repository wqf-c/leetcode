package Graph;

/**
 * @author wqf
 * @date 2020/8/12 18:08
 * @Email:284660487@qq.com
 */
public class Solution685 {

    //并查集
    int[] ancestors = null;
    int[] parent = null;
    int conflict = -1;
    int cycle = -1;

    public void init(int size){
        ancestors = new int[size];
        parent = new int[size];
        for(int i = 0; i < size; ++i){
            ancestors[i] = -1;
            parent[i] = i;
        }
    }

    int find_root(int x){
        int x_root = x;
        while (ancestors[x_root] != -1){
            x_root = ancestors[x_root];
        }
        return x_root;
    }

    boolean union_vertices(int x, int y){
        int x_root = find_root(x);
        int y_root = find_root(y);
        if(x_root == y_root) return true;
        ancestors[x_root] = y_root;
        return false;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] res = new int[2];
        int size = edges.length;
        init(size + 1);
        for(int i = 0; i < edges.length; ++i){
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if(parent[node2] != node2){
                conflict = i;
            }else{
                parent[node2] = node1;
                if(union_vertices(node1 - 1, node2 - 1)){
                    cycle = i;
                }
            }
        }
        if(conflict == -1){
            res[0] = edges[cycle][0];
            res[1] = edges[cycle][1];
        }else{
            if(cycle == -1){
                res[0] = edges[conflict][0];
                res[1] = edges[conflict][1];
            }else{
                res[0] = parent[edges[conflict][1]];
                res[1] = edges[conflict][1];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution685 s = new Solution685();
        int[][] edges = new int[4][2];
        edges[0][0] = 2;
        edges[0][1] = 1;
        edges[1][0] = 3;
        edges[1][1] = 1;
        edges[2][0] = 4;
        edges[2][1] = 2;
        edges[3][0] = 1;
        edges[3][1] = 4;
        s.findRedundantDirectedConnection(edges);
    }

}
