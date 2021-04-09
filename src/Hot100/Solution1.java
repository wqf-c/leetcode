package Hot100;

import java.util.HashMap;

/**
 * @author wqf
 * @date 2021/2/9 11:29
 * @Email:284660487@qq.com
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seat = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; ++i){
            int other = target - nums[i];
            if(seat.containsKey(other)){
                res[0] = seat.get(other);
                res[1] = i;
                break;
            }
            seat.put(nums[i], i);
        }
        return res;
    }
}
