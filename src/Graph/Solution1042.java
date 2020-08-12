package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author wqf
 * @date 2020/8/12 16:59
 * @Email:284660487@qq.com
 */
public class Solution1042 {

    HashMap<Integer, HashSet<Integer>> graph = null;
    int[] answer = null;
    public int[] gardenNoAdj(int N, int[][] paths) {
        graph = new HashMap<>();
        answer = new int[N];
        for(int i = 0; i < N; ++i){
            answer[i] = 0;
        }
        for(int i = 1; i <= N; ++i){
            graph.put(i, new HashSet<>());
        }
        for(int[] path : paths){
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        for(int i = 1; i <= answer.length; ++i){
            for(int j = 1; j <= 4; ++j){
                boolean flag = false;
                for(int x : graph.get(i)){
                    if(answer[x - 1] == j) flag = true;
                }
                if(!flag) answer[i - 1] = j;
            }
        }
        return answer;
    }

}
