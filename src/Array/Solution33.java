package Array;

/**
 * @author wqf
 * @date 2020/9/29 13:03
 * @Email:284660487@qq.com
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    return binarySort(nums, left, mid, target);
                }else{
                    left = mid + 1;
                }
            }
            if(nums[mid] <= nums[right]){
                if(target >= nums[mid] && target <= nums[right]){
                    return binarySort(nums, mid, right, target);
                }else{
                    right = mid - 1;
                }
            }
        }
        return res;
    }

    public int binarySort(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
