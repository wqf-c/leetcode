package CodeTop;

import java.util.*;

/**
 * @author wqf
 * @date 2021/5/3 21:12
 * @Email:284660487@qq.com
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length - 2;){
            int first = nums[i];
            int target = -1 * first;
            map.clear();
            for(int j = i + 1; j < nums.length;){
                int second = target - nums[j];
                int third = nums[j];
                if(map.containsKey(second)){
                    int secondIndex = map.get(second);
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(second);
                    list.add(third);
                    rst.add(list);
                    map.put(third, j);
                    while (j < nums.length && nums[j] == third) j++;
                    continue;
                }
                map.put(third, j);
                ++j;
            }
            while (i < nums.length - 2 && nums[i] == first) i++;
        }
        return rst;
    }

}
