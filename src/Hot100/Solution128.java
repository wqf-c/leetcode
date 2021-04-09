package Hot100;

import java.util.*;

/**
 * @author wqf
 * @date 2021/4/5 20:21
 * @Email:284660487@qq.com
 */
public class Solution128 {

    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(!map.containsKey(nums[i])){
                if(map.containsKey(nums[i] + 1)){
                    map.put(nums[i], map.get(nums[i] + 1) + 1);
                }else{
                    map.put(nums[i], 1);
                }
                int temp = nums[i] - 1;
                int cur = map.get(nums[i]);
                if(cur > max) max = cur;
                while (map.containsKey(temp)){
                    if(++cur > max) max = cur;
                    map.put(temp, cur);
                    temp--;
                }
            }
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        int max = 1;
        Arrays.sort(nums);
        int temp = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] - nums[i - 1] == 1){
                temp++;
                if(temp > max) max = temp;
            }else if(nums[i] == nums[i - 1]){

            } else {
                temp = 1;
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            if(!set.contains(num - 1)){
                int right = num + 1, rightLen = 0;
                while (set.contains(right)){
                    right++;
                    rightLen++;
                }
                int curMax = rightLen + 1;
                max = Math.max(max, curMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

}
