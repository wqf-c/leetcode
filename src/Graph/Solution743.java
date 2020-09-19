package Graph;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wqf
 * @date 2020/9/18 8:15
 * @Email:284660487@qq.com
 */
public class Solution743 {

    //迪杰斯特拉算法
    boolean[] visited = null;
    int[] dis = null;
    int[][] graph = null;

    public int networkDelayTime(int[][] times, int N, int K) {
        visited = new boolean[N + 1];
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; ++i){
            for(int j = 1; j < N + 1; ++j){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] time : times){
            graph[time[0]][time[1]] = time[2];
        }
        int min = Integer.MIN_VALUE;
        visited[K] = true;
        dis[K] = 0;
        update(K);
        while (true){
            int index = getNext();
            if(index == -1) break;
            update(index);
        }
        for(int i = 1; i < visited.length; ++i){
            if(!visited[i]) return -1;
        }
        for(int i = 1; i < dis.length; ++i){
            int d = dis[i];
            if(d > min){
                min = d;
            }
        }
        return min;
    }

    public void update(int index){
        int value = Integer.MAX_VALUE;
        for(int i = 1; i < graph[index].length; ++i){
            if(!visited[i] && graph[index][i] < value){
                int len = dis[index] + graph[index][i];
                if(len < dis[i]) dis[i] = len;
            }
        }
    }

    public int getNext(){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 1; i < dis.length; ++i){
            if(!visited[i] && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        if(index != -1) visited[index] = true;
        return index;
    }

    public int networkDelayTime_floyd(int[][] times, int N, int K){
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 1; i < N + 1; ++i){
            for(int j = 1; j < N + 1; ++j){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] time : times){
            graph[time[0]][time[1]] = time[2];
        }

        for(int i = 1; i <= N; ++i){
            for(int j = 1; j <= N; ++j){
                if(graph[K][i] != Integer.MAX_VALUE && graph[i][j] != Integer.MAX_VALUE){
                    int len = graph[K][i] + graph[i][j];
                    if(len < graph[K][j]) graph[K][j] = len;
                }
            }
        }
        int max = 0;
        for(int i = 1; i < graph[K].length; ++i){
            if(graph[K][i] == Integer.MAX_VALUE) return -1;
            else if(graph[K][i] > max) max = graph[K][i];
        }
        return max;
    }


    public static void main(String[] args){
        Solution743 s = new Solution743();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        s.networkDelayTime_floyd(times, 4, 2);
    }
}
