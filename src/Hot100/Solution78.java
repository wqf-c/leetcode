package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/3/27 11:50
 * @Email:284660487@qq.com
 */
public class Solution78 {

    List<List<Integer>> rst = null;

    public List<List<Integer>> subsets(int[] nums) {
        rst = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return rst;
    }

    public void dfs(int[] nums, int index, List<Integer> list){
        if(index == nums.length){
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            rst.add(l);
            return;
        }
        dfs(nums, index + 1, list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        list.remove(list.size() - 1);
    }

}
