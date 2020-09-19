package Graph.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wqf
 * @date 2020/9/19 12:00
 * @Email:284660487@qq.com
 */
public class Kruskal {

    //最小生成树   从小到大将边加入集合，前提条件是这些边不能形成闭环
    class Edge{
        int weight;
        int start;
        int end;

        public Edge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
    }

    //并查集 检查是否图里是否有回环
    class disSet{
        int[] root = null;
        int[] rank = null;

        public disSet(int size) {
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; ++i){
                root[i] = -1;
            }
        }

        public int findRoot(int x){
            int x_root = x;
            while (root[x_root] != -1){
                x_root = root[x_root];
            }
            return x_root;
        }

        public void union(int x, int y){
            int x_root = findRoot(x);
            int y_root = findRoot(y);
            if(x_root == y_root) return;
            if(rank[x_root] < rank[y_root]) root[x_root] = y_root;
            else if(rank[x_root] > rank[y_root]) root[y_root] = x_root;
            else {
                root[x_root] = y_root;
                rank[y_root] += 1;
            }
        }
    }

    public int krusal(Edge[] edges){
        Arrays.sort(edges, Comparator.comparingInt(a -> a.weight));
        disSet set = new disSet(100);
        int minCost = 0;
        for(Edge e : edges){
            int start = e.start;
            int end = e.end;
            int weight = e.weight;
            int start_root = set.findRoot(start);
            int end_root = set.findRoot(end);
            //不形成环
            if(start_root != end_root){
                set.union(start, end);
                minCost += weight;
                System.out.println((char)(start + 'A') + "====>" + (char)(end + 'A') + "    " + weight);
            }
        }
        return minCost;
    }
}
