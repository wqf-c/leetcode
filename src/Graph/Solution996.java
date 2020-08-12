package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wqf
 * @date 2020/8/11 2:10
 * @Email:284660487@qq.com
 */
public class Solution996 {

    HashMap<Integer, Integer> count = null;
    HashMap<Integer, List<Integer>> graph = null;

    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        count = new HashMap<>();
        graph = new HashMap<>();
        for(int num : A){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for(int key : count.keySet()){
            graph.put(key, new ArrayList<>());
        }
        for(int key1 : count.keySet()){
            for(int key2 : count.keySet()){
                if(judge(key1 + key2)){
                    graph.get(key1).add(key2);
                }
            }
        }
        int ans = 0;
        for(int x : count.keySet()){
            ans += dfs(x, N - 1);
        }
        return ans;
    }

    public int dfs(int x, int todo){
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if(todo > 0){
            ans = 0;
            for(int y : graph.get(x)){
                if(count.get(y) > 0){
                    ans += dfs(y, todo - 1);
                }
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

    public boolean judge(int number){
        int num = (int)Math.sqrt(number + 0.5);
        return num * num == number;
    }

    public static void main(String[] args){
        int[] A = new int[]{1, 1, 5, 3};
        new Solution996().numSquarefulPerms(A);
    }
}
