package Bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/12/4 17:40
 * @Email:284660487@qq.com
 */
public class Solution1319 {

    public int makeConnected(int n, int[][] connections) {
        int connSize = connections.length;
        if(connSize < n - 1) return -1;
        boolean[] visited = new boolean[n];
        List<Integer>[] lists = new List[n];
        for(int i = 0; i < n; ++i){
            lists[i] = new ArrayList<>();
        }
        for(int[] connection : connections){
            lists[connection[0]].add(connection[1]);
            lists[connection[1]].add(connection[0]);
        }
        int rst = 0;
        for(int i = 0; i < n; ++i){
            if(!visited[i]){
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()){
                    int current = queue.poll();
                    for(int next : lists[current]){
                        if(!visited[next]){
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
                rst++;
            }
        }
        return rst-1;
    }

}
