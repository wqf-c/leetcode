package Hot100;

/**
 * @author wqf
 * @date 2021/4/27 0:21
 * @Email:284660487@qq.com
 */
public class Solution581 {

    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] < nums[i - 1]){
                left = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 1; --i){
            if(nums[i] < nums[i - 1]){
                right = i;
                break;
            }
        }
        if(left == -1 && right == -1){
            return 0;
        }

        int min = nums[left], max = nums[left];
        for(int i = left + 1; i <= right; ++i){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        if(right < nums.length - 1){
            min = Math.min(min, nums[right + 1]);
        }
        if(left > 0){
            max = Math.max(max, nums[left - 1]);
        }
        int lleft = -1, rright = -1;
        for(int i = 0; i < left; ++i){
            if(nums[i] >= min){
                lleft = nums[i] > min ? i : i + 1;
                break;
            }
        }
        if(lleft == -1) lleft = left;
        for(int i = right + 1; i < nums.length; ++i){
            if(nums[i] >= max){
                rright = i -1;
                break;
            }
        }
        if(rright == -1) rright = nums.length - 1;
        return rright - lleft + 1;
    }

    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        System.out.println(solution581.findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));
    }
}
