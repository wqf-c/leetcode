package CodeTop;

/**
 * @author wqf
 * @date 2021/5/21 23:09
 * @Email:284660487@qq.com
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[right]){
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] >= nums[left]){
                    if(target < nums[mid] && target >= nums[left]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else{
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
        }
        return  -1;
    }

}
