package Hot100;

import java.util.*;

/**
 * @author wqf
 * @date 2021/2/27 18:07
 * @Email:284660487@qq.com
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; ++i){
            int first = nums[i];
            int target = 0 - first;
            if(set.contains(first)) continue;
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; ++j){
                int other = target - nums[j];
                if(map.containsKey(other) && !set.contains(other) && !set.contains(nums[j])){
                    if(other != nums[j]){
                        if(!map.containsKey(nums[j])){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(other);
                            res.add(list);
                        }
                    }else{
                        if(map.get(other) == 1){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(other);
                            res.add(list);
                        }
                    }
                }
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            set.add(first);
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[nums.length - 1] < 0 || nums[0] > 0) return res;
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (right > left){
                boolean leftPlusFlag = false;
                boolean rightPlusFlag = false;
                if(target == nums[left] + nums[right]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    leftPlusFlag = true;
                    rightPlusFlag = true;
                }else if(target > nums[left] + nums[right]){
                    leftPlusFlag = true;
                }else{
                    rightPlusFlag = true;
                }
                if(leftPlusFlag){
                    int curLeft = nums[left];
                    while (nums[left] <= curLeft && left < right){
                        left++;
                    }
                }
                if(rightPlusFlag){
                    int curRight = nums[right];
                    while (nums[right] >= curRight && right > left){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
