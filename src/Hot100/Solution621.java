package Hot100;

import java.util.*;

/**
 * @author wqf
 * @date 2021/4/30 0:00
 * @Email:284660487@qq.com
 */
public class Solution621 {

    //选择不在冷却中且剩余执行次数最多的任务
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int time = 0;
        List<Integer> rest = new ArrayList<>();
        List<Integer> nextValid = new ArrayList<>();
        int m = map.size();
        for(Integer i : map.values()){
            nextValid.add(1);
            rest.add(i);
        }
        for(int i = 0; i < tasks.length; ++i){
            time++;
            int minTimeInterval = Integer.MAX_VALUE;
            for(int j = 0; j < m; ++j){
                if(rest.get(j) != 0 && nextValid.get(j) < minTimeInterval){
                    minTimeInterval = nextValid.get(j);
                }
            }
            time = Math.max(time, minTimeInterval);
            int best = -1;
            for(int j = 0; j < m; ++j){
                if(rest.get(j) != 0 && nextValid.get(j) <= time && (best == -1 ||  rest.get(j) >rest.get(best))){
                    best = j;
                }
            }
            rest.set(best, rest.get(best) - 1);
            nextValid.set(best, nextValid.get(best) + n + 1);
        }

        return time;
    }

    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();

        System.out.println(solution621.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F', 'G'}, 2));
    }

}
