package Array;

/**
 * @author wqf
 * @date 2020/9/29 22:48
 * @Email:284660487@qq.com
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target){
            return res;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                res[0] = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if(res[0] == -1) return res;
        left = res[0] + 1;
        right = nums.length - 1;
        if(left == nums.length || nums[left] != target){
            res[1] = res[0];
            return res;
        }
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                res[1] = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return res;
    }

    public static void main(String[] args){
        Solution34 s32 = new Solution34();
        s32.searchRange(new int[]{3, 3, 3}, 3);
    }


}
