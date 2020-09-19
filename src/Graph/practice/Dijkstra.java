package Graph.practice;


import java.util.Arrays;

/**
 * @author wqf
 * @date 2020/9/19 16:28
 * @Email:284660487@qq.com
 */
public class Dijkstra {

    //从一个点到其他点的最短路径

    char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
    int[][] matrix = null;
    boolean[] visited = null;
    int[] dis = null;
    int[] pre_visit = null;

    void dsj(){
        //邻接矩阵
        matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        int start = 6;
        visited = new boolean[vertex.length];
        dis = new int[vertex.length];
        pre_visit = new int[vertex.length];
        Arrays.fill(dis, N);
        dis[start] = 0;
        visited[start] = true;
        update(start);
        while (true){
            int next = getNext();
            if(next == -1) break;
            update(next);
        }
        for(int i = 0; i < vertex.length; ++i){
            System.out.println(dis[i]);
        }
    }

    void update(int index){
        int len = 0;
        for(int i = 0; i < matrix[index].length; ++i){
            len = dis[index] + matrix[index][i];
            if(!visited[i] && len < dis[i]){
                dis[i] = len;
                pre_visit[i] = index;
            }
        }
    }

    int getNext(){
        int min = 65535, index = -1;
        for(int i = 0; i < vertex.length; ++i){
            if(!visited[i] && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        if(index != -1) visited[index] = true;
        return index;
    }

    public static void main(String[] args){
        Dijkstra dsj = new Dijkstra();
        dsj.dsj();
    }
}
