package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/3/19 11:06
 * @Email:284660487@qq.com
 */
public class Solution46 {

    List<List<Integer>> rst = null;
    public List<List<Integer>> permute(int[] nums) {
        rst = new ArrayList<>();
        if(nums == null || nums.length == 0) return rst;

        dfs(new boolean[nums.length], nums, nums.length, new ArrayList<>());
        return rst;
    }

    public void dfs(boolean[] used, int[] nums, int restNum, List<Integer> list){
        if(restNum == 0) {
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            rst.add(l);
            return;
        }
        for(int i = 0; i < used.length; ++i){
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                dfs(used, nums, restNum - 1, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
