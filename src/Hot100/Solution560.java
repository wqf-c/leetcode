package Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/4/26 23:53
 * @Email:284660487@qq.com
 */
public class Solution560 {

    public int subarraySum(int[] nums, int k) {
        int rst = 0;
        for(int i = 0; i < nums.length; ++i){
            int stand = nums[i];
            if(stand == k){
                rst++;
            }
            for (int j = i + 1; j < nums.length; ++j){
                stand += nums[j];
                if(stand == k){
                    rst++;
                }
            }
        }
        return rst;
    }

    public int subarraySum1(int[] nums, int k) {
        int rst = 0;
        int[] sums = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            sums[i] = sum;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < sums.length; ++i){
            int need = sums[i] - k;
            rst += map.getOrDefault(need, 0);
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        solution560.subarraySum1(new int[]{1, 1, 1, 2}, 2);
    }

}
