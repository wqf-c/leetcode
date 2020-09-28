package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author wqf
 * @date 2020/9/28 22:29
 * @Email:284660487@qq.com
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; ++i){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int delta = target - nums[i] - nums[j] - nums[k];
                if(Math.abs(min) > Math.abs(delta)) min = delta;
                if(delta == 0) return target;
                if(delta > 0) j++;
                if(delta < 0) k--;
            }
        }
        return target - min;
    }

    public static void main(String[] args){
        Solution16 s16 = new Solution16();
        s16.threeSumClosest(new int[]{0, 2, 1, -3}, 1);
    }
}
