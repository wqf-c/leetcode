package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/5/3 21:09
 * @Email:284660487@qq.com
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int other = target - nums[i];
            if (map.containsKey(other)) {
                rst[0] = map.get(other);
                rst[1] = i;
                return rst;
            }
            map.put(nums[i], i);
        }
        return rst;
    }

}
