package Graph.practice;

/**
 * @author wqf
 * @date 2020/9/19 11:29
 * @Email:284660487@qq.com
 */
public class prim {
    //最小生成树 解决修路问题（在村庄间修路，怎么样修的路最短）

    void prim(){
        int[][] graph = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        int size = graph.length;
        boolean[] visited = new boolean[size];
        //从第一个节点开始
        visited[0] = true;

        //size个点 有size-1个边
        int min = 10000;
        int h1 = -1;
        int h2 = -1;
        for(int i = 0; i < size - 1; ++i){
            for(int j = 0; j < size; ++j){
                for(int k = 0; k < size; ++k){
                    if(visited[j] && !visited[k] && graph[j][k] < min){
                        min = graph[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }

            System.out.println((char)(h1 + 'A') + "===>" + (char)(h2 + 'A') + "   " + min);
            min = 10000;
            visited[h2] = true;
        }
    }

    public static void main(String[] args){
        prim p = new prim();
        p.prim();
    }
}
