package Hot100;

/**
 * @author wqf
 * @date 2021/3/15 13:45
 * @Email:284660487@qq.com
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return binarySearch(nums, target, nums[0], nums[nums.length - 1]);
    }

    public int binarySearch(int[] nums, int target, int leftNum, int rightNum){
        if(rightNum > leftNum) return binary(nums, 0, nums.length - 1, target);
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
           if(nums[left] <= nums[mid]){
               if(target >= nums[left] && target <= nums[mid]) return binary(nums, left, mid, target);
               else left = mid + 1;
           }
           if(nums[mid] <= nums[right]){
               if(target >= nums[mid] && target <= nums[right]) return binary(nums, mid, right, target);
               else right= mid - 1;
           }
        }
        return -1;
    }

    public int binary(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{5, 1, 3}, 0));
    }

}
