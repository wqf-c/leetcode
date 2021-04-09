package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2021/3/17 22:23
 * @Email:284660487@qq.com
 */
public class Solution39 {

    List<List<Integer>> rst;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rst = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), target, candidates, 0);
        return rst;
    }

    public void dfs(List<Integer> list, int target, int[] candidates, int candidateIndex){
        if(target == 0){
            List<Integer> r = new ArrayList<>();
            r.addAll(list);
            rst.add(r);
            return;
        }
        if(candidateIndex >= candidates.length) return;
        if(target < candidates[candidateIndex]) return;
        dfs(list, target, candidates, candidateIndex + 1);
        int size = target / candidates[candidateIndex];
        for(int i = 0; i < size; ++i){
            list.add(candidates[candidateIndex]);
            dfs(list, target - (i+1) * candidates[candidateIndex], candidates, candidateIndex + 1);
        }
        for(int i = 0; i < size; ++i){
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution39 solution39 = new Solution39();
        solution39.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

}
