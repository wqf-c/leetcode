package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/30 9:07
 * @Email:284660487@qq.com
 */
public class Solution39 {

    //2ms 99.93%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if(candidates[0] > target) return res;
        function(candidates, target, current, res, 0);
        return res;
    }

    public void function(int[] candidates, int rest, List<Integer> current, List<List<Integer>> res, int currentIndex){

        if(rest < 0) return;
        if(rest == 0){
            List<Integer> list = new ArrayList<>();
            list.addAll(current);
            res.add(list);
            return;
        }
        if(currentIndex >= candidates.length) return;
        if(rest < candidates[currentIndex]) return;
        current.add(candidates[currentIndex]);
        function(candidates, rest - candidates[currentIndex], current, res, currentIndex);
        current.remove(current.size() - 1);
        function(candidates, rest, current, res, currentIndex + 1);

    }

    public static void main(String[] args){
        Solution39 s39 = new Solution39();
        s39.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
