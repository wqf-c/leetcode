package Hot100;

import java.util.Arrays;

/**
 * @author wqf
 * @date 2021/3/12 23:17
 * @Email:284660487@qq.com
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] < nums[i + 1]){
                int tempI = i + 1;
                for(int k = i + 1; k < nums.length; ++k){
                    if(k == nums.length - 1 || (nums[k] > nums[i] && nums[k + 1] <= nums[i])){
                        tempI = k;
                        break;
                    }
                }
                int temp = nums[tempI];
                nums[tempI] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }

        }
        Arrays.sort(nums);
    }

}
