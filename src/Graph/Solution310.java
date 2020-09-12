package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wqf
 * @date 2020/9/12 16:58
 * @Email:284660487@qq.com
 */
public class Solution310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; ++i){
            degree[edges[i][0]] ++;
            degree[edges[i][1]] ++;
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i = 0; i < n; ++i){
            if(degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                int index = queue.poll();
                res.add(index);
                List<Integer> neighbors = graph.get(index);
                for(int neighbor : neighbors){
                    degree[neighbor] --;
                    if(degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
